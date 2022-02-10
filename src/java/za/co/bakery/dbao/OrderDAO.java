package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;

public interface OrderDAO {

    public boolean add(Order o);

    public Order readOrder(Order o);

    public Order readOrder(int OrderId);

    public Order readOrder(User u);

    public List<Order> listOrder();

    public List<Order> listOrder(User u);
    
    public Order lastOrder(User u);

    public boolean update(Order o);

    public boolean delete(Order o);

}
