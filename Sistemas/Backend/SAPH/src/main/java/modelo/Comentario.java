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
@Table(name = "comentario")
public class Comentario {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=300)
    private String comentario;
    @Column
    private SolicitacaoDelegacao s_d_id;
    @Column
    private Funcionario funcionario_id;

    public Comentario() {
    }

    public Comentario(int id, String comentario, SolicitacaoDelegacao s_d_id, Funcionario funcionario_id) {
        this.id = id;
        this.comentario = comentario;
        this.s_d_id = s_d_id;
        this.funcionario_id = funcionario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SolicitacaoDelegacao getS_d_id() {
        return s_d_id;
    }

    public void setS_d_id(SolicitacaoDelegacao s_d_id) {
        this.s_d_id = s_d_id;
    }

    public Funcionario getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(Funcionario funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    
}
