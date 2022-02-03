/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;
import za.co.bakery.domain.Invoice;
import za.co.bakery.domain.Order;
/**
 *
 * @author student12
 */
public interface InvoiceService {
    public Invoice getInvoice(Order order);
}
