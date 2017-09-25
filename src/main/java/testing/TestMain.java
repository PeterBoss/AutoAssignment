/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import entity.Assignment;
import entity.Solution;
import entity.SolutionPK;
import entity.User;
import facade.AssignmentFacade;
import facade.SolutionFacade;
import facade.UserFacade;
import java.math.BigDecimal;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PeterBoss
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Persistence.generateSchema("myPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

        UserFacade uf = new UserFacade();
        AssignmentFacade af = new AssignmentFacade();
        SolutionFacade sf = new SolutionFacade();

        uf.addEntityManagerFactory(emf);
        af.addEntityManagerFactory(emf);
        sf.addEntityManagerFactory(emf);

        User u1 = new User();
        Assignment a1 = new Assignment();
        Solution s1 = new Solution(1, 1);

        u1.setName("Peter");
        u1.setRating(BigDecimal.valueOf(5));
        a1.setRating(BigDecimal.valueOf(5));

        uf.addUser(u1);
        af.addAssignment(a1);

        sf.addSolution(s1);

    }

}
