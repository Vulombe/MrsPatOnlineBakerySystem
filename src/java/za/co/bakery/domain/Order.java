package za.co.bakery.domain;

import java.util.List;

public class Order {

    private int orderID;
    private User user;
    private LineItemCollection lineItem;
    private UserAddress custAddress;
    private double totalPrice;

    public Order(User user, LineItemCollection lineItem, UserAddress custAddress) {
        this.user = user;
        this.lineItem = lineItem;
        this.custAddress = custAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LineItemCollection getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItemCollection lineItem) {
        this.lineItem = lineItem;
    }

    public UserAddress getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(UserAddress custAddress) {
        this.custAddress = custAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    


}
