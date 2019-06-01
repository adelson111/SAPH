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
public class Organizacao {
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private boolean situacao;
    private String numeroNivel;

    public Organizacao() {
    }

    public Organizacao(String nome, String cnpj, String endereco, String telefone, boolean situacao, String numeroNivel) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.situacao = situacao;
        this.numeroNivel = numeroNivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getNumeroNivel() {
        return numeroNivel;
    }

    public void setNumeroNivel(String numeroNivel) {
        this.numeroNivel = numeroNivel;
    }
    
    
}
