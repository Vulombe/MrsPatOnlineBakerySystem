/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.dbao.CartDAO;
import za.co.bakery.dbao.impl.CartDAOImpl;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.LineItem;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author student12
 */
public class CartServiceImpl implements CartService{
    private CartDAO cartDAO;
      public CartServiceImpl(DBPoolManagerBasic dbpm) {
        this.cartDAO = new CartDAOImpl(dbpm);
    }

    @Override
    public List<LineItem> readCart(int orderId) {
        if(orderId<=0)
        {
            return null;
        }
        return cartDAO.readCart(orderId);
    }
}
