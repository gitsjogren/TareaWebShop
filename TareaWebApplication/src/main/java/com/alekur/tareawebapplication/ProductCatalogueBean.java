/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.IProductCatalogue;
import com.eriksjo.tareawebshop.JPAShop;
import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author alekur
 */
@SessionScoped
public class ProductCatalogueBean implements Serializable{
<<<<<<< HEAD
    IProductCatalogue pc = JPAShop.INSTANCE.getProductCatalogue();  

=======
    IProductCatalogue pc = JPAShop.INSTANCE.getProductCatalogue();
    private int i = 0;
    
    public void addP(){
        if(i==0){
        i = 1;
        pc.add(new Product(1L,"Produkt",13.37));
        }
    }
>>>>>>> bfd2debddfd07905a9040c1879e855982333be2d
    public List<Product> getAll(){
        return pc.getAll();
    }
    
     public void add(Product p) {
        pc.add(p);
    }
    
    public Product find(Long id) {
        return pc.find(id);
    }

   
    public void update(Product p) {
        System.out.println("Fick tag i id: " + p.getId());
        System.out.println("Fick tag i namn: " + p.getName());
        System.out.println("Fick tag i price: " + p.getPrice());
        pc.update(p);
    }

   
    public void remove(Long id) {
        System.out.println("redirecting to remove method");
        pc.remove(id);
    }
    
}
