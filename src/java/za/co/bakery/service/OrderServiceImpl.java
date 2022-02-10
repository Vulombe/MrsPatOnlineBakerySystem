package za.co.bakery.service;

import java.time.LocalDate;
import java.util.List;
import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderdao;

    public OrderServiceImpl(DBPoolManagerBasic dbpm) {
        this.orderdao = new OrderDAOImpl(dbpm);

    }

    public OrderServiceImpl() {
    }

    @Override
    public boolean add(User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, LocalDate ordrDate) {
        Order order = null;

        boolean errorCheck = orderErrorCheck(order, user, cart, userAddress, totalPrice, ordrDate);
       
        if (errorCheck) {
            order = new Order(user, cart, userAddress, totalPrice, ordrDate);
            return orderdao.add(order);
        } else {
            return false;
        }
    }

    @Override
    public boolean orderErrorCheck(Order order, User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, LocalDate ordrDate) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }

        if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (cart == null || cart.getCart().isEmpty()) {
            return false;
        }
        if (userAddress.getAddressId() < 0) {
            return false;
        }

        return true;
    }

    @Override
    public Order readOrder(Order order) {
        if (order.getOrderID() < 0) {
            return null;
        }
        return orderdao.readOrder(order);
    }

    @Override
    public Order readOrder(int orderId) {

        if (orderId < 0) {
            return null;
        }
        return orderdao.readOrder(orderId);
    }

    @Override
    public Order readOrder(User user) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return null;
        }
        return orderdao.readOrder(user);
    }
     @Override
    public Order readLastOrder( User user) {
       
        return orderdao.lastOrder(user);
    }


    @Override
    public List<Order> listOrder() {
        return orderdao.listOrder();
    }

    @Override
    public List<Order> listOrder(User user) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return null;
        }

        return orderdao.listOrder(user);
    }

    @Override
    public boolean update(User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, LocalDate ordrDate) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }
        if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (cart == null || cart.getCart().isEmpty()) {
            return false;
        }
        if (userAddress.getAddressId() < 0) {
            return false;
        }

        Order o = new Order(user, cart, userAddress, totalPrice, ordrDate);

        return orderdao.update(o);
    }

    @Override
    public boolean delete(Order order) {
        if (order.getOrderID() < 0) {
            return false;
        }
        return orderdao.delete(order);
    }

    


}
