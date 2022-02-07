
package za.co.bakery.domain;


public class Cart {
    private int orderID;

    public Cart(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Cart{" + "orderID=" + orderID + '}';
    }
    
}
