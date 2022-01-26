
package za.co.bakery.service;

import java.util.Date;
import java.util.List;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;

public interface OrderService {
     public boolean add(User user, List<LineItem> lineItem, UserAddress userAddress, double totalPrice, Date ordrDate);

    public Order readOrder(Order o);

    public Order readOrder(int OrderId);

    public Order readOrder(User u);

    public List<Order> listOrder();

    public List<Order> listOrder(User u);

    public boolean update(Order order,User user, List<LineItem> lineItem, UserAddress userAddress, double totalPrice, Date ordrDate);

    public boolean delete(Order o);
}
