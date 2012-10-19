package com.eriksjo.tareawebshop;

import com.eriksjo.tareawebshop.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-10-16T08:53:15")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Long> id;
    public static volatile SingularAttribute<OrderItem, Product> product;
    public static volatile SingularAttribute<OrderItem, Integer> quantity;

}