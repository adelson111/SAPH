package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Organizacao.class)
public abstract class Organizacao_ {

	public static volatile SingularAttribute<Organizacao, String> telefone;
	public static volatile SingularAttribute<Organizacao, Boolean> situacao;
	public static volatile SingularAttribute<Organizacao, String> endereco;
	public static volatile SingularAttribute<Organizacao, String> nome;
	public static volatile SingularAttribute<Organizacao, Long> id;
	public static volatile SingularAttribute<Organizacao, String> cnpj;

}

