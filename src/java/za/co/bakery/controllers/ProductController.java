/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.bakery.domain.Category;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.ProductService;
import za.co.bakery.service.ProductServiceImpl;
import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;

/**
 *
 * @author Student03
 */
public class ProductController extends HttpServlet {

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
        RequestDispatcher view;
        if (prs != null) {
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            ProductService productService = new ProductServiceImpl(dbpm);
            UserService userService = new UserServiceImpl(dbpm);
            prs = prs.toLowerCase();
            switch (prs) {
                case "pview-single":
                    request.setAttribute("prod", productService.getProduct(request.getParameter("prodid")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pview":
                    request.setAttribute("prod", productService.getProducts(request.getParameter("category")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pcreate":
                    
                    boolean res=productService.productAdd(request.getParameter("name"), 
                            request.getParameter("picture"), 
                            Double.parseDouble(request.getParameter("price")), 
                            Category.valueOf(request.getParameter("category").toUpperCase()), 
                            request.getParameter("warning"), request.getParameter("description"), 
                            Integer.parseInt(request.getParameter("productID")));
                            request.setAttribute("isAdded", res);                    
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pdelete":
//                    request.setAttribute("isDeleted", 
//                            productService.productDelete(Integer.parseInt(request.getParameter("prodId")),
//                            request.getParameter("name"), 
//                            request.getParameter("picture"), 
//                            Double.parseDouble(request.getParameter("price")), 
//                            Category.valueOf(request.getParameter("category").toUpperCase()), 
//                            request.getParameter("warning"), request.getParameter("description"), 
//                            Integer.parseInt(request.getParameter("productID"))));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pedit":
                    break;
                case "cadd":
                    request.setAttribute("added", productService.addToCart(request.getParameter("prodid"),
                            request.getParameter("qty"),
                            userService.read("user")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);                    
                    
                    break;
            }

        } else {
            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
        }
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
