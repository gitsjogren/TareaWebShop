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
    IProductCatalogue pc = JPAShop.INSTANCE.getProductCatalogue();  


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
        pc.update(p);
    }

   
    public void remove(Long id) {
        pc.remove(id);
    }
    
}
