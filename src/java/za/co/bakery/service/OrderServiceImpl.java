package za.co.bakery.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.impl.OrderDAOImpl;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import za.co.bakery.domain.InvoiceColumns;
import za.co.bakery.domain.LineItemPractise;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderdao;

    public OrderServiceImpl(DBPoolManagerBasic dbpm) {
        this.orderdao = new OrderDAOImpl(dbpm);

    }

    public OrderServiceImpl() {
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
            PDFont font = PDType1Font.HELVETICA;
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
            invoicePDF.save("c:/Invoice.pdf");
        } catch (IOException ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoicePDF;
    }

    @Override
    public PDDocument getInvoice() {

        PDDocument invoicePDF = new PDDocument();
        List<LineItemPractise> items = new ArrayList<LineItemPractise>();
        int count = 0;
        items.add(new LineItemPractise("Banana Cake", 10, 150));
        items.add(new LineItemPractise("Fruit Cake", 8, 200));
        items.add(new LineItemPractise("Queens Cake", 3, 300));
        items.add(new LineItemPractise("Choclate Cake", 12, 250));
        items.add(new LineItemPractise("Pie Cake", 6, 70));
        try {

            //Create Blank Page
            PDPage invoicePage = new PDPage();
            //Add the blank page
            invoicePDF.addPage(invoicePage);
            invoicePage = invoicePDF.getPage(0);
            //PDFont font = PDType1Font.HELVETICA;
            PDPageContentStream cs = new PDPageContentStream(invoicePDF, invoicePage);
            //cs.setFont(font, 16);
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 20);
            cs.newLineAtOffset(255, 760);
            cs.showText("INVOICE");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 8);
            cs.setLeading(9f);
            cs.newLineAtOffset(500, 740);
            cs.showText("Date: ");
            cs.newLine();
            cs.showText("Time: ");
            cs.newLine();
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 7);
            cs.setLeading(10f);
            cs.newLineAtOffset(30, 710);
            cs.showText("From: Mrs Pat Bekery System");
            cs.newLine();
            cs.showText("Email: MrsPatBekery@bakery.co.za");
            cs.newLine();
            cs.showText("Address: 322 15th Rd, Randjespark, Midrand, 1685");
            cs.newLine();
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 7);
            cs.setLeading(10f);
            cs.newLineAtOffset(400, 710);
            cs.showText("TO: Mary Scary");
            cs.newLine();
            cs.showText("Email: marys@gmail.com");
            cs.newLine();
            cs.showText("Address: House No. 877, Tsakani Street, Pretoria, 1010");
            cs.newLine();
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 20);
            cs.newLineAtOffset(250, 650);
            cs.showText("Products Purchased ");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, 635);
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(140, 625);
            cs.showText("PRODUCT NAME");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(260, 625);
            cs.showText("QUANTITY");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(360, 625);
            cs.showText("UNIT PRICE");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.setLeading(15f);
            cs.newLineAtOffset(140, 610);
            for (LineItemPractise lineItem : items) {
                cs.showText(lineItem.getProduct());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.setLeading(15f);
            cs.newLineAtOffset(260, 610);
            for (LineItemPractise lineItem : items) {
                cs.showText(lineItem.getQty() + "");
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.setLeading(15f);
            cs.newLineAtOffset(360, 610);
            int size = items.size();
            double total = 0.0;
            for (LineItemPractise lineItem : items) {
                size = size - 1;
                cs.showText("R " + lineItem.getPrice());
                total += lineItem.getPrice();
                cs.newLine();

            }
            cs.endText();

            double tax = total * 0.15;
            double shiping;
            if (total > 500) {
                shiping = 0.0;
            } else {
                shiping = 50.0;
            }
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, 450);
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.beginText();
            cs.setLeading(13);
            cs.newLineAtOffset(390, 440);
            cs.showText("Tax: R" + tax);
            cs.newLine();
            cs.showText("Shipping Price: R" + shiping);
            cs.newLine();
            cs.showText("Total Price: R" + total);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, 400);
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.close();
            invoicePDF.save(new File("c:\\pdf\\Invoice.pdf"));
            invoicePDF.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoicePDF;
    }
}
