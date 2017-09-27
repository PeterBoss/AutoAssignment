package entity;

import entity.Solution;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-27T12:11:01")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Solution> solutionCollection;
    public static volatile SingularAttribute<User, BigDecimal> rating;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> id;

}