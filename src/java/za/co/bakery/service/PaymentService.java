/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import za.co.bakery.domain.Order;

/**
 *
 * @author Stuart Littles
 */
public interface PaymentService {
    
    public boolean makePayment(String cardNumber, String cvvNumber, String paymentType);
    
}
