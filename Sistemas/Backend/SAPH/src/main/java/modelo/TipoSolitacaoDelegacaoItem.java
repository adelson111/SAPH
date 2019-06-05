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
@Table(name = "tipo_solicitacao_delegacao_item")
public class TipoSolitacaoDelegacaoItem {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private TipoSolicitacaoDelegacao tipo_delegacao_id;
    @Column
    private TipoItem tipo_item_id;

    public TipoSolitacaoDelegacaoItem() {
    }

    public TipoSolitacaoDelegacaoItem(int id, TipoSolicitacaoDelegacao tipo_delegacao_id, TipoItem tipo_item_id) {
        this.id = id;
        this.tipo_delegacao_id = tipo_delegacao_id;
        this.tipo_item_id = tipo_item_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoSolicitacaoDelegacao getTipo_delegacao_id() {
        return tipo_delegacao_id;
    }

    public void setTipo_delegacao_id(TipoSolicitacaoDelegacao tipo_delegacao_id) {
        this.tipo_delegacao_id = tipo_delegacao_id;
    }

    public TipoItem getTipo_item_id() {
        return tipo_item_id;
    }

    public void setTipo_item_id(TipoItem tipo_item_id) {
        this.tipo_item_id = tipo_item_id;
    }
    
}
