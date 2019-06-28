/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import banco.Persistencia;

/**
 *
 * @author adelson
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    private long id;

    @Column(length = 80)
    private String nome;

    @Column(length = 15)
    private String cpf;

    @Column(length = 30)
    private String cargo;

    @Column(length = 100)
    private String endereco;

    @Column(length = 17)
    private String telefone;

    @Column
    private boolean ativo;

    @Column(length = 100)
    private String foto;

    @OneToOne
    @JoinColumn(name = "usuaio_id")
    private Usuario usuario;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Setor getSetor() {
    	return new Persistencia().getSetorByFuncionario(this);
    }
    
    public Nivel getNivel() {
    	return getSetor().getNivel();
    }
    
    public long getIdNivelSuperior() {
    	return getNivel().getNivelSuperior();
    }
    
    public long getIdNivelInferior() {
    	return getNivel().getNivelInferior();
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}
    
    

}
