
package za.co.bakery.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import za.co.bakery.domain.Order;

public interface InvoiceService {
    
    public String getInvoice(Order order);
    public void sendInvoiceEmail (String invoicePDF,String emailSender,String password, String emailTo);

}
