package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Setor.class)
public abstract class Setor_ {

	public static volatile SingularAttribute<Setor, String> nome;
	public static volatile SingularAttribute<Setor, Long> id;
	public static volatile ListAttribute<Setor, Funcionario> funcionario;
	public static volatile SingularAttribute<Setor, Nivel> nivel;
	public static volatile SingularAttribute<Setor, Funcionario> gerente;

}

