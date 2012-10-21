package com.eriksjo.tareawebshop;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author hajo
 */
@Entity
public class Customer implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private transient Cart cart = new Cart();
    
    private Address address;
    private String fname;
    private String lname;
    private String email;

    
    public Customer() {
    }

    public Customer(Long id, Address address, String fname,
            String lname, String email) {
        this.id = id;
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public Customer(Address address, String fname,
            String lname, String email) {
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public PurchaseOrder finishShopping() {
        PurchaseOrder po = new PurchaseOrder(this);
        cart = null;
        return po;
    }

    public void cancelShopping() {
        cart = new Cart();
    }

    public Address getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public Long getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", address=" + address + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }    
}
