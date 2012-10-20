/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eriksjo.tareawebapp;

import com.eriksjo.tareawebshop.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author alekur
 */
@Named("products")
@RequestScoped
public class ProductsBB implements Serializable {
    @Inject ProductCatalogueBean pcBean;
    
    public List<Product> getAll(){
        pcBean.addP();
        return pcBean.getAll();
    }
}
