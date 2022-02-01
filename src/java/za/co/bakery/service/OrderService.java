
package za.co.bakery.service;

import java.util.Date;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import za.co.bakery.domain.Invoice;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;

public interface OrderService {
    public boolean add(User user, LineItemCollection cart , UserAddress userAddress, double totalPrice, Date ordrDate);

    public Order readOrder(Order o);

    public Order readOrder(int OrderId);

    public Order readOrder(User u);

    public List<Order> listOrder();

    public List<Order> listOrder(User u);

    public boolean update(User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, Date ordrDate);
    public boolean orderErrorCheck(Order order,User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, Date ordrDate);
    public boolean delete(Order o);
    public PDDocument getInvoice(Order order);
}
