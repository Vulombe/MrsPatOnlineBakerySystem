package za.co.bakery.domain;

import java.util.List;

public class Order {

    private int orderID;
    private User user;
    private List<LineItem> lineItem;
    private UserAddress custAddress;
    private double totalPrice;

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

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
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
