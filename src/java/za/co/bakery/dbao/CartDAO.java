/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.LineItem;

import za.co.bakery.domain.Order;


/**
 *
 * @author Studio13
 */
public interface CartDAO {

    public boolean addcartLine(Order o);

    public LineItem readCartLine(int lineItemCollectionId);

  public List<LineItem> readCart(int orderId);

}
