
package com.eriksjo.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * All orders
 * @author hajo
 */
public final class OrderBook extends AbstractDAO<PurchaseOrder, Long> implements IOrderBook{

    public static IOrderBook newInstance() {
       return new OrderBook("shop_pu");
    }
    
    public OrderBook(String puName){
        super(PurchaseOrder.class, puName);
    }

   
    @Override
    public List<PurchaseOrder> getByCustomer(Customer c) {
        List<PurchaseOrder> found = new ArrayList<>();
        for (PurchaseOrder po : getAll()) {
            if (po.getCustomer().equals(c)) {
                found.add(po);
            }
        }
        return found;
    }
}
