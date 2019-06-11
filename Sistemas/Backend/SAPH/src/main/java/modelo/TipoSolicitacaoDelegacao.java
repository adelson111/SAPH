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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "tipo_solicitacao_delegacao")
public class TipoSolicitacaoDelegacao implements Serializable {
    
    @Id
    private long id;
    
    @Column(length = 80, nullable = false)
    private String nome;
    
    @Column(length = 300, nullable = false)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 12, nullable = false)
    private tipo.TipoSolicitacaoDelegacao tipo;
    
    @ManyToMany(targetEntity = TipoItem.class)
    @JoinTable(name = "tipo_solicitacao_delegacao_item", 
            joinColumns = {@JoinColumn(name = "tipo_solicitacao_delegacao_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "tipo_item_id")})
    private List<TipoItem> tipoItem;
    
    @ManyToMany(targetEntity = Nivel.class)
    @JoinTable(name = "tipo_solicitacao_delegacao_nivel", 
            joinColumns = {@JoinColumn(name = "tipo_solicitacao_delegacao_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "nivel_id")})
    private List<Nivel> nivel;

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

    public tipo.TipoSolicitacaoDelegacao getTipo() {
        return tipo;
    }

    public void setTipo(tipo.TipoSolicitacaoDelegacao tipo) {
        this.tipo = tipo;
    }

    public List<TipoItem> getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(List<TipoItem> tipoItem) {
        this.tipoItem = tipoItem;
    }

    public List<Nivel> getNivel() {
        return nivel;
    }

    public void setNivel(List<Nivel> nivel) {
        this.nivel = nivel;
    }
    
}
