
package com.eriksjo.shop;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * A single row in the order
 * @author hajo
 */
@Entity
public class OrderItem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @OneToOne(cascade={CascadeType.PERSIST})
    private Product product;
    private int quantity;

    public OrderItem() {
        
    }

    OrderItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }
   
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }
    
    
}
