/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "tipo_item")
public class TipoItem implements Serializable {

    @Id
    private long id;

    @Column(length = 80)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tipo_item_tipo_campo", 
            joinColumns = {@JoinColumn(name = "tipo_item_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "tipo_campo_id")})
    private List<TipoCampo> tipoCampos;
    
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

    public List<TipoCampo> getTipoCampos() {
        return tipoCampos;
    }

    public void setTipoCampos(List<TipoCampo> tipoCampos) {
        this.tipoCampos = tipoCampos;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoItem other = (TipoItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
