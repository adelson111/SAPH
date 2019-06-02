package Modelo;

import Modelo.Organizacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-02T11:55:53")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> senha;
    public static volatile SingularAttribute<Funcionario, String> telefone;
    public static volatile SingularAttribute<Funcionario, Boolean> ativo;
    public static volatile SingularAttribute<Funcionario, String> endereco;
    public static volatile SingularAttribute<Funcionario, String> foto;
    public static volatile SingularAttribute<Funcionario, Organizacao> organizacao;
    public static volatile SingularAttribute<Funcionario, String> cpf;
    public static volatile SingularAttribute<Funcionario, String> nome;
    public static volatile SingularAttribute<Funcionario, Integer> id;
    public static volatile SingularAttribute<Funcionario, String> cargo;
    public static volatile SingularAttribute<Funcionario, String> email;

}