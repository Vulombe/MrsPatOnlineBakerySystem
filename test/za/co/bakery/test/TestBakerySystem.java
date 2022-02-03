
package za.co.bakery.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import za.co.bakery.domain.LineItemPractise;
import za.co.bakery.service.InvoiceService;
import za.co.bakery.service.InvoiceServiceImpl;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;


public class TestBakerySystem 
{
   
//    
//    public static void main(String[] args)
//    {
//        //new TestBakerySystem().getInvoice();
//    }
//    
        public PDDocument getInvoice() {

        PDDocument invoicePDF = new PDDocument();
        List<LineItemPractise> items = new ArrayList<LineItemPractise>();
        int count = 0;
        items.add(new LineItemPractise("Banana Cake", 10, 150));
        items.add(new LineItemPractise("Chicken Cake", 8, 200));
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

            // PDXObjectImage logo = new PDJpeg(invoicePDF,new FileInputStream("logo.jpeg"));
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
            cs.showText("Time: " + LocalTime.now());
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
            cs.newLineAtOffset(50,(510-(30*size)));
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.beginText();
            cs.setLeading(13);
            cs.newLineAtOffset(390, (500-(20*size)));
            cs.showText("Tax: R" + tax);
            cs.newLine();
            cs.showText("Shipping Price: R" + shiping);
            cs.newLine();
            cs.showText("Total Price: R" + total);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 10);
            cs.newLineAtOffset(50, (490-(20*size)));
            cs.showText("*****************************************************************************************************");
            cs.endText();

            cs.close();
            invoicePDF.save(new File("C:\\MrsPatOnlineBakerySystem\\project documents\\Invoice.pdf"));
            invoicePDF.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return invoicePDF;
    }
}
