/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;


import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alekur
 */
@Named("addCart")
@ConversationScoped
public class AddToCartBean implements Serializable{
    
    @Inject
    private CartBean cb;
    
    @Inject
    private ProductsBB pbb;
    
    @Inject
    private ShowCartBean scb;
    
    public String addToCart(Product p){
        cb.add(p);                
        return "products?faces-redirect=true";
    }
   
    public Map<Product,Integer> getAll(){
        return cb.getAll();
    }
    
    public void actionListener(ActionEvent ae) {

        Product product = (Product) ae.getComponent().getAttributes().get("prod");
        Product p = new Product(product.getId(),product.getName(),product.getPrice());
        addToCart(p);
        
    }
}
