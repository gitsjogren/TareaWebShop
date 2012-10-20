
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

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Customer t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer find(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> getRange(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
