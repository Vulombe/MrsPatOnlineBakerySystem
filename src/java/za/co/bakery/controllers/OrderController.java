/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import za.co.bakery.domain.LineItemCollection;

import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.UserAddressService;
import za.co.bakery.service.UserAddressServiceImpl;

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
        User user = (User) request.getAttribute("user");
        LineItemCollection lineItemList = (LineItemCollection) request.getAttribute("cart-items");
        double totalPrice = lineItemList.total();
        UserAddress userAddress = userAddressService.readUserAddress(user);
        Date ordrDate = new Date();

        if (prs != null) {
            prs = prs.toLowerCase();
        }
        switch (prs) {

            case "ocreate":

                boolean orderAddedd = orderService.add(user, lineItemList, userAddress, totalPrice, ordrDate);
                if (orderAddedd) {
                    session.setAttribute("orderAdded", orderAddedd);
                    session.setAttribute("msg", orderAddedd);
                    view = request.getRequestDispatcher("TestingPage.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid Order information");
                    session.setAttribute("orderAdded", orderAddedd);
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
                break;
            case "oread":
                if ((boolean) session.getAttribute("orderAdded")) {
                    request.setAttribute("order", orderService.readOrder(user));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid Order information");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
                break;
            case "olist":
                request.setAttribute("orderList", orderService.listOrder(user));
                view = request.getRequestDispatcher("TestingPage.jsp");
                view.forward(request, response);
                break;
//            case "oupdate":
//                request.setAttribute("oupdate", orderService.update((User)session.getAttribute("user"),(LineItemCollection) session.getAttribute("cart"), (UserAddress)request.getAttribute("useraddressvalid"), totalPrice, ordrDate));

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
