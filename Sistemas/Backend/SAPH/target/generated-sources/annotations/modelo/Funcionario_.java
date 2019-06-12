package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ {

	public static volatile ListAttribute<Funcionario, Setor> setor;
	public static volatile SingularAttribute<Funcionario, String> telefone;
	public static volatile SingularAttribute<Funcionario, Boolean> ativo;
	public static volatile SingularAttribute<Funcionario, String> endereco;
	public static volatile SingularAttribute<Funcionario, String> foto;
	public static volatile SingularAttribute<Funcionario, Organizacao> organizacao;
	public static volatile SingularAttribute<Funcionario, String> cpf;
	public static volatile SingularAttribute<Funcionario, String> nome;
	public static volatile SingularAttribute<Funcionario, Usuario> usuario;
	public static volatile SingularAttribute<Funcionario, Long> id;
	public static volatile SingularAttribute<Funcionario, String> cargo;

}

