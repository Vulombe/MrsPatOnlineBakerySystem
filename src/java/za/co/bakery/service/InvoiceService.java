
package za.co.bakery.service;
import java.util.List;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Order;

public interface InvoiceService {
    
    public void getInvoice(Order order,List<LineItem> lineItem);

}
