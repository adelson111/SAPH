/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "nivel")
public class Nivel {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=30)
    private String nome;
    @Column
    private Nivel nivelSuperior;
    @Column
    private Nivel nivelInferior;
    @Column
    private Funcionario responsavel;
    @Column
    private Organizacao organizacao;

    public Nivel() {
    }

    public Nivel(int id, String nome, Nivel nivelSuperior, Nivel nivelInferior, Funcionario responsavel, Organizacao organizacao) {
        this.id = id;
        this.nome = nome;
        this.nivelSuperior = nivelSuperior;
        this.nivelInferior = nivelInferior;
        this.responsavel = responsavel;
        this.organizacao = organizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
