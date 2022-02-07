
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.LineItem;


public interface CartService {
    public List<LineItem> readCart(int orderId);
}
