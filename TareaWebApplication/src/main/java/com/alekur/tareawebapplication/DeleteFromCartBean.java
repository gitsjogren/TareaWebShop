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
 * @author Alexander
 */
@Named("deleteFromCart")
@ConversationScoped
public class DeleteFromCartBean implements Serializable {
      @Inject
    private CartBean cb;
    
    @Inject
    private ProductsBB pbb;
    
    @Inject
    private ShowCartBean scb;
    
    public String delete(Product p){
        cb.deleteFromCart(p);                
        return "cart?faces-redirect=true";
    }
   
    public Map<Product,Integer> getAll(){
        return cb.getAll();
    }
    
}
