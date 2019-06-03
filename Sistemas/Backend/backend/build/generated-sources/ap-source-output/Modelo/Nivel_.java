package Modelo;

import Modelo.Funcionario;
import Modelo.Nivel;
import Modelo.Organizacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T15:05:31")
@StaticMetamodel(Nivel.class)
public class Nivel_ { 

    public static volatile SingularAttribute<Nivel, Nivel> nivelInferior;
    public static volatile SingularAttribute<Nivel, Organizacao> organizacao;
    public static volatile SingularAttribute<Nivel, Nivel> nivelSuperior;
    public static volatile SingularAttribute<Nivel, String> nome;
    public static volatile SingularAttribute<Nivel, Integer> id;
    public static volatile SingularAttribute<Nivel, Funcionario> responsavel;

}