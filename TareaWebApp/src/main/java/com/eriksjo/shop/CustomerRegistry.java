
package com.eriksjo.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * All customers
 * @author hajo
 */
public final class CustomerRegistry extends AbstractDAO<Customer, Long> implements ICustomerRegistry {

    public static ICustomerRegistry newInstance() {
        return new CustomerRegistry("shop_pu");
    }
    
    public CustomerRegistry(String puName) {
       super(Customer.class,puName);
    }

    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<>();
        for (Customer c : getAll()) {
            if (c.getFname().equals(name) || c.getLname().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }
}
