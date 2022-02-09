/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.Invoice;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.InvoiceService;
import za.co.bakery.service.InvoiceServiceImpl;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.PaymentService;
import za.co.bakery.service.PaymentServiceImpl;
import za.co.bakery.service.UserAddressService;
import za.co.bakery.service.UserAddressServiceImpl;

/**
 *
 * @author Student03
 */
public class PaymentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prs = request.getParameter("pro");
        ServletContext sc = request.getServletContext();
        RequestDispatcher view = null;
        String name = null;
        LocalDate date = LocalDate.now();
        HttpSession session = request.getSession();
        LineItemCollection cart = (LineItemCollection) session.getAttribute("cart");

        User user = (User) session.getAttribute("user");
        if (prs != null) {
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            PaymentService paymentService = new PaymentServiceImpl(dbpm);
            OrderService orderService = new OrderServiceImpl(dbpm);
            InvoiceService invoice=new InvoiceServiceImpl();
            UserAddressService userAddressService = new UserAddressServiceImpl(dbpm);

            prs = prs.toLowerCase();
            switch (prs) {
                case "payment":
                    String cardNumber = request.getParameter("cardnumber");
                    String Cvv = request.getParameter("cvvNumber");
                    String paymentType = request.getParameter("paymentType");

                  //  request.setAttribute("paid", paymentService.makePayment(cardNumber, Cvv, paymentType));
                    //boolean paid=paymentService.makePayment(cardNumber, Cvv, paymentType);
                     boolean paid=true;
                    if (paid) {
                        //orderService.add((User)request.getSession().getAttribute("user"),cart, (UserAddress)request.getSession().getAttribute("userAddress"), cart.grandTotal(), date);

                        LineItemCollection lineItemList = (LineItemCollection) request.getSession().getAttribute("cart");
                        double totalPrice = lineItemList.grandTotal();
                        LocalDate ordrDate = LocalDate.now();
                        UserAddress userAddress = userAddressService.readUserAddress(user);
                        boolean orderAddedd = orderService.add(user, lineItemList, userAddress, totalPrice, ordrDate);
                        if (orderAddedd) {
                            Order o=orderService.readLastOrder();
                            PDDocument invo=invoice.getInvoice(o);
                            view = request.getRequestDispatcher("index.jsp");
                        } else {
                            request.setAttribute("errormsg", "Invalid Order information");
                            session.setAttribute("orderAdded", orderAddedd);
                            view = request.getRequestDispatcher("error.jsp");
                        }
                        view.forward(request, response);

                    }
                    view = request.getRequestDispatcher("Testing.jsp");
                    break;

            }

        } else {
            view = request.getRequestDispatcher("error.jsp");

        }

        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
