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
import modelo.TipoSolitacaoDelegacaoItem;

/**
 *
 * @author andre
 */
public class TipoSolicitacaoDelegacaoItemDao {
     public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(TipoSolitacaoDelegacaoItem tipo_solicitacao_delegacao_item) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.merge(tipo_solicitacao_delegacao_item);
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
    public TipoSolitacaoDelegacaoItem get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        TipoSolitacaoDelegacaoItem tipo_solicitacao_delegacao_item = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            tipo_solicitacao_delegacao_item = em.find(TipoSolitacaoDelegacaoItem.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return tipo_solicitacao_delegacao_item;
    }
    //remover
    public void remover(TipoSolitacaoDelegacaoItem tipo_solicitacao_delegacao_item) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        tipo_solicitacao_delegacao_item = em.find(TipoSolitacaoDelegacaoItem.class, tipo_solicitacao_delegacao_item.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (tipo_solicitacao_delegacao_item != null) {
                //remove o produto
                em.remove(tipo_solicitacao_delegacao_item);
                System.out.println("Tipo de Solicitação/Delegação Item removido");
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
    public List<TipoSolitacaoDelegacaoItem> lista() {
        Query query = getEM().createQuery("select * from tipo_solicitacao_delegacao_item");	
        return query.getResultList(); 	
    }
}
