/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Solution;
import entity.SolutionPK;
import java.util.List;
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

    public Solution getSpecificSolution(int userId, int assignmentId) {
        EntityManager em = emf.createEntityManager();
        Solution solution;
        SolutionPK key = new SolutionPK(userId, assignmentId);
        em.getTransaction().begin();
        solution = em.find(Solution.class, key);
        em.getTransaction().commit();
        em.close();
        return solution;
    }

    public List<Solution> getSolutionsByUser(int userId) {
        EntityManager em = emf.createEntityManager();
        List<Solution> solutions;
        try {
            solutions = em.createNamedQuery("Solution.findByUserId").setParameter("userId", userId).getResultList();
        } finally {
            em.close();
        }
        return solutions;
    }

    public List<Solution> getAllSolutions() {
        EntityManager em = emf.createEntityManager();
        List<Solution> solutions;
        try {
            solutions = em.createNamedQuery("Solution.findAll", Solution.class).getResultList();
        } finally {
            em.close();
        }
        return solutions;
    }

}
