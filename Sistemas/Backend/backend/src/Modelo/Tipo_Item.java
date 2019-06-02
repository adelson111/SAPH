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
@Table(name = "tb_item")
public class Tipo_Item {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String nome;
    @Column
    private ArrayList<Tipo_Campo> campo = new ArrayList<Tipo_Campo>();

    public Tipo_Item() {
    }

    public Tipo_Item(int id, String nome) {
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

    public ArrayList<Tipo_Campo> getCampo() {
        return campo;
    }

    public void setCampo(ArrayList<Tipo_Campo> campo) {
        this.campo = campo;
    }
    
    
    
    
}
