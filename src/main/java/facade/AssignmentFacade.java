package facade;

import entity.Assignment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PeterBoss
 */
public class AssignmentFacade {

    EntityManagerFactory emf;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addAssignment(Assignment a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public Assignment getAssignment(int id) {
        Assignment a;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        a = em.find(Assignment.class, id);
        em.getTransaction().commit();
        em.close();
        return a;
    }
    
    public List<Assignment>  getAssignmentByRating(float rating){
        EntityManager em = emf.createEntityManager();
        List<Assignment> assignments;
        try {
            assignments = em.createNamedQuery("Assignment.findByRating", Assignment.class).setParameter("rating", rating).getResultList();
        } finally {
            em.close();
        }
        return assignments;
    }
    
    public List<Assignment> getAllAssignments() {
        EntityManager em = emf.createEntityManager();
        List<Assignment> assignments;
        try {
            assignments = em.createNamedQuery("Assignment.findAll", Assignment.class).getResultList();
        } finally {
            em.close();
        }
        return assignments;
    }
    
    public List<Assignment> getAssignmentsInRange(float min, float max) {
        EntityManager em = emf.createEntityManager();
        List<Assignment> assignments;
        try {
            assignments = em.createQuery("SELECT a FROM Assignment a WHERE a.rating >= :min AND a.rating <= :max")
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .getResultList();
        } finally {
            em.close();
        }
        
        return assignments;
    }

    public void updateAssignment(Assignment a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAssignment(Assignment a) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }
}
