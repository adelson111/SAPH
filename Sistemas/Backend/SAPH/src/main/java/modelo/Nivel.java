/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

    @Id
    private long id;

    @Column(length = 80, nullable = false)
    private String nome;

    @OneToOne(targetEntity = Nivel.class)
    @JoinColumn(name = "nivel_superior_id")
    private Nivel nivelSuperior;

    @OneToOne(targetEntity = Nivel.class)
    @JoinColumn(name = "nivel_inferior_id")
    private Nivel nivelInferior;

    @ManyToOne(targetEntity = Funcionario.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Funcionario responsavel;

    @ManyToOne(targetEntity = Organizacao.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "organizacao_id", nullable = false)
    private Organizacao organizacao;
    
    @ManyToMany(targetEntity = TipoSolicitacaoDelegacao.class, fetch=FetchType.EAGER)
    private List<TipoSolicitacaoDelegacao> tipoSolicitacaoDelegacao;

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

    public Nivel getNivelSuperior() {
        return nivelSuperior;
    }

    public void setNivelSuperior(Nivel nivelSuperior) {
        this.nivelSuperior = nivelSuperior;
    }

    public Nivel getNivelInferior() {
        return nivelInferior;
    }

    public void setNivelInferior(Nivel nivelInferior) {
        this.nivelInferior = nivelInferior;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Organizacao getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(Organizacao organizacao) {
        this.organizacao = organizacao;
    }

}
