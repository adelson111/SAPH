package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tipo.TipoStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SolicitacaoDelegacao.class)
public abstract class SolicitacaoDelegacao_ {

	public static volatile SingularAttribute<SolicitacaoDelegacao, Long> id;
	public static volatile SingularAttribute<SolicitacaoDelegacao, TipoSolicitacaoDelegacao> tipoSolicitacaoDelegacao;
	public static volatile SingularAttribute<SolicitacaoDelegacao, TipoStatus> status;

}

