/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.User;
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

    public void addUser(User u) {  //should propably return something
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
