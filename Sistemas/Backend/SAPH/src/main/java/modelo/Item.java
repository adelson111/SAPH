/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
    
    @Id
    private long id;
    
    @ManyToOne(targetEntity = SolicitacaoDelegacao.class)
    @JoinColumn(name = "solicitacao_delegacao_id", nullable = false)
    private SolicitacaoDelegacao solicitacaoDelegacao;
    
    @OneToOne(targetEntity = TipoItem.class)
    @JoinColumn(name = "tipo_item_id", nullable = false)
    private TipoItem tipoItem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SolicitacaoDelegacao getSolicitacaoDelegacao() {
        return solicitacaoDelegacao;
    }

    public void setSolicitacaoDelegacao(SolicitacaoDelegacao solicitacaoDelegacao) {
        this.solicitacaoDelegacao = solicitacaoDelegacao;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
    
}
