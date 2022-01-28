
package za.co.bakery.service;

import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.manager.DBPoolManagerBasic;


public class OrderServiceImpl implements OrderService{
    private OrderDAO orderDAO;
    
    public OrderServiceImpl(DBPoolManagerBasic dbpm){
        this.orderDAO= new OrderDAOImpl(dbpm);
    }
}
