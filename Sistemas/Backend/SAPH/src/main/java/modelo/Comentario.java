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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
    
    @Id
    private long id;
    
    @Column(length = 300, nullable = false)
    private String comentario;
    
    @ManyToOne(targetEntity = SolicitacaoDelegacao.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "solicitacao_delegacao_id", nullable = false)
    private SolicitacaoDelegacao solicitacaoDelegacao;
    
    @ManyToOne(targetEntity = Funcionario.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "funcionario_id", nullable = false)
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
