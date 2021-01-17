/**
 * @Author: Yannick Ruck
 * @Date: 17/01/2021
 */
package ch.bbw.yr.db.repositories;

import ch.bbw.yr.db.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public UserRepository(){
        setup();
    }

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        em = emFactory.createEntityManager();
    }

    public void closeup() {
        if ((em != null) && em.isOpen()) {
            em.close();
        }
        if ((emFactory != null) && emFactory.isOpen()) {
            emFactory.close();
        }
    }

    public User getUserByName(String username) {
        User user = null;
        try {
            em.getTransaction().begin();
            user = em.createNamedQuery("User.getByName", User.class).setParameter("username",username).getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return user;
    }

    public void createUser(User emp) {
        try {
            em.getTransaction().begin();
            em.persist(emp);
            flushAndClear();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public void updateUser(User emp) {
        try {
            em.getTransaction().begin();
            Object User = em.find(User.class, emp.getId());
            if (User != null) {
                em.merge(User);
                flushAndClear();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    private void flushAndClear() {
        em.flush();
        em.clear();
    }
}
