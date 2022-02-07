
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.dbao.CartDAO;
import za.co.bakery.dbao.impl.CartDAOImpl;

import za.co.bakery.domain.LineItem;
import za.co.bakery.manager.DBPoolManagerBasic;


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
