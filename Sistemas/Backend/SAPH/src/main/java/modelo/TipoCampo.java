/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "tipo_campo")
public class TipoCampo implements Serializable {

    @Id
    private long id;

    @Column(length = 80)
    private String nome;

    @Column(length = 300)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private tipo.TipoCampo tipo;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public tipo.TipoCampo getTipo() {
        return tipo;
    }

    public void setTipo(tipo.TipoCampo tipo) {
        this.tipo = tipo;
    }

}
