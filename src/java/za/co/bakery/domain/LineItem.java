package za.co.bakery.domain;

/**
 *
 * @author Stuart Littles
 */
public class LineItem {
    private Product product;
    private int qty;
    private int ingredientId;

    public LineItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
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
    
    
    
}
