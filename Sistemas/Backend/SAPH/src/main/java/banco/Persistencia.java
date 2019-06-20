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

import modelo.SolicitacaoDelegacao;
import modelo.TipoSolicitacaoDelegacao;
import modelo.Usuario;

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

    public String cadastrar(Object objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            return "Cadastrado com sucesso!";
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return "Erro ao cadastrar!";
    }

    public String cadastrar(List<Object> objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            for (Object o : objeto) {
                em.persist(o);
            }
            em.getTransaction().commit();
            return "Cadastrado por lista com sucesso!";
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return "Erro ao cadastrar por lista!";
    }

    public String atualizar(Object objeto) {
        try {
            em = getPersistencia();
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
            return "Atualizado com sucesso!";
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return "Erro ao atualizar!";
    }

    public String remover(Object objeto, long id) {
        try {
            em = getPersistencia();
            objeto = em.find(objeto.getClass(), id);
            em.getTransaction().begin();
            em.remove(objeto);
            em.getTransaction().commit();
            return "Removido com sucesso!";
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return "Erro ao remover";
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

    public boolean selecionarUsuario(String email, String senha) {
        try {
            em = getPersistencia();
            Usuario usuario = (Usuario) em.createQuery(
                    "select u from Usuario u where u.email = :email and u.senha = :senha")
                    .setParameter("email", email)
                    .setParameter("senha", senha)
                    .getSingleResult();
            if (usuario != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return false;
    }
    public List<TipoSolicitacaoDelegacao> getTipoSolicitacaoDelegacao(String tipos) {
        try {
            em = getPersistencia();
            tipo.TipoSolicitacaoDelegacao enumSD = null;
            if(tipos.equals("SOLICITACAO")) {
            	enumSD = tipo.TipoSolicitacaoDelegacao.SOLICITACAO;
            }else if(tipos.equals("DELEGACAO")){
            	enumSD = tipo.TipoSolicitacaoDelegacao.DELEGACAO;
            }
            return em.createQuery(
                    "select tsd from TipoSolicitacaoDelegacao tsd where tsd.tipo = :tipo")
                    .setParameter("tipo", enumSD)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }
    public List<SolicitacaoDelegacao> getSolicitacaoDelegacao(String tipoSD,long solicitanteDelegante) {
        try {
            em = getPersistencia();
            tipo.TipoSolicitacaoDelegacao enumSD = null;
            if(tipoSD.equals("SOLICITACAO")) {
            	enumSD = tipo.TipoSolicitacaoDelegacao.SOLICITACAO;
            }else if(tipoSD.equals("DELEGACAO")){
            	enumSD = tipo.TipoSolicitacaoDelegacao.DELEGACAO;
            }
            return em.createQuery(
                    "select sd from SolicitacaoDelegacao sd where sd.tipoSolicitacaoDelegacao.tipo = :tipo and sd.solicitanteDelegante.id = :solicitanteDelegante")
                    .setParameter("tipo", enumSD)
                    .setParameter("solicitanteDelegante", solicitanteDelegante)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

}
