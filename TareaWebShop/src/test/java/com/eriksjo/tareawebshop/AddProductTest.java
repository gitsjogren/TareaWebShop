/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eriksjo.tareawebshop;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alekur
 */
public class AddProductTest {
    
    private static EntityManagerFactory emf;
    private static Product p1;
    private static Customer c1;
    
    @BeforeClass
    public static void setUp() throws Exception {
       emf = Persistence.createEntityManagerFactory("shop_pu");
        EntityManager em = emf.createEntityManager();
        List<Product> prods1 = new ArrayList<>();
        p1 = new Product("banana", 12.34);
        Product p2 = new Product("apple", 3.3);
        Product p3 = new Product("juice", 44.4);
        Product p4 = new Product("sock", 1.2);
        prods1.add(p1);
        prods1.add(p2);
        prods1.add(p3);
        prods1.add(p4);

        c1 = new Customer(new Address("gata",2,"stad"), "fnamn", "lnamn", "e@mail.nu");
        c1.addProductToCart(p1);
        c1.addProductToCart(p2);
        c1.addProductToCart(p3);
        c1.addProductToCart(p4);
        
        c1.finishShopping();


        em.getTransaction().begin();
        em.persist(c1);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.getTransaction().commit();
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
        emf.close();
    }
    
    // ProductCatalogue now persists transparently
    @Test
    public void addTest(){
        
        Assert.assertTrue(p1.getName().equals("banana"));
        Assert.assertTrue(c1.getEmail().equals("e@mail.nu"));
        
    }
    
    @Test
    public void testSelect() {

        EntityManager em = emf.createEntityManager();
        String selectprod = "select b from Product b";
        Query q = em.createQuery(selectprod);
        List<Product> prods = q.getResultList();
        Assert.assertTrue(prods != null);
        Assert.assertTrue(prods.size() == 4);

        String cheapProducts = "select b from Product b where b.price < 2.2";

        TypedQuery<Product> tq = em.createQuery(cheapProducts, Product.class);
        Product product = tq.getSingleResult();
        Assert.assertTrue(product != null);
        Assert.assertTrue(product.getName().equals("sock"));
        em.close();
    }
    
}
