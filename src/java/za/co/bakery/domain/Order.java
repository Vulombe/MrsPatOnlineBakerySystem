package za.co.bakery.domain;

import java.util.Date;
import java.util.List;

public class Order {

    private int orderID;
    private User user;
    private List<LineItem> lineItem;
    private UserAddress userAddress;
    private double totalPrice;
    private Date ordrDate;

    public int getOrderID() {
        return orderID;
    }

    public Order() {
    }

    public Order(User user, List<LineItem> lineItem, UserAddress userAddress, double totalPrice, Date ordrDate) {
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

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}