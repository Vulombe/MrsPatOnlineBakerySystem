/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.UserAddressService;
import za.co.bakery.service.UserAddressServiceImpl;
import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;

/**
 *
 * @author student12
 */
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
        OrderService orderService = new OrderServiceImpl(dbpm);
        UserAddressService userAddressService = new UserAddressServiceImpl(dbpm);
        HttpSession session = request.getSession();
        String prs = request.getParameter("pro");
        RequestDispatcher view = null;
        if (prs != null) {
            prs = prs.toLowerCase();
        }
        switch (prs) {

            case "ocreate":
                User user = (User) request.getAttribute("user");
                List<LineItem> lineItemList = (List) request.getAttribute("cart-items");
                UserAddress userAddress = userAddressService.readUserAddress(user);
                Date ordrDate = new Date();
                double totalPrice = 500.0;
                boolean orderAddedd = orderService.add(user, lineItemList, userAddress, totalPrice, ordrDate);
                if (orderAddedd) {
                    session.setAttribute("msg", orderAddedd);
                    view = request.getRequestDispatcher("TestingPage.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid Order information");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
