    package com.eriksjo.tareawebshop;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A container for entities
 * Base class for OrderBook, ProductCatalogue, CustomerRegistry
 * 
 * K is type of id (primary key)
 * 
 * @author hajo
 */
public abstract class AbstractDAO<T, K> implements IDAO<T, K> {

    private EntityManagerFactory emf;
    private final Class<T> clazz;
    
    protected AbstractDAO(Class<T> clazz, String puName){
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }
    

    @Override
    public void add(T t) {
          EntityManager em = null;
        try {
            // Create ...
            em = emf.createEntityManager();
            // Must handle transaction, this is application managed 
            // transaction (RESOURCE_LOCAL)
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();  // ... and destroy
            }
        }
    }

    @Override
    public void remove(K id) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public T find(K id) {    

        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> getRange( int firstResult, int maxResults) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
