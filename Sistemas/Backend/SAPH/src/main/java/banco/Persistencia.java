/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Funcionario;
import modelo.Setor;
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
			System.out.println("Erro ao cadastrar - " + objeto.getClass().getName() + " : " + e.getMessage());
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

	public List selecionar(Object objeto) {
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
	public modelo.Setor getSetorByFuncionario(modelo.Funcionario funcionario){
		List<modelo.Setor> setores = selecionar(new modelo.Setor());
		for(modelo.Setor setor:setores) {
			if(setor.getFuncionarios().contains(funcionario)) {
				return setor;
			}
		}
		return null;
	}
	public modelo.Nivel getNivelBySetor(modelo.Setor setor){
		List<modelo.Nivel> niveis = selecionar(new modelo.Nivel());
		for(modelo.Nivel nivel:niveis) {
			if(nivel.getSetores().contains(setor)) {
				return nivel;
			}
		}
		return null;
	}
	
	private List<modelo.SolicitacaoDelegacao> enviadasForFuncionario(modelo.Funcionario funcionario,boolean solicitaca){
		List solicitacoesDelegacoes = new ArrayList();
		List<modelo.Funcionario> funcionarios =  selecionar(funcionario);
		
		for(modelo.Funcionario f:funcionarios) {
			long nivel = solicitaca?f.getIdNivelSuperior():f.getIdNivelInferior();
			if(nivel == funcionario.getNivel().getId()) {
				try {
					em = getPersistencia();
					solicitacoesDelegacoes.addAll(em
							.createQuery(String.valueOf(
									"select sd from SolicitacaoDelegacao sd where sd.solicitanteDelegante = :funcionario and sd.status != :status"))
							.setParameter("funcionario", f)
							.setParameter("status", tipo.TipoStatus.SALVA)
							.getResultList()
					);
				}catch(Exception e) {
					System.out.println("Erro ao selecionar: " + e.getMessage());
				}finally {
					if (em.isOpen()) {
						em.close();
					}
					emf.close();
				}
				
			}
		}
		return solicitacoesDelegacoes;
	}
	
	public List<modelo.SolicitacaoDelegacao> recebidas(long id, boolean solicitacao) {
		modelo.Funcionario funcionario = (Funcionario) selecionar(new modelo.Funcionario(), id);
		return enviadasForFuncionario(funcionario,solicitacao);
	}

	private Usuario autenticar(String email, String senha) {
		try {
			em = getPersistencia();
			return (Usuario) em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha")
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();
		} catch (Exception e) {
			System.out.println("Erro ao selecionar: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}

	public Funcionario selecionarUsuario(String email, String senha) {
		try {
			modelo.Usuario usuario = autenticar(email, senha);
			em = getPersistencia();
			return (Funcionario) em.createQuery("select f from Funcionario f where f.usuario = :usuario")
					.setParameter("usuario", usuario).getSingleResult();
		} catch (Exception e) {
			System.out.println("Erro ao selecionar: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}

	public List<TipoSolicitacaoDelegacao> getTipoSolicitacaoDelegacao(tipo.TipoSolicitacaoDelegacao tipo) {
		try {
			em = getPersistencia();
			return em.createQuery("select tsd from TipoSolicitacaoDelegacao tsd where tsd.tipo = :tipo")
					.setParameter("tipo", tipo).getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao selecionar: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}
	
	public List<SolicitacaoDelegacao> getSolicitacaoDelegacao(tipo.TipoSolicitacaoDelegacao tipo, long solicitanteDelegante) {
		try {
			em = getPersistencia();
			return em.createQuery(
					"select sd from SolicitacaoDelegacao sd where sd.tipoSolicitacaoDelegacao.tipo = :tipo and sd.solicitanteDelegante.id = :solicitanteDelegante")
					.setParameter("tipo", tipo).setParameter("solicitanteDelegante", solicitanteDelegante)
					.getResultList();
		} catch (Exception e) {
			System.out.println("Erro ao selecionar: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
		return null;
	}
	
	public List<modelo.Comentario> comentarios(modelo.SolicitacaoDelegacao solicitacaoDelegacao){
		try {
		em = getPersistencia();
			return em.createQuery(
					"select c from Comentario c where c.solicitacaoDelegacao = :solicitacaoDelegacao")
					.setParameter("solicitacaoDelegacao", solicitacaoDelegacao)
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
