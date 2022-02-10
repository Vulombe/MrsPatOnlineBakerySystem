/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Order;

/**
 *
 * @author student12
 */
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public String getInvoice(Order order) {
        String invoicePath = null;
        PDDocument invoicePDF = new PDDocument();
        LocalTime invoiceTime = LocalTime.now();
        LocalDate invoiceDate = LocalDate.now();
        DateTimeFormatter iDateFormat = DateTimeFormatter.ofPattern("MM:dd:yyyy");

        DateTimeFormatter invoiceTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter invoiceDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String invoiceTimeformart = invoiceTime.format(invoiceTimeFormat);
        String invoiceDateformart = invoiceDate.format(invoiceDateFormat);
        double total = 0.0;

        try {

            //Create Blank Page
            PDPage invoicePage = new PDPage();
            //Add the blank page
            invoicePDF.addPage(invoicePage);
            invoicePage = invoicePDF.getPage(0);
            PDImageXObject pdImage = PDImageXObject.
                    createFromFile("C:/MrsPatOnlineBakerySystem/project documents/logo.jpg", invoicePDF);
            PDPageContentStream cs = new PDPageContentStream(invoicePDF, invoicePage);

            // cs.drawImage(pdImage, 200, 200);
            cs.drawXObject(pdImage, 10, 680, 150, 100);
            if (order.getOrderID() <= 0) {
                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 20);
                cs.newLineAtOffset(255, 760);
                cs.showText("Invalid order information");
                cs.endText();
            } else {

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(430, 750);
                cs.showText("Invoice Number: " + order.getUser().getFirstName().substring(0, 3).toUpperCase()
                        + order.getUser().getLastName().substring(0, 3).toUpperCase() + "_"
                        + invoiceDateformart);
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 20);
                cs.newLineAtOffset(255, 700);
                cs.showText("INVOICE");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 8);
                cs.setLeading(9f);
                cs.newLineAtOffset(500, 680);
                cs.showText("Date: " + LocalDate.now());
                cs.newLine();
                cs.showText("Time: " + invoiceTimeformart);
                cs.newLine();
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 7);
                cs.setLeading(10f);
                cs.newLineAtOffset(30, 660);
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
                cs.newLineAtOffset(400, 660);
                cs.showText("To: " + order.getUser().getFirstName() + " " + order.getUser().getLastName());
                cs.newLine();
                cs.showText("Email: " + order.getUser().getEmailAddress());
                cs.newLine();
                cs.showText("Address: " + order.getUserAddress().getHouseNumber() + ", "
                        + order.getUserAddress().getStreetName() + ", "
                        + order.getUserAddress().getState() + ", "
                        + order.getUserAddress().getCity() + ", "
                        + order.getUserAddress().getZipCode());
                cs.newLine();
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(9, 620);
                cs.showText("*********************************************************************************************************************");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(120, 610);
                cs.showText("PRODUCT NAME");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(240, 610);
                cs.showText("QUANTITY");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(340, 610);
                cs.showText("UNIT PRICE");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(420, 610);
                cs.showText("TOTAL AMOUNT");
                cs.endText();
                int size = order.getLineItem().getCart().size();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.setLeading(12f);
                cs.newLineAtOffset(120, 590);
                int count = 0;
                for (int i = 0; i < order.getLineItem().getCart().size(); i++) {
                    cs.showText(++count + "");
                    cs.newLine();
                }

                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.setLeading(12f);
                cs.newLineAtOffset(140, 590);
                for (LineItem lineItems : order.getLineItem().getCart()) {
                    cs.showText(lineItems.getProduct().getName());
                    cs.newLine();
                }
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.setLeading(12f);
                cs.newLineAtOffset(260, 590);
                for (LineItem lineItems : order.getLineItem().getCart()) {
                    cs.showText(lineItems.getQty() + "");
                    cs.newLine();
                }
                cs.endText();

                DecimalFormat df = new DecimalFormat("00.00");

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.setLeading(12f);
                cs.newLineAtOffset(360, 590);
                for (LineItem lineItems : order.getLineItem().getCart()) {
                    cs.showText("R" + df.format(lineItems.getProduct().getPrice()));
                    cs.newLine();
                }
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.setLeading(12f);
                cs.newLineAtOffset(430, 590);
                for (LineItem lineItems : order.getLineItem().getCart()) {
                    total = lineItems.getProduct().getPrice() * lineItems.getQty();
                    cs.showText("R" + df.format(total));
                    cs.newLine();
                }
                cs.endText();

                cs.beginText();

                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(9, 135);
                cs.showText("*********************************************************************************************************************");
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);

                cs.newLineAtOffset(390, 120);
                cs.showText("Total Price: R" + df.format(order.getLineItem().total()));
                cs.newLine();
                cs.showText("Tax: R" +  df.format(order.getLineItem().tax()));
                cs.newLine();
                cs.showText("Shipping Price: R" +  df.format(order.getLineItem().shipping()));
                cs.newLine();
                cs.showText("Grand Total: R" + df.format(order.getLineItem().grandTotal())) ;
                cs.endText();

                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 10);
                cs.newLineAtOffset(9, 70);
                cs.showText("*********************************************************************************************************************");
                cs.endText();

                cs.close();

                LocalDateTime date = LocalDateTime.now();

                String day = date.getDayOfWeek().toString().substring(0, 3).toLowerCase();
                String time = date.getHour() + "_" + date.getMinute();

                boolean useLetters = true;
                boolean useNumbers = false;
                String generatedString = RandomStringUtils.random(4, useLetters, useNumbers).toLowerCase();
                String name = day + "_" + generatedString + "_" + order.getUser().getLastName().toLowerCase() + "_" + time;
                Path path = Paths.get("C:\\MrsPatOnlineBakerySystem\\project documents\\" + name);
                Files.createDirectories(path);
                String p1 = path.toString();
                invoicePDF.save(p1 + "\\Invoive.pdf");
                invoicePDF.close();
                invoicePath = path.toString() + "\\Invoive.pdf";
            }
        } catch (IOException ex) {
            Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoicePath;
    }

    @Override
    public void sendInvoiceEmail(String invoicePDF, final String emailSender, final String password, String emailTo) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.startls.enable", "true");
        String host = "relay.jangosmtp.net";
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSender, password);
            }
        });
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(emailSender));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));

            message.setSubject("Invoice");

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setText("Good day Sir or Madam"
                    + "\n Please receive the Attached invoice with your order information");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            String filename = invoicePDF;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        }
    }

}
