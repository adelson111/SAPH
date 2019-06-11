/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adelson
 */
public class Persistencia {

    private EntityManagerFactory emf;
    private EntityManager em;

    private EntityManager getPersistencia() {
        emf = Persistence.createEntityManagerFactory("persistencia");
        return emf.createEntityManager();
    }

    public void cadastrar(Object objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void cadastrar(List<Object> objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            for (Object o : objeto) {
                em.persist(o);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void atualizar(Object objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void remover(Object objeto, long id) {
        try {
            em = getPersistencia();
            objeto = em.find(objeto.getClass(), id);
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Object selecionar(Object objeto, long id) {
        try {
            em = getPersistencia();
            return em.find(objeto.getClass(), id);
        } catch (Exception e) {
            System.out.println("Erro ao selecionar por id: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

    public List<Object> selecionar(Object objeto) {
        try {
            em = getPersistencia();
            return em.createQuery(String.valueOf("from " + objeto.getClass().getName() + " objeto")).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

}
