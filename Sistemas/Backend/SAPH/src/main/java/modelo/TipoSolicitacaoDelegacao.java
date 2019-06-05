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
@Table(name = "tipo_solicitacao_delegacao")
public class TipoSolicitacaoDelegacao{
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length=100)
    private String tipo;
    @Column(length=1)
    private String tipo_s_d;
    @Column(length=300)
    private String descricao;
    @OneToMany( targetEntity=TipoItem.class )
    private List<TipoItem> itens;

    public TipoSolicitacaoDelegacao() {
    }

    public TipoSolicitacaoDelegacao(int id, String tipo, String tipo_s_d, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.tipo_s_d = tipo_s_d;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo_s_d() {
        return tipo_s_d;
    }

    public void setTipo_s_d(String tipo_s_d) {
        this.tipo_s_d = tipo_s_d;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public List getItens() {
		return itens;
	}

	public void setItens(List itens) {
		this.itens = itens;
	}
    
    
    
    
}
