/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.domain;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author student12
 */
public class Invoice {
    private Order order;
    private int invoiceID;
 
    public Invoice(Order order) {
        this.order = order;
       
    }
 

    public Invoice() {
        
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    @Override
    public String toString() {
        return "Invoice{" + "order=" + order + ", invoice=" + invoiceID + '}';
    }

    
}
