package za.co.bakery.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.domain.Invoice;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderdao;

    public OrderServiceImpl(DBPoolManagerBasic dbpm) {
        this.orderdao = new OrderDAOImpl(dbpm);

    }

    @Override
    public boolean add(User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, Date ordrDate) {
        Order order = null;

        boolean errorCheck = orderErrorCheck(order, user, cart, userAddress, totalPrice, ordrDate);
        if (errorCheck) {
            order = new Order(user, cart, userAddress, totalPrice, ordrDate);
            return orderdao.add(order);
        } else {
            return false;
        }
    }

    @Override
    public boolean orderErrorCheck(Order order, User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, Date ordrDate) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }

        if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (cart == null || cart.getCart().isEmpty()) {
            return false;
        }
        if (userAddress.getAddressId() < 0) {
            return false;
        }

        return true;
    }

    @Override
    public Order readOrder(Order order) {
        if (order.getOrderID() < 0) {
            return null;
        }
        return orderdao.readOrder(order);
    }

    @Override
    public Order readOrder(int orderId) {

        if (orderId < 0) {
            return null;
        }
        return orderdao.readOrder(orderId);
    }

    @Override
    public Order readOrder(User user) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return null;
        }
        return orderdao.readOrder(user);
    }

    @Override
    public List<Order> listOrder() {
        return orderdao.listOrder();
    }

    @Override
    public List<Order> listOrder(User user) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return null;
        }

        return orderdao.listOrder(user);
    }

    @Override
    public boolean update(User user, LineItemCollection cart, UserAddress userAddress, double totalPrice, Date ordrDate) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }
        if (totalPrice <= 0.0) {
            return false;
        }
        if (ordrDate == null) {
            return false;
        }
        if (cart == null || cart.getCart().isEmpty()) {
            return false;
        }
        if (userAddress.getAddressId() < 0) {
            return false;
        }

        Order o = new Order(user, cart, userAddress, totalPrice, ordrDate);

        return orderdao.update(o);
    }

    @Override
    public boolean delete(Order order) {
        if (order.getOrderID() < 0) {
            return false;
        }
        return orderdao.delete(order);
    }

    @Override
    public PDDocument getInvoice(Order order) {
        if (order.getOrderID() <= 0) {
            return null;
        }

        PDDocument invoicePDF = new PDDocument();
        try {

            //Create Blank Page
            PDPage invoicePage = new PDPage();
            //Add the blank page
            invoicePDF.addPage(invoicePage);
            invoicePage = invoicePDF.getPage(0);

            PDPageContentStream cs = new PDPageContentStream(invoicePDF, invoicePage);
            cs.beginText();
            cs.newLineAtOffset(140, 750);
            cs.showText("Invoice of: " + order.getUser().getFirstName() + " " + order.getUser().getLastName());
            cs.endText();

            cs.beginText();
            cs.setLeading(20f);
            cs.newLineAtOffset(60, 610);
            cs.showText("Products Purchased: ");
            cs.newLine();
            for (LineItem lineItem : order.getLineItem().getCart()) {
                cs.showText("Name: " + lineItem.getProduct().getName() + "\t Price R" + lineItem.getProduct().getPrice());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setLeading(20f);
            cs.newLineAtOffset(60, 610);
            cs.showText("User Address");
            cs.newLine();
            cs.showText("House Number: " + order.getUserAddress().getHouseNumber());
            cs.newLine();
            cs.showText("Street Name: " + order.getUserAddress().getStreetName());
            cs.newLine();
            cs.showText("City: " + order.getUserAddress().getCity());
            cs.newLine();
            cs.showText("State: " + order.getUserAddress().getState());
            cs.newLine();
            cs.showText("Code: " + order.getUserAddress().getZipCode());
            cs.newLine();
            cs.endText();

            cs.beginText();
            cs.newLineAtOffset(140, 750);
            cs.showText("Order Date: " + order.getOrdrDate());
            cs.endText();

            cs.beginText();
            cs.setLeading(20f);
            cs.newLineAtOffset(140, 750);
            cs.showText("Tax: " + order.getLineItem().tax());
            cs.newLine();
            cs.showText("Shipping Price: " + order.getLineItem().shipping());
            cs.newLine();
            cs.showText("Total Price: " + order.getLineItem().total());
            cs.endText();

            cs.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoicePDF;
    }

}
