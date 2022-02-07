package za.co.bakery.domain;


public class LineItem {
    private Product product;
    private int qty;
    private int ingredientId;
    private int productID;
    private int lineItemId;

    public int getProductID() {
        return productID;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemID) {
        this.lineItemId = lineItemID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public LineItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }
    
    public LineItem(){
        
    }
    
    public LineItem(int ingredientID, int qty){
        this.ingredientId = ingredientID;
        this.qty = qty;
    }
    
    public LineItem(int lineItemID, Product p, int Qty){
        this.product = p;
        this.qty = Qty;
        this.lineItemId = lineItemID;
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
    
    public double price(){
        return this.getProduct().getPrice()*this.getQty();
    }

    @Override
    public String toString() {
        return "LineItem{" + "product=" + product + ", qty=" + qty + ", ingredientId=" + ingredientId + ", productID=" + productID + ", lineItemId=" + lineItemId + '}';
    }
    
   
    
}