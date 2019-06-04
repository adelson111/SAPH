/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Setor;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adelson
 */
public class SetorDao implements Serializable {
    public EntityManager getEntity() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        return factory.createEntityManager();
    }
    
    public void salvar(Setor se){
        //Obtemos uma EntityManager.
        EntityManager em = getEntity();
        try{
            //conecta ao banco
            em.getTransaction().begin();
            //salva o objeto produto
            System.out.println("Passou do begin");
            em.merge(se);
            System.out.println("Passou do merge");
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
