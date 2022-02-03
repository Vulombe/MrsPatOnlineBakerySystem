/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
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
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.ProductService;
import za.co.bakery.service.ProductServiceImpl;
import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;

/**
 *
 * @author Student03
 */
public class AdminController extends HttpServlet {

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
                case "padd":
                    request.setAttribute("admin", "padd");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "pedt":
                    request.setAttribute("admin", "pedit");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "pdel":
                    request.setAttribute("admin", "pdelete");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "radd":
                    request.setAttribute("admin", "radd");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "redit":
                    request.setAttribute("admin", "redit");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "rdel":
                    request.setAttribute("admin", "rdel");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "aadd":
                    request.setAttribute("admin", "aadd");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "aedit":
                    request.setAttribute("admin", "aupdate");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
                    view.forward(request, response);
                    break;
                case "adel":
                    request.setAttribute("admin", "adelete");
                    view = request.getRequestDispatcher("AdminAdd.jsp");
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