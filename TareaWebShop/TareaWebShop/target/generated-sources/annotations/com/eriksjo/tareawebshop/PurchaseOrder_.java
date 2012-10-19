package com.eriksjo.tareawebshop;

import com.eriksjo.tareawebshop.Customer;
import com.eriksjo.tareawebshop.OrderItem;
import com.eriksjo.tareawebshop.PurchaseOrder.State;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-16T08:53:15")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, Long> id;
    public static volatile ListAttribute<PurchaseOrder, OrderItem> items;
    public static volatile SingularAttribute<PurchaseOrder, State> state;
    public static volatile SingularAttribute<PurchaseOrder, Date> date;
    public static volatile SingularAttribute<PurchaseOrder, Customer> customer;

}