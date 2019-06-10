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

import modelo.Organizacao;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

/**
 *
 * @author andre
 */
public class OrganizacaoDao {

    public EntityManager getEM() {
        System.out.println("Chegou no metodo");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
        System.out.println("Criaou o link");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(Organizacao organizacao) {
        System.out.println("Chegou salvar");
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        System.out.println("Passou da persistencia.");
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.persist(organizacao);
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
    public Organizacao get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        Organizacao org = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            org = em.find(Organizacao.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return org;
    }
    //remover
    public void remover(Organizacao org) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        org = em.find(Organizacao.class, org.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (org != null) {
                //remove o produto
                em.remove(org);
                System.out.println("Organização removida");
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
    public List<Organizacao> lista() {
        Query query = getEM().createQuery("select * from organizacao");	
        return query.getResultList(); 	
    }
}
