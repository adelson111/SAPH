/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
<<<<<<< HEAD
@Table(name = "tb_organizacao")
public class Organizacao implements Serializable {
    private static final long serialVersionUID = 1L;
=======
@Table(name = "organizacao")
public class Organizacao {
>>>>>>> e511abbac27b1d1f59cb2bf39b504ec7e2dcbc61
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String endereco;
    @Column
    private String telefone;
    @Column
    private boolean situacao;
    @Column
    private String numeroNivel;

    public Organizacao() {
    }

    public Organizacao(int id, String nome, String cnpj, String endereco, String telefone, boolean situacao, String numeroNivel) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.situacao = situacao;
        this.numeroNivel = numeroNivel;
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
