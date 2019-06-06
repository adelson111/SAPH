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
import modelo.SetorFuncionario;

/**
 *
 * @author andre
 */
public class SetorFuncionarioDao {
    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Persistencia");
        return factory.createEntityManager();
    }
    //salvar entidade
    public void salvar(SetorFuncionario setor_funcionario) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try {
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("begin");
            em.merge(setor_funcionario);
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
    public SetorFuncionario get(int id) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        SetorFuncionario setor_funcionario = null;
        try {
            //busca um produto do banco de dados,passando como parametro
            setor_funcionario = em.find(SetorFuncionario.class, id);
        } catch (Exception e) {
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        } finally {
            //encerra a conexão
            em.close();
        }
        //retorna produto
        return setor_funcionario;
    }
    //remover
    public void remover(SetorFuncionario setor_funcionario) {
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        //busca um produto no banco de dados, passando como parametro a sua classe e o id.
        setor_funcionario = em.find(SetorFuncionario.class, setor_funcionario.getId());
        try {
            //conecta ao banco
            em.getTransaction().begin();
            if (setor_funcionario != null) {
                //remove o produto
                em.remove(setor_funcionario);
                System.out.println("Setor/Funcionario removido");
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
    public List<SetorFuncionario> lista() {
        Query query = getEM().createQuery("select * from setor_funcionario");	
        return query.getResultList(); 	
    }
}
