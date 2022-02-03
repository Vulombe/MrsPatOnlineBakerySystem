/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.domain;

import java.util.List;

/**
 *
 * @author student12
 */
public class Invoice {
    private Order order;
    private int invoiceID;

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

    public Invoice(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    public Invoice(){
        
    }
    
}
