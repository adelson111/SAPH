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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "comentario")
@SequenceGenerator(name = "sequencia_comentario", sequenceName = "sequencia_comentario",
        initialValue = 1, allocationSize = 1)
public class Comentario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_comentario")
    private long id;
    
    @Column(length = 300)
    private String comentario;
    
    @ManyToOne
    @JoinColumn(name = "solicitacao_delegacao_id")
    private SolicitacaoDelegacao solicitacaoDelegacao;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SolicitacaoDelegacao getSolicitacaoDelegacao() {
        return solicitacaoDelegacao;
    }

    public void setSolicitacaoDelegacao(SolicitacaoDelegacao solicitacaoDelegacao) {
        this.solicitacaoDelegacao = solicitacaoDelegacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
