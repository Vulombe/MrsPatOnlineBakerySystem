package za.co.bakery.domain;

import java.util.ArrayList;
import java.util.List;
import za.co.bakery.dbao.ProductLineItemDAO;
import za.co.bakery.dbao.impl.IngredientDAOImpl;
import za.co.bakery.dbao.impl.ProductDAOImpl;
import za.co.bakery.dbao.impl.ProductLineItemDAOImpl;
import za.co.bakery.dbao.impl.RecipeDAOImpl;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Stuart Littles
 */
public class LineItemCollection {

    private List<LineItem> cart = null;
    private ProductLineItemDAO productLineItemDAO;
    
     public LineItemCollection(DBPoolManagerBasic dbpm) {
        this.productLineItemDAO = new ProductLineItemDAOImpl(dbpm);
        cart = new ArrayList<LineItem>();
    }

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
        LineItem e = productLineItemDAO.readProductLineItem(p);
//        LineItem e = new LineItem(p,qty);
        e.setQty(qty);
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

    public int size() {
        return cart.size();
    }

    public double total() {
        double total = 0.0;
        
        if (this.getCart() != null) {
            
            for (LineItem lineItem : this.getCart()) {
                total = total + lineItem.productPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "LineItemCollection{" + "cart=" + cart + ", productLineItemDAO=" + productLineItemDAO + '}';
    }
    
}
