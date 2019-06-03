package Modelo;

import Modelo.Tipo_Campo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T15:05:31")
@StaticMetamodel(Tipo_Item.class)
public class Tipo_Item_ { 

    public static volatile SingularAttribute<Tipo_Item, String> nome;
    public static volatile SingularAttribute<Tipo_Item, Integer> id;
    public static volatile ListAttribute<Tipo_Item, Tipo_Campo> campo;

}