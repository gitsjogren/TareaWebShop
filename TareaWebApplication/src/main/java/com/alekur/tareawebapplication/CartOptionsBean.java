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
@Named("cartAction")
@ConversationScoped
public class CartOptionsBean implements Serializable{
    
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

        Product p = (Product) ae.getComponent().getAttributes().get("prod");
        String action = ae.getComponent().getId();
        
        switch (action) {
            case "add":
                addToCart(p);
                break;
            case "delete":
                cb.deleteFromCart(p);
                break;
            default:
                break;
        }
    }
}
