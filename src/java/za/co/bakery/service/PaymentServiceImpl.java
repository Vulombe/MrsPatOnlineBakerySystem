/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.Payment;
import za.co.bakery.domain.PaymentType;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Stuart Littles
 */
public class PaymentServiceImpl implements PaymentService{
    private OrderDAO orderDAO = null;
    private Payment payment;
    
    public PaymentServiceImpl(DBPoolManagerBasic dbpm){
        orderDAO = new OrderDAOImpl(dbpm);
    }

    @Override
    public boolean makePayment(String cardNumber, String cvvNumber, String paymentType) {
        String type = paymentType.toUpperCase();
        
        
        if(!type.isEmpty()){
            payment = new Payment(PaymentType.valueOf(type));
            if(type.equals("CARD")){
                if(cardNumber.isEmpty()){
                    return false;
                }
                if(cvvNumber.isEmpty()){
                    return false; 
                }
                return payment.makePayment();
        }
    }else{
                return false;
            }

    
    return false;
}
}
