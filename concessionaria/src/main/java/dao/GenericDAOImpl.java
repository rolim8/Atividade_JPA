package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class GenericDAOImpl<T> implements  IGenericDAO<T> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("concessionaria_PU");
    private EntityManager em = emf.createEntityManager();

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void saveOrUpdate(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    @Override
    public T findById(Class<T> clazz, Long id) {
        em.getTransaction().begin();
        T object = em.find(clazz, id);
        em.getTransaction().commit();
        return object;
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll(String namedQuery) {
        Query query = em.createNamedQuery(namedQuery);
        return query.getResultList();
    }
}
