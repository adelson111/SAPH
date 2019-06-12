package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoItem.class)
public abstract class TipoItem_ {

	public static volatile ListAttribute<TipoItem, TipoCampo> tipoCampo;
	public static volatile SingularAttribute<TipoItem, String> nome;
	public static volatile SingularAttribute<TipoItem, Long> id;
	public static volatile ListAttribute<TipoItem, TipoSolicitacaoDelegacao> tipoSolicitacaoDelegacao;

}

