package facade;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PeterBoss
 */
public class UserFacade {

    EntityManagerFactory emf;

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addUser(User u) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }

    public User getUser(int id) {
        User u;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        u = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return u;
    }
    
    public List<User> getUsersInRange(float min, float max) {
        EntityManager em = emf.createEntityManager();
        List<User> users;
        try {
            users = em.createQuery("SELECT u FROM User u WHERE u.rating >= :min AND u.rating <= :max")
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .getResultList();
        } finally {
            em.close();
        }
        return users;
    }

    public void updateUser(User u) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(User u) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }
}
