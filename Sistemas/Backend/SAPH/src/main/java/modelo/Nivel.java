/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import banco.Persistencia;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    @Id
    private long id;

    @Column(length = 80)
    private String nome;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "nivel_superior_id")
    @Column(name = "nivel_superior_id")
    private long nivelSuperior;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "nivel_inferior_id")
    @Column(name = "nivel_inferior_id")
    private long nivelInferior;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Funcionario responsavel;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivel_id")
    private List<Setor> setores;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tipo_nivel_solicitacao_delegacao", 
            joinColumns = {@JoinColumn(name = "nivel_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "tipo_solicitacao_delegacao_id")})
    private List<TipoSolicitacaoDelegacao> tipoSolicitacoesDelegacoes;

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNivelSuperior() {
        return nivelSuperior;
    }

    public void setNivelSuperior(long nivelSuperior) {
        this.nivelSuperior = nivelSuperior;
    }

    public long getNivelInferior() {
        return nivelInferior;
    }

    public void setNivelInferior(long nivelInferior) {
        this.nivelInferior = nivelInferior;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public List<TipoSolicitacaoDelegacao> getTipoSolicitacoesDelegacoes() {
        return tipoSolicitacoesDelegacoes;
    }

    public void setTipoSolicitacoesDelegacoes(List<TipoSolicitacaoDelegacao> tipoSolicitacoesDelegacoes) {
        this.tipoSolicitacoesDelegacoes = tipoSolicitacoesDelegacoes;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nivel other = (Nivel) obj;
		if (id != other.id)
			return false;
		return true;
	}

    
    
}
