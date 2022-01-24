package za.co.bakery.dbao;

import za.co.bakery.domain.Order;

public interface OrderDAO {

    public boolean add(Order o);

    public Order readOrder(Order o);

    public Order readIngridientById(int Id);
}
