/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alekur
 */
@Named("add")
@RequestScoped
public class AddBean implements Serializable {
       
    @Inject
    private ProductCatalogueBean pcb;
    private Long id;
    private String name;
    private double price;
    
    public String action(){
        pcb.add(new Product(id,name,price));
        return "products?faces-redirect=true";
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId(){
            return id;
    }

    public ProductCatalogueBean getPcb() {
        return pcb;
    }

    public void setPcb(ProductCatalogueBean pcb) {
        this.pcb = pcb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
