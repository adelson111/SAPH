/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author adelson
 */
public class Solicitacao {
    private String tipo;
    private String descricao;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private String status;

    public Solicitacao() {
    }

    public Solicitacao(String tipo, String descricao, String status) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Item> getItem() {
        return itens;
    }

    public void setItem(ArrayList<Item> item) {
        this.itens = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
