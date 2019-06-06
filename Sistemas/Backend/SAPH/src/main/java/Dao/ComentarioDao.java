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
import modelo.Comentario;

/**
 *
 * @author andre
 */
public class ComentarioDao {
    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(Comentario comentario) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.merge(comentario);
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
    public Comentario get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        Comentario comentario = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            comentario = em.find(Comentario.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return comentario;
    }
    //remover
    public void remover(Comentario comentario) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        comentario = em.find(Comentario.class, comentario.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (comentario != null) {
                //remove o produto
                em.remove(comentario);
                System.out.println("Comentario removido");
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
    public List<Comentario> lista() {
        Query query = getEM().createQuery("select * from comentario");	
        return query.getResultList(); 	
    }
}
