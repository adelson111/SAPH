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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.jpamodelgen.xml.jaxb.Persistence;

import banco.Persistencia;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    @Id
    private long id;

    @Column(length = 80)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "setor_funcionario", 
            joinColumns = {@JoinColumn(name = "setor_id")}, 
            inverseJoinColumns = {@JoinColumn(name = "funcionario_id")})
    private List<Funcionario> funcionarios;

    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Funcionario gerente;

    

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

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

	

    public modelo.Nivel getNivel(){
    	return new Persistencia().getNivelBySetor(this);
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Setor other = (Setor) obj;
            if (id != other.id)
                    return false;
            return true;
    }
  
    
}
