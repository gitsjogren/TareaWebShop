
package com.eriksjo.tareawebshop;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 * All products
 * @author hajo
 */
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop_pu");
    private static Product p1;
    private static Customer c1;
    
    public ProductCatalogue(String puName) {
        super(Product.class, puName);
    }
   
    public static IProductCatalogue newInstance(){
        return new ProductCatalogue("shop_pu");
    }
    
    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    @Override
    public List<Product> getAll(){
        EntityManager em = emf.createEntityManager();
        List<Product> prods = new ArrayList<>();
        try {
            String query = "select p from Product p";
            TypedQuery<Product> q = em.createQuery(query, Product.class);
            
            q.setMaxResults(20);
            prods = q.getResultList();
        } catch (Exception e) {
            System.out.print(e);
        
        }
        em.close();
        return prods;
    }
    
    // Uses the Criteria API, a bit hairy...
    private List<Product> select(boolean all, int start, int count) {
        EntityManager em = emf.createEntityManager();
        List<Product> products = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(count);
                q.setFirstResult(start);
            }
            products.addAll(q.getResultList());
        } catch (Exception ex) {
            ExceptionHandler.handle(ex);
        } finally {
            em.close();
        }
        return products;

    }
    
    @Override
    public Product find(Long id) {
        EntityManager em = emf.createEntityManager();
        Product p = em.find(Product.class, id);
        return p;

    }
    
    @Override
    public void remove(Long id) {
        EntityManager em = null;
        try {
            System.out.println("Removing product!");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Product p = em.getReference(Product.class, id);
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    @Override
    public void update(Product p) {
<<<<<<< HEAD
=======
        System.out.println("Du är inne i produktkatalogen och mergar!");
>>>>>>> bfd2debddfd07905a9040c1879e855982333be2d
        EntityManager em = null;
        Product p2 = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            p2 = em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ExceptionHandler.handle(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }

    @Override
    public List<Product> getRange(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

 
 
}
