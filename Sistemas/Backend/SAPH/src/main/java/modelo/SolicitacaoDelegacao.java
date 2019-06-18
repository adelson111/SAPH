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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import tipo.TipoStatus;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "solicitacao_delegacao")
@SequenceGenerator(name = "sequencia_solicitacao_delegacao", sequenceName = "sequencia_solicitacao_delegacao",
        initialValue = 1, allocationSize = 1)
public class SolicitacaoDelegacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_solicitacao_delegacao")
    private long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private tipo.TipoStatus status;
    
    @OneToOne
    @JoinColumn(name = "tipo_solicitacao_delegacao_id", nullable = false)
    private TipoSolicitacaoDelegacao tipoSolicitacaoDelegacao;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "solicitaca_delegacao_id")
    private List<modelo.Item> itens;
    
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

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
    
    
    
}
