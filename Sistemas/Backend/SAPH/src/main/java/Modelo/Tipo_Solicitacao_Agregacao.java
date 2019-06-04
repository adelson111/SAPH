/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
@Table(name = "tb_tipo_solicitacao_agregacao")
public class Tipo_Solicitacao_Agregacao{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String tipo;
    @Column
    private String tipo_s_d;
    @Column
    private String descricao;

    public Tipo_Solicitacao_Agregacao() {
    }

    public Tipo_Solicitacao_Agregacao(int id, String tipo, String tipo_s_d, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.tipo_s_d = tipo_s_d;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo_s_d() {
        return tipo_s_d;
    }

    public void setTipo_s_d(String tipo_s_d) {
        this.tipo_s_d = tipo_s_d;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
