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
                    String name = request.getParameter("category");
                    request.setAttribute("theTitle", name);
                    request.setAttribute("prodList", productService.getProducts(name));
                    view = request.getRequestDispatcher("viewProducts.jsp");
                    view.forward(request, response);
                    break;
                case "pcreate":

                    boolean res = productService.productAdd(request.getParameter("name"),
                            request.getParameter("picture"),
                            Double.parseDouble(request.getParameter("price")),
                            Category.valueOf(request.getParameter("category").toUpperCase()),
                            request.getParameter("warning"), request.getParameter("description"),
                            Integer.parseInt(request.getParameter("productID")));
                    request.setAttribute("isAdded", res);
                    
                    
                    if ((boolean) request.getAttribute("isAdded")) {
                        request.setAttribute("msg", "Product was added");
                    } else {
                        request.setAttribute("msg", "Product was not added");
                    }
                    
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pdelete":

                    request.setAttribute("isDeleted",
                            productService.productDelete(Integer.parseInt(request.getParameter("prodid"))));
                    
                    if ((boolean) request.getAttribute("isDeleted")) {
                        request.setAttribute("msg", "Product was deleted");
                    } else {
                        request.setAttribute("msg", "Product was not deleted");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pedit":
                    request.setAttribute("isUpdated", productService.productUpdate(Integer.parseInt("prodid"),
                            request.getParameter("field"), request.getParameter("update")));



                    if ((boolean) request.getAttribute("isUpdated")) {
                        request.setAttribute("msg", "Product was updated");
                    } else {
                        request.setAttribute("msg", "Product was not updated");
                    }
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "pupdate":
                    request.setAttribute("update", productService.productUpdate(Integer.parseInt(request.getParameter("productID")),
                            request.getParameter("field"),
                            request.getParameter("change")));
                    
                    if ((boolean) request.getAttribute("update")) {
                        request.setAttribute("msg", "Product was updated");
                    } else {
                        request.setAttribute("msg", "Product was not updated");
                    }
                    
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "cadd":
                    if (request.getSession().getAttribute("cart") != null) {
                        request.setAttribute("cart-count", productService.addToCart(request.getParameter("prodid"),
                                request.getParameter("qty"),
                                (LineItemCollection) request.getSession().getAttribute("cart")));
                    } else {
                        LineItemCollection cart = new LineItemCollection((Product) request.getSession().getAttribute("prodid"),
                                Integer.parseInt(request.getParameter("qty")));
                        request.getSession().setAttribute("cart", cart);
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "cedit":
                    request.setAttribute("cart-count", productService.addToCart(request.getParameter("prodid"),
                            request.getParameter("qty"),
                            (LineItemCollection) request.getSession().getAttribute("cart")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "cget":
                    request.setAttribute("cart-items", request.getSession().getAttribute("cart"));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "radd":
                    request.setAttribute("isAdded", productService.addRecipe("steps", "rname", (List<IngredientItem>) request.getSession().getAttribute("ingredients")));
                    
                    
                    if ((boolean) request.getAttribute("isAdded")) {
                        request.setAttribute("msg", "Recipe was added");
                    } else {
                        request.setAttribute("msg", "Recipe was not added");
                    }
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
                    break;
                case "redit":
                    request.setAttribute("update", productService.recipeUpdate(Integer.parseInt(request.getParameter("recipeID")),
                            request.getParameter("steps"),
                            (List<IngredientItem>) request.getSession().getAttribute("ingredients"), request.getParameter("recipeName")));
                    
                    
                    if ((boolean) request.getAttribute("update")) {
                        request.setAttribute("msg", "Recipe was updated");
                    } else {
                        request.setAttribute("msg", "Recipe was not updated");
                    }
                    
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    view.forward(request, response);
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
