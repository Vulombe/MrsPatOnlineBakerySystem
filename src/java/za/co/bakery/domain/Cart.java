package za.co.bakery.domain;

import java.util.List;

/**
 *
 * @author Stuart Littles
 */
public class Cart {
    private List<LineItem> cart = null;
    private static int userID = 0;
    private static Cart userCart = null;
    
    private Cart(Product p, int qty, User user){
        LineItem item = new LineItem(p,qty);
        this.cart.add(item);
        this.setUserID(user.getID());
    }
    
    public static Cart Cart(Product p, int qty, User user){
        if (userID == 0){
           userCart = new Cart(p,qty,user);
        }
        return userCart;
    }

    public List<LineItem> getCart() {
        return cart;
    }

    public void setCart(List<LineItem> cart, int userID) {
        this.cart = cart;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public void addProduct(Product p,int qty){
        LineItem e = new LineItem(p,qty);
        this.getCart().add(e);
    }
    
    public boolean cartCheck(){
        return (this.getCart() != null);
    }
  
    public void editCart(Product p, int qty){
        this.getCart().get(this.getCart().indexOf(p)).setQty(qty);
        
        if(this.getCart().get(this.getCart().indexOf(p)).getQty() == 0){
            this.getCart().remove(this.getCart().indexOf(p));
        }
    }
    
    public void removeItem(Product p){
        this.getCart().remove(this.getCart().indexOf(p));
    }
    
    public void clearCart(){
        this.getCart().clear();
    }
    
    
}
