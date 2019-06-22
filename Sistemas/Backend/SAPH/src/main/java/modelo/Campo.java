/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "campo")
@SequenceGenerator(name = "sequencia_campo", sequenceName = "sequencia_campo",
        initialValue = 1, allocationSize = 1)
public class Campo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_campo")
    private long id;
    
    @Column(length = 300, nullable = false)
    private String valor;
    
    
    
    @OneToOne
    @JoinColumn(name = "tipo_campo_id", nullable = false)
    private TipoCampo tipoCampo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoCampo getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(TipoCampo tipoCampo) {
        this.tipoCampo = tipoCampo;
    }
    
}
