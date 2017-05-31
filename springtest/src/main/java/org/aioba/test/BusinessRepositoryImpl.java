package org.aioba.test;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BusinessRepositoryImpl implements BusinessRepository {

    @PersistenceContext
    private EntityManager em;


    public void insert(Business business) {
        em.persist(business);
        em.flush();
    }

    public void update(Business business) {
        em.merge(business);
        em.flush();
    }

    public void delete(Business business) {
        business = em.find(Business.class, business.getGuid());
        em.remove(business);
    }

    public List<Business> list() {
        return em.createQuery("Select b from Business b").getResultList();
    }

    public List<Business> listAll(){ return em.createNativeQuery("Select * From Busines").getResultList(); }
}
