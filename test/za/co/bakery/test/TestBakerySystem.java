package za.co.bakery.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import za.co.bakery.domain.LineItemPractise;
import za.co.bakery.service.InvoiceService;
import za.co.bakery.service.InvoiceServiceImpl;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;

public class TestBakerySystem {

    public static void main(String[] args) {
        InvoiceService service = new InvoiceServiceImpl();
        String invoicePDF = "C:\\MrsPatOnlineBakerySystem\\project documents\\PDF Documents\\name\\Invoive.pdf";
        service.sendInvoiceEmail(invoicePDF, "manqobamilk@gmail.com", "0769192723", "vmakhubele@gmail.com");
    }
    //new TestBakerySystem().getInvoice();
//          int length = 10;
//    boolean useLetters = true;
//    boolean useNumbers = true;
//    String generatedString = RandomStringUtils.random(4, useLetters, useNumbers);
//    System.out.println(generatedString);

}
