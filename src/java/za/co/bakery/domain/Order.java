package za.co.bakery.domain;

import java.util.Date;
import java.util.List;

public class Order {

    private int orderID;
    private User user;
    private LineItemCollection lineItem;
    private UserAddress userAddress;
    private double totalPrice;
    private Date ordrDate;

    public int getOrderID() {
        return orderID;
    }

    public Order() {
    }

    public Order(User user, LineItemCollection lineItem, UserAddress userAddress, double totalPrice, Date ordrDate) {
        this.user = user;
        this.lineItem = lineItem;
        this.userAddress = userAddress;
        this.totalPrice = totalPrice;
        this.ordrDate = ordrDate;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Date getOrdrDate() {
        return ordrDate;
    }

    public void setOrdrDate(Date ordrDate) {
        this.ordrDate = ordrDate;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", user=" + user + ", lineItem=" + lineItem + ", userAddress=" + userAddress + ", totalPrice=" + totalPrice + ", ordrDate=" + ordrDate + '}';
    }

}
