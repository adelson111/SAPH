package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Nivel.class)
public abstract class Nivel_ {

	public static volatile SingularAttribute<Nivel, Long> nivelInferior;
	public static volatile SingularAttribute<Nivel, Organizacao> organizacao;
	public static volatile SingularAttribute<Nivel, Long> nivelSuperior;
	public static volatile SingularAttribute<Nivel, String> nome;
	public static volatile SingularAttribute<Nivel, Long> id;
	public static volatile SingularAttribute<Nivel, Funcionario> responsavel;

}

