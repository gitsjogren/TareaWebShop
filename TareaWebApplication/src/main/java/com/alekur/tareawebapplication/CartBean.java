/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Cart;
import com.eriksjo.tareawebshop.IOrderBook;
import com.eriksjo.tareawebshop.IProductCatalogue;
import com.eriksjo.tareawebshop.JPAShop;
import com.eriksjo.tareawebshop.Product;
import com.eriksjo.tareawebshop.PurchaseOrder;
import java.io.Serializable;
import java.util.List;
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
   
    public void remove(Product p) {
        cart.delete(p);
    }

    void add(Product p) {
        System.out.println("cb"+p.getId());
        System.out.println("cb"+p.getName());
        System.out.println("cb"+p.getPrice());
        cart.add(p);
    }
    
}
