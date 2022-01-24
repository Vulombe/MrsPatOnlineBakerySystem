package za.co.bakery.domain;

/**
 *
 * @author Stuart Littles
 */
public class LineItem {
    private int lineItemId;
    private Product product;
    private int qty;

    public LineItem(int lineItemId,Product product, int qty) {
        this.lineItemId=lineItemId;
        this.product = product;
        this.qty = qty;
    }

    LineItem(Product p, int qty) {
        this.product = p;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }
    
    
    
}
