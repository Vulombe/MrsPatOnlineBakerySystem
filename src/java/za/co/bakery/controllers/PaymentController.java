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
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.PaymentService;
import za.co.bakery.service.PaymentServiceImpl;

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
        LineItemCollection cart = (LineItemCollection)request.getAttribute("cart");
        if (prs != null) {
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            PaymentService paymentService = new PaymentServiceImpl(dbpm);
            OrderService orderService = new OrderServiceImpl(dbpm);

            prs = prs.toLowerCase();
            switch (prs) {
                case "payment":
                    request.setAttribute("paid", paymentService.makePayment(request.getParameter("cardNumber"), request.getParameter("cvvNumber"), request.getParameter("paymentType")));
                    if((boolean)request.getAttribute("paid")){
                        orderService.add((User)request.getSession().getAttribute("user"),cart, (UserAddress)request.getSession().getAttribute("userAddress"), cart.grandTotal(), date);
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