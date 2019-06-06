/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Item;

/**
 *
 * @author andre
 */
public class ItemDao {
     public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(Item item) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.merge(item);
            //executa o comando no banco de dados
            System.out.println("marge");
            em.getTransaction().commit();
            System.out.println("Cadastrado com Sucesso!");
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
    }
    //pegar entidade pelo id
    public Item get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        Item item = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            item = em.find(Item.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return item;
    }
    //remover
    public void remover(Item item) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        item = em.find(Item.class, item.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (item != null) {
                //remove o produto
                em.remove(item);
                System.out.println("Item removido");
            }
            //executa o comando no banco de dados
            em.getTransaction().commit();
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
    }
    //select
    public List<Item> lista() {
        Query query = getEM().createQuery("select * from item");	
        return query.getResultList(); 	
    }
}
