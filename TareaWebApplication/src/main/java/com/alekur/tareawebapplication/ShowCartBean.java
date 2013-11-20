/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alekur
 */
@Named("cart")
@RequestScoped
public class ShowCartBean implements Serializable {
    @Inject CartBean cb;
    
   public List<Map.Entry<Product, Integer>> getAll(){
        Map <Product, Integer> tempCart = cb.getAll();
        Set <Map.Entry<Product, Integer>> tempSet = tempCart.entrySet();
        
        return new ArrayList<Map.Entry<Product, Integer>>(tempSet);
    }
   
   //public List<Map.Entry<Product, Integer>> prodsInCart();
   
  /* public double getTotalPrice() {
        double totPrice = 0;
        for (Product tempProd : ) {
            tempProd = ;
            totPrice += tempProd.getPrice();
        }
        return totPrice;
    }*/
}
