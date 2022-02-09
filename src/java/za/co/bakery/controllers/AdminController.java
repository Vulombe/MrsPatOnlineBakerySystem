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
import za.co.bakery.domain.Recipe;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.ProductService;
import za.co.bakery.service.ProductServiceImpl;

/**
 *
 * @author Student03
 */
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prs = request.getParameter("pro");
        ServletContext sc = request.getServletContext();
        RequestDispatcher view;
        if (prs != null) {
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            ProductService productService = new ProductServiceImpl(dbpm);
            prs = prs.toLowerCase();
            switch (prs) {
                case "padd":
                    List<Recipe> rec=productService.getRecipes();
                    request.setAttribute("recipes", rec);
                    request.setAttribute("admin", "padd");
                    break;
                case "pedt":
                    request.setAttribute("admin", "pedit");
                    request.setAttribute("prolist",productService.getAllProducts() );
                    break;
                case "pdel":
                    request.setAttribute("admin", "pdelete");
                    break;
                case "radd":
                    request.setAttribute("ingredientList", productService.getIngredients());
                    request.setAttribute("admin", "radd");
                    break;
                case "redit":
                    request.setAttribute("admin", "redit");
                    break;
                case "rdel":

                    request.setAttribute("admin", "rdel");
                    break;
                case "aadd":
                    request.setAttribute("admin", "aadd");
                    break;
                case "aedit":
                    request.setAttribute("admin", "aupdate");
                    break;
                case "adel":
                    request.setAttribute("admin", "adelete");
                    break;
                case "iadd":
                    request.setAttribute("admin", "iadd");
                    break;
                case "iedit":
                    request.setAttribute("admin", "iedit");
                    break;
                case "idel":
                    request.setAttribute("admin", "idelete");
                    break;
                case "ilist":
                    request.setAttribute("ingredientList", productService.getIngredients());
                    break;
                case "plist":
                    request.setAttribute("products", productService.getProducts(request.getParameter("category")));
                    view = request.getRequestDispatcher("productDel.jsp");
                    view.forward(request, response);
                    break;
                case "rlist":
                    request.setAttribute("recipes", productService.getRecipes());
                    break;
            }
            view = request.getRequestDispatcher("adminAdd.jsp");
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
