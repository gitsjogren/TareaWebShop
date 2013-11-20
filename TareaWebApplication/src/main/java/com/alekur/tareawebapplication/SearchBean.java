/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alekur.tareawebapplication;

import com.eriksjo.tareawebshop.Product;
import com.eriksjo.tareawebshop.ProductSearch;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edfast
 */
@Named("search")
@RequestScoped
public class SearchBean implements Serializable {
    
    @Inject private ProductCatalogueBean pcb;
    private String searchWord;
    private List<Product> productHits;
    
    public void action() throws SQLException, InstantiationException {
        productHits = pcb.search(searchWord);
    }
    
    public List<Product> getProductHits() {
        return productHits;
    }

    public void setProductHits(List<Product> productHits) {
        this.productHits = productHits;
    }
    
    public String getSearchWord(){
        return searchWord;
    }
    
    public void setSearchWord(String searchWord){
        this.searchWord = searchWord;
    }
}