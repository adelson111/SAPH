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
@Table(name = "solicitacao_delegacao")
public class SolicitacaoDelegacao {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private TipoSolicitacaoDelegacao idSolicitacaoDelegacao;
    @Column(length=30)
    private String status;

    public SolicitacaoDelegacao() {
    }

    public SolicitacaoDelegacao(int id, TipoSolicitacaoDelegacao idSolicitacaoDelegacao, String status) {
        this.id = id;
        this.idSolicitacaoDelegacao = idSolicitacaoDelegacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoSolicitacaoDelegacao getIdSolicitacaoDelegacao() {
        return idSolicitacaoDelegacao;
    }

    public void setIdSolicitacaoDelegacao(TipoSolicitacaoDelegacao idSolicitacaoDelegacao) {
        this.idSolicitacaoDelegacao = idSolicitacaoDelegacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
