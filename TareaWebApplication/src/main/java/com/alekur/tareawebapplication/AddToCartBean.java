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
@Named()
@ConversationScoped
public class AddToCartBean implements Serializable{
    
    @Inject
    private CartBean cb;
    
    @Inject
    private ProductsBB pbb;
    
    @Inject
    private ShowCartBean scb;
    
    public String addToCart(Product p){
        
        System.out.println("atcb"+p.getId());
        System.out.println("atcb"+p.getName());
        System.out.println("atcb"+p.getPrice());
        cb.add(p);                
        return "products?faces-redirect=true";
    }
   
    public Map<Product,Integer> getAll(){
        return cb.getAll();
    }
    
    public void actionListener(ActionEvent ae) {

        Product product = (Product) ae.getComponent().getAttributes().get("prod");
        String id = ae.getComponent().getId();
        addToCart(product);
        
    }
}
