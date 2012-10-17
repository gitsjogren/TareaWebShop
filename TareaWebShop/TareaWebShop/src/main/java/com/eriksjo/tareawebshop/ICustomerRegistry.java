package com.eriksjo.tareawebshop;

import java.util.List;

/**
 * Interface to customer registry
 * @author hajo
 */
public interface ICustomerRegistry extends IDAO<Customer, Long> {

    List<Customer> getByName(String name);
    
}
