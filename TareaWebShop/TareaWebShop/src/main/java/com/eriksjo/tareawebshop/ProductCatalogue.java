
package com.eriksjo.tareawebshop;

import java.util.ArrayList;
import java.util.List;

/**
 * All products
 * @author hajo
 */
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {

    public ProductCatalogue(String puName) {
        super(Product.class, puName);
    }
   
    public static IProductCatalogue newInstance(){
        return new ProductCatalogue("shop_pu");
    }
    
    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
}
