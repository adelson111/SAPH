package Modelo;

import Modelo.Funcionario;
import Modelo.Nivel;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T15:05:31")
@StaticMetamodel(Setor.class)
public class Setor_ { 

    public static volatile SingularAttribute<Setor, String> nome;
    public static volatile SingularAttribute<Setor, Integer> id;
    public static volatile ListAttribute<Setor, Funcionario> funcionario;
    public static volatile SingularAttribute<Setor, Nivel> nivel;
    public static volatile SingularAttribute<Setor, Funcionario> gerente;

}