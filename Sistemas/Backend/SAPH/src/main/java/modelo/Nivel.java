/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author adelson
 */
public class Nivel {
    private String nome;
    private Nivel nivelSuperior;
    private Nivel nivelInferior;
    private Funcionario responsavel;
    private Organizacao organizacao;

    public Nivel() {
    }

    public Nivel(String nome, Nivel nivelSuperior, Nivel nivelInferior, Funcionario responsavel, Organizacao organizacao) {
        this.nome = nome;
        this.nivelSuperior = nivelSuperior;
        this.nivelInferior = nivelInferior;
        this.responsavel = responsavel;
        this.organizacao = organizacao;
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
