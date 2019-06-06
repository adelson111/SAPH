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
@Table(name = "setor_funcionario")
public class SetorFuncionario {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Setor setor_id;
    @Column
    private Funcionario funcionario_id;

    public SetorFuncionario() {
    }

    public SetorFuncionario(int id, Setor setor_id, Funcionario funcionario_id) {
        this.id = id;
        this.setor_id = setor_id;
        this.funcionario_id = funcionario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Setor getSetor_id() {
        return setor_id;
    }

    public void setSetor_id(Setor setor_id) {
        this.setor_id = setor_id;
    }

    public Funcionario getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(Funcionario funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
}
