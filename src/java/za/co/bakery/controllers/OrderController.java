package za.co.bakery.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;

import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.CartService;
import za.co.bakery.service.CartServiceImpl;
import za.co.bakery.service.InvoiceService;
import za.co.bakery.service.InvoiceServiceImpl;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.UserAddressService;
import za.co.bakery.service.UserAddressServiceImpl;
import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;

public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = request.getServletContext();
        DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
        OrderService orderService = new OrderServiceImpl(dbpm);
        UserAddressService userAddressService = new UserAddressServiceImpl(dbpm);
        UserService userService = new UserServiceImpl(dbpm);
        CartService cartService = new CartServiceImpl(dbpm);
        InvoiceService invoiceService = new InvoiceServiceImpl();
        HttpSession session = request.getSession();
        String prs = request.getParameter("pro");
        RequestDispatcher view = null;
        User user = userService.read("marys@gmail.com");

        LineItemCollection lineItemList = null;

        double totalPrice = 12.00;
        UserAddress userAddress = userAddressService.readUserAddress(user);

        LocalDate ordrDate = LocalDate.now();

        if (prs != null) {
            prs = prs.toLowerCase();
        }
        switch (prs) {

            case "ocreate":
                lineItemList = (LineItemCollection) request.getSession().getAttribute("cart");
                boolean orderAddedd = orderService.add(user, lineItemList, userAddress, totalPrice, ordrDate);
                if (orderAddedd) {

                    session.setAttribute("msg", orderAddedd);
                    view = request.getRequestDispatcher("index.jsp");
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
                    view = request.getRequestDispatcher("index.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid Order information");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
                break;
            case "olist":
                request.setAttribute("orderList", orderService.listOrder(user));
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
                break;
            case "invoice":
                Order order = orderService.readOrder(1);
                if (order != null) {
                    String invoicePath = invoiceService.getInvoice(order);
                    InvoiceService service = new InvoiceServiceImpl();

                    service.sendInvoiceEmail(invoicePath, "vmakhubele@gmail.com","%vul53241991", "dave.makhubele@gmail.com");
                    view = request.getRequestDispatcher("index.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid Order information");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
                break;
       
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
