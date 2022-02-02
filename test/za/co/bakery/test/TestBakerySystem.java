
package za.co.bakery.test;

import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;


public class TestBakerySystem 
{
   
    
    public static void main(String[] args)
    {
         OrderService invoicePdf = new OrderServiceImpl();
         invoicePdf.getInvoice();
    }
}
