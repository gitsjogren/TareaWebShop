
package com.eriksjo.shop;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author hajo
 */
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private double price;

    
    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Product(String name, double price) {
         // For now. Later database will generate id
//        this.id = new Long(new Random().nextInt(100));
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

   
}
