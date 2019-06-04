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
@Table(name = "campo")
public class Campo{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=200)
    private String valor;
    @Column
    private Item item_id;
    @Column
    private TipoCampo tipo_campo_id;

    public Campo() {
    }

    public Campo(int id, String valor, Item item_id, TipoCampo tipo_campo_id) {
        this.id = id;
        this.valor = valor;
        this.item_id = item_id;
        this.tipo_campo_id = tipo_campo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public TipoCampo getTipo_campo_id() {
        return tipo_campo_id;
    }

    public void setTipo_campo_id(TipoCampo tipo_campo_id) {
        this.tipo_campo_id = tipo_campo_id;
    }
    
    
}
