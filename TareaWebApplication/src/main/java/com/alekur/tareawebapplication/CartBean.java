/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Cart;
import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author alekur
 */
@SessionScoped
public class CartBean implements Serializable{
    Cart cart = new Cart();

    public Map<Product, Integer> getAll(){
        return cart.getProductFreq();
    }
   
    public void deleteFromCart(Product p) {
        cart.deleteFromCart(p);
    }
    public void remove(Product p) {
        cart.remove(p);
    }

    void add(Product p) {
        cart.add(p);
    }
    
}
