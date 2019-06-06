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
import modelo.SolicitacaoDelegacao;

/**
 *
 * @author andre
 */
public class SolicitacaoDelegacaoDao {
    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(SolicitacaoDelegacao solicitacao_delegacao) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.merge(solicitacao_delegacao);
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
    public SolicitacaoDelegacao get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        SolicitacaoDelegacao solicitacao_delegacao = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            solicitacao_delegacao = em.find(SolicitacaoDelegacao.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return solicitacao_delegacao;
    }
    //remover
    public void remover(SolicitacaoDelegacao solicitacao_delegacao) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        solicitacao_delegacao = em.find(SolicitacaoDelegacao.class, solicitacao_delegacao.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (solicitacao_delegacao != null) {
                //remove o produto
                em.remove(solicitacao_delegacao);
                System.out.println("Solicitação/Delegação removido");
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
    public List<SolicitacaoDelegacao> lista() {
        Query query = getEM().createQuery("select * from solicitacao_delegacao");	
        return query.getResultList(); 	
    }
}
