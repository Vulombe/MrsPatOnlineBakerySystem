/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.LineItem;

/**
 *
 * @author student12
 */
public interface CartService {
    public List<LineItem> readCart(int orderId);
}
