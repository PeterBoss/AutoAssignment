/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Solution;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PeterBoss
 */
public class SolutionFacade {

    private static EntityManagerFactory emf;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addSolution(Solution s) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    public Solution getSolution(int id) {
        Solution s;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        s = em.find(Solution.class, id);
        em.getTransaction().commit();
        em.close();
        return s;
    }

    public void updateSolution(Solution s) {

    }

    public void deleteSolution(Solution s) {

    }
}
