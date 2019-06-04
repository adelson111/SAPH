/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
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
@Table(name = "tipo_item")
public class TipoItem {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=100)
    private String nome;
    @Column
    private ArrayList<TipoCampo> campo = new ArrayList<TipoCampo>();

    public TipoItem() {
    }

    public TipoItem(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public ArrayList<TipoCampo> getCampo() {
        return campo;
    }

    public void setCampo(ArrayList<TipoCampo> campo) {
        this.campo = campo;
    }
    
    
    
    
}
