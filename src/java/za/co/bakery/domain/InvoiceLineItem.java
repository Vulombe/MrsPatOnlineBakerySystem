
package za.co.bakery.domain;


public class InvoiceLineItem {
    private Order order;

    public InvoiceLineItem(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
