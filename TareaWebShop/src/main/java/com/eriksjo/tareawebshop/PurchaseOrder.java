package com.eriksjo.tareawebshop;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * A purchase order
 *
 * @author hajo
 */
@Entity
public class PurchaseOrder implements Serializable {

    public enum State {  
        ACCEPTED,
        CANCELLED,
        INVOICED,
        UNINVOIDED,
        SHIPPED,}
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();  
    
    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<OrderItem> items;

    @ManyToOne(cascade={CascadeType.PERSIST})
    private Customer customer;  
    
    private State state = State.ACCEPTED;

    public PurchaseOrder() {
    }

    // Can't create order with no Customer
    public PurchaseOrder(Customer customer) {
        this.customer = customer;
        items = new ArrayList<>();
        Map<Product, Integer> pf = customer.getCart().getProductFreq();
        for (Entry<Product, Integer> e : pf.entrySet()) {
            items.add(new OrderItem(e.getKey(), e.getValue()));
        }
    }

    public Date getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public State getState() {
        return state;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "id=" + id + ", date=" + date + 
                ", items=" + items + ", customer=" + customer + 
                ", state=" + state + '}';
    }
}
