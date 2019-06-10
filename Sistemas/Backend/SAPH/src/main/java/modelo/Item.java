/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@Table(name = "item")
public class Item {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private SolicitacaoDelegacao s_d_id;
    @Column
    private TipoItem tipo_item_id;
    @OneToMany( targetEntity=Campo.class )
    private List<Campo> campos;
    
    public Item() {
    }

    public Item(int id, SolicitacaoDelegacao s_d_id, TipoItem tipo_item_id) {
        this.id = id;
        this.s_d_id = s_d_id;
        this.tipo_item_id = tipo_item_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SolicitacaoDelegacao getS_d_id() {
        return s_d_id;
    }

    public void setS_d_id(SolicitacaoDelegacao s_d_id) {
        this.s_d_id = s_d_id;
    }

    public TipoItem getTipo_item_id() {
        return tipo_item_id;
    }

    public void setTipo_item_id(TipoItem tipo_item_id) {
        this.tipo_item_id = tipo_item_id;
    }

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
    
    
    
}
