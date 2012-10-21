/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alekur
 */
@Named("delete")
@ConversationScoped
public class DeleteBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    private Long id;
    private String name;
    private double price;
    @Inject
    private ProductCatalogueBean pcb;

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

    public ProductCatalogueBean getPcb() {
        return pcb;
    }

    public void setPcb(ProductCatalogueBean pcb) {
        this.pcb = pcb;
    }

    public void actionListener(ActionEvent ae) {
        
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got id {0}", id);
        }else{
            
        }
        Product p = (Product) ae.getComponent().getAttributes().get("product");
        id = p.getId();
        name = p.getName();
        price = p.getPrice();
        // Find person from database...
    }

    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            System.out.println("Removing product: " + id + " " + name + " " + price);
            pcb.remove(id);
            return "products?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }

    @PreDestroy  // MUST HAVE back button etc.
    public void destroy() {
        if (conv != null) {
            if (!conv.isTransient()) {
                conv.end();
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
