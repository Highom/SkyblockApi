/**
 * @Author: Yannick Ruck
 * @Date: 17/01/2021
 */
package ch.bbw.yr.db.repositories;

import ch.bbw.yr.db.entities.ApiRequest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ApiRequestRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public ApiRequestRepository(){
        setup();
    }

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        em = emFactory.createEntityManager();
//        em.getTransaction().begin();
    }

    public void closeup() {
//        em.getTransaction().commit();
        if ((em != null) && em.isOpen()) {
            em.close();
        }
        if ((emFactory != null) && emFactory.isOpen()) {
            emFactory.close();
        }
    }

    public List<ApiRequest> getAllApiRequests() {
        List<ApiRequest> listApiRequests = null;
        try {
            em.getTransaction().begin();
            listApiRequests = em.createNamedQuery("ApiRequest.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listApiRequests;
    }

    public void createApiRequest(ApiRequest emp) {
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

    private void flushAndClear() {
        em.flush();
        em.clear();
    }
}
