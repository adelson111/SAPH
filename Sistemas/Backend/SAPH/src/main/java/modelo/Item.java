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
public class Item {
    private String nome;
    private ArrayList<Campo> campo = new ArrayList<>();

    public Item() {
    }

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Campo> getCampo() {
        return campo;
    }

    public void setCampo(ArrayList<Campo> campo) {
        this.campo = campo;
    }
    
    
}
