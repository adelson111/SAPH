package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoSolicitacaoDelegacao.class)
public abstract class TipoSolicitacaoDelegacao_ {

	public static volatile SingularAttribute<TipoSolicitacaoDelegacao, tipo.TipoSolicitacaoDelegacao> tipo;
	public static volatile ListAttribute<TipoSolicitacaoDelegacao, TipoItem> tipoItem;
	public static volatile SingularAttribute<TipoSolicitacaoDelegacao, String> nome;
	public static volatile SingularAttribute<TipoSolicitacaoDelegacao, Long> id;
	public static volatile ListAttribute<TipoSolicitacaoDelegacao, Nivel> nivel;
	public static volatile SingularAttribute<TipoSolicitacaoDelegacao, String> descricao;

}

