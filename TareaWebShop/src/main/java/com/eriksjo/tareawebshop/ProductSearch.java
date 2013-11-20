/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eriksjo.tareawebshop;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Edfast
 * Funkar för att hitta produkter på samma namn som man skriver in i sökrutan, men hämtar inte produkten i sig utan jämför mot databasen
 * ANVÄNDS EJ JUST NU. Den aktuella sökmetoden hittas i ProductCatalogue.java
 */

@SessionScoped

public class ProductSearch implements Serializable {
    
    public List<Product> search(String searchWord) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productHits = new ArrayList<>();
        String dbName;
        String query;
        
        try { 
            dbName = "jdbc:derby://localhost:1527/shopdb";
            query = "select NAME, PRICE from shopdb.PRODUCT where NAME LIKE ?";
            con = DriverManager.getConnection(dbName, "app", "app");
            statement = con.prepareStatement(query);
            statement.setString(1, "%" + searchWord + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                
                productHits.add(product);
            }
        }
        
        finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException err) { System.out.println( err.getMessage()); }
            if (statement != null) try { statement.close(); } catch (SQLException err) { System.out.println( err.getMessage()); }
            if (con!= null) try {con.close(); } catch (SQLException err) { System.out.println( err.getMessage()); }
        }
        
        return productHits;
        
    }
}
