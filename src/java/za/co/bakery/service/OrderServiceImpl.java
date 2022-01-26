package za.co.bakery.service;

import java.util.Date;
import java.util.List;
import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderdao;

    public OrderServiceImpl(DBPoolManagerBasic dbpm) {
        this.orderdao = new OrderDAOImpl(dbpm);
    }

    @Override
    public boolean add(User user, List<LineItem> lineItem, UserAddress userAddress, double totalPrice, Date ordrDate) {
        Order order = null;
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }

        if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (lineItem == null || lineItem.isEmpty()) {
            return false;
        }
        if(userAddress.getAddressId()<0)
        {
            return false;
        }
        order = new Order(user,  lineItem,  userAddress,  totalPrice,  ordrDate);
        return orderdao.add(order);
    }

    @Override
    public Order readOrder(Order order) {
        if(order.getOrderID()<0)
            return null;
        return orderdao.readOrder(order);
    }

    @Override
    public Order readOrder(int orderId) {
        
        if(orderId<0)
            return null;
       return orderdao.readOrder(orderId);
    }

    @Override
    public Order readOrder(User user) {
        if(user.getEmailAddress() == null || user.getEmailAddress().isEmpty())
            return null;
        return orderdao.readOrder(user);
    }

    @Override
    public List<Order> listOrder() {
        return orderdao.listOrder();
    }

    @Override
    public List<Order> listOrder(User user) {
        if(user.getEmailAddress()==null || user.getEmailAddress().isEmpty())
            return null;
        
        return orderdao.listOrder(user);
    }

    @Override
    public boolean update(Order order, User user, List<LineItem> lineItem, UserAddress userAddress, double totalPrice, Date ordrDate) {
       if(user.getEmailAddress() == null || user.getEmailAddress().isEmpty())
            return false;
         if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (lineItem == null || lineItem.isEmpty()) {
            return false;
        }
        if(userAddress.getAddressId()<0)
        {
            return false;
        }
       
        return orderdao.update(order);
    }

    @Override
    public boolean delete(Order order) {
        if(order.getOrderID()<0)
            return false;
        return orderdao.delete(order);
    }

}
