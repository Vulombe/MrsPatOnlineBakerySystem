
package za.co.bakery.service;

import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;


public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;
    
    public OrderServiceImpl(){
        this.orderDAO= new OrderDAOImpl();
    }
}
