/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Organizacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class OrganizacaoDao {
    public EntityManager getEM(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        return factory.createEntityManager();
    } 
    
    public void salvar(Organizacao organizacao){
        //Obtemos uma EntityManager.
        EntityManager em = getEM();
        try{
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            em.merge(organizacao);
            //executa o comando no banco de dados
            em.getTransaction().commit();
            System.out.println("Organização Cadastrado!");
        }catch(Exception e){
            //desfaz tudo caso ocorra uma exeção
            em.getTransaction().rollback();
        }finally{
            //encerra a conexão
            em.close();
        }
    }
}
