
package za.co.bakery.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import za.co.bakery.domain.Order;

public interface InvoiceService {
    
    public PDDocument getInvoice(Order order);

}
