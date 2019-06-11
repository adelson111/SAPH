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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tipo.TipoStatus;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "solicitacao_delegacao")
public class SolicitacaoDelegacao implements Serializable {
    
    @Id
    private long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private tipo.TipoStatus status;
    
    @ManyToOne(targetEntity = TipoSolicitacaoDelegacao.class)
    @JoinColumn(name = "tipo_solicitacao_delegacao_id", nullable = false)
    private TipoSolicitacaoDelegacao tipoSolicitacaoDelegacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoStatus getStatus() {
        return status;
    }

    public void setStatus(TipoStatus status) {
        this.status = status;
    }

    public TipoSolicitacaoDelegacao getTipoSolicitacaoDelegacao() {
        return tipoSolicitacaoDelegacao;
    }

    public void setTipoSolicitacaoDelegacao(TipoSolicitacaoDelegacao tipoSolicitacaoDelegacao) {
        this.tipoSolicitacaoDelegacao = tipoSolicitacaoDelegacao;
    }
    
}
