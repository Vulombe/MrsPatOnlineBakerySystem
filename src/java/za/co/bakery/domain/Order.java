package za.co.bakery.domain;

public class Order {

    private User user;
    private UserAddress custAddress;
    private double totalPrice;

    public Order(User user, UserAddress custAddress, double totalPrice) {
        this.user = user;
        this.custAddress = custAddress;
        this.totalPrice = totalPrice;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
