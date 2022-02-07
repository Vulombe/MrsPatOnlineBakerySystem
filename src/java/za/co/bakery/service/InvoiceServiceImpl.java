/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Order;

/**
 *
 * @author student12
 */
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public void getInvoice(Order order, List<LineItem> cartitems) {

        PDDocument invoicePDF = new PDDocument();
        LocalTime invoiceTime = LocalTime.now();
        DateTimeFormatter invoiceTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String invoiceTimeformart = invoiceTime.format(invoiceTimeFormat);

        try {

            //Create Blank Page
            PDPage invoicePage = new PDPage();
            //Add the blank page
            invoicePDF.addPage(invoicePage);
            invoicePage = invoicePDF.getPage(0);
            PDPageContentStream cs = new PDPageContentStream(invoicePDF, invoicePage);

            if (order.getOrderID() <= 0) {
                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 20);
                cs.newLineAtOffset(255, 760);
                cs.showText("Invalid order information");
                cs.endText();
            }

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 20);
            cs.newLineAtOffset(255, 760);
            cs.showText("INVOICE");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 8);
            cs.setLeading(9f);
            cs.newLineAtOffset(500, 740);
            cs.showText("Date: " + LocalDate.now());
            cs.newLine();
            cs.showText("Time: " + invoiceTimeformart);
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
            cs.showText("To: " + order.getUser().getFirstName() + " " + order.getUser().getLastName());
            cs.newLine();
            cs.showText("Email: " + order.getUser().getEmailAddress());
            cs.newLine();
            cs.showText("Address: " + order.getUserAddress().getHouseNumber() + ","
                    + order.getUserAddress().getStreetName() + ","
                    + order.getUserAddress().getState() + ","
                    + order.getUserAddress().getCity() + ","
                    + order.getUserAddress().getZipCode());
            cs.newLine();
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
            cs.setLeading(12f);
            cs.newLineAtOffset(140, 610);
            for (LineItem lineItems : cartitems) {
                cs.showText(lineItems.getProduct().getName());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.setLeading(12f);
            cs.newLineAtOffset(260, 610);
            for (LineItem lineItems : cartitems) {
                cs.showText(lineItems.getQty() + "");
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.setLeading(12f);
            cs.newLineAtOffset(360, 610);
            for (LineItem lineItems : cartitems) {
                cs.showText("R" + lineItems.getProduct().getPrice());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, 450);
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.beginText();
            cs.setLeading(13);
            cs.newLineAtOffset(390, 440);
            cs.showText("Tax: R" + order.getLineItem().tax());
            cs.newLine();
            cs.showText("Shipping Price: R" + order.getLineItem().shipping());
            cs.newLine();
            cs.showText("Total Price: R" + order.getLineItem().total());
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, 400);
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.close();
            LocalDate date = LocalDate.now();
            String name = order.getUser().getLastName() + "-"+order.getOrderID() + "-" + date;
            Path path = Paths.get("C:\\MrsPatOnlineBakerySystem\\project documents\\" + name);
            Files.createDirectories(path);
            String p1 = path.toString();
            invoicePDF.save(p1 + "\\Invoive.pdf");
            invoicePDF.close();
        } catch (IOException ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
