package za.co.bakery.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stuart Littles
 */
public class LineItemCollection {

    private List<LineItem> cart = null;

    public LineItemCollection() {
        cart = new ArrayList<LineItem>();
    }

    public LineItemCollection(Product p, int qty) {
        this();
        this.addProduct(p, qty);
    }

    public List<LineItem> getCart() {
        return cart.subList(0, cart.size());
    }

    public void addProduct(Product p, int qty) {
        LineItem e= new LineItem(p, qty);
        this.getCart().add(e);
    }

    public void editCartQty(Product p, int qty) {
        this.getCart().get(this.getCart().indexOf(p)).setQty(qty);

        if (this.getCart().get(this.getCart().indexOf(p)).getQty() == 0) {
            removeItem(p);
        }
    }

    public void removeItem(Product p) {
        this.getCart().remove(this.getCart().indexOf(p));
    }

    public void clearCart() {
        this.getCart().clear();
    }

}