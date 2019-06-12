package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentario.class)
public abstract class Comentario_ {

	public static volatile SingularAttribute<Comentario, SolicitacaoDelegacao> solicitacaoDelegacao;
	public static volatile SingularAttribute<Comentario, Long> id;
	public static volatile SingularAttribute<Comentario, Funcionario> funcionario;
	public static volatile SingularAttribute<Comentario, String> comentario;

}

