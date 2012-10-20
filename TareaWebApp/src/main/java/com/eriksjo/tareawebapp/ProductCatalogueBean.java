/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eriksjo.tareawebapp;

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
    private int i = 0;
    
    public void addP(){
        if(i==0){
        i = 1;
        pc.add(new Product(1L,"Produkt",13.37));
        }
    }
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
