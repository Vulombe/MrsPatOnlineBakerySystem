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
        RequestDispatcher view = null;
        String name = null;
        if (prs != null) {
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            ProductService productService = new ProductServiceImpl(dbpm);

            prs = prs.toLowerCase();
            switch (prs) {
                case "pview-single":
                    request.setAttribute("prod", productService.getProduct(request.getParameter("prodid")));
                    view = request.getRequestDispatcher("Vproduct.jsp");
                    break;
                case "pview":

                    name = request.getParameter("category");
                    request.setAttribute("theTitle", name);
                    request.setAttribute("prodList", productService.getProducts(name));
                    view = request.getRequestDispatcher("viewProducts.jsp");
                    break;
                case "padd":

                    boolean res = productService.productAdd(request.getParameter("name"),
                            request.getParameter("picture"),
                            Double.parseDouble(request.getParameter("price")),
                            Category.valueOf(request.getParameter("category").toUpperCase()),
                            request.getParameter("warning"), request.getParameter("description"),
                            Integer.parseInt(request.getParameter("recipeID")));
                    request.setAttribute("isAdded", res);

                    if ((boolean) request.getAttribute("isAdded")) {
                        request.setAttribute("msg", "Product was added");
                    } else {
                        request.setAttribute("msg", "Product was not added");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "pdelete":

                    request.setAttribute("isDeleted",
                            productService.productDelete(request.getParameter("prodid")));

                    if ((boolean) request.getAttribute("isDeleted")) {
                        request.setAttribute("msg", "Product was deleted");
                    } else {
                        request.setAttribute("msg", "Product was not deleted");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "pedit":
                    request.setAttribute("isUpdated", productService.productUpdate(request.getParameter("prodid"),
                            request.getParameter("field"), request.getParameter("update")));

                    if ((boolean) request.getAttribute("isUpdated")) {
                        request.setAttribute("msg", "Product was updated");
                    } else {
                        request.setAttribute("msg", "Product was not updated");
                    }
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "pupdate":
                    request.setAttribute("pupdate", productService.productUpdate(request.getParameter("productID"),
                            request.getParameter("field"),
                            request.getParameter("change")));

                    if ((boolean) request.getAttribute("update")) {
                        request.setAttribute("msg", "Product was updated");
                    } else {
                        request.setAttribute("msg", "Product was not updated");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "cadd":
                    if (request.getSession().getAttribute("cart") != null) {
                        request.setAttribute("cart-count", productService.addToCart(request.getParameter("prodid"),
                                request.getParameter("qty"),
                                (LineItemCollection) request.getSession().getAttribute("cart")));
                    } else {
                        LineItemCollection cart = new LineItemCollection(dbpm);
                        request.setAttribute("cart-count", productService.addToCart(request.getParameter("prodid"),
                                request.getParameter("qty"),
                                cart));
                        request.getSession().setAttribute("cart", cart);
                    }

                    String switchVar = request.getParameter("page");

                    switch (switchVar) {
                        case "1":
                            Product p = productService.getProduct(request.getParameter("prodid"));
                            Category c = p.getCategory();
                            request.setAttribute("theTitle", c.toString());
                            request.setAttribute("prodList", productService.getProducts(c.toString()));
                            view = request.getRequestDispatcher("viewProducts.jsp");
                            break;
                        case "2":
                            request.setAttribute("prod", productService.getProduct(request.getParameter("prodid")));
                            view = request.getRequestDispatcher("Vproduct.jsp");
                            break;
                    }

                    break;
                case "cedit":
                    request.setAttribute("cart-count", productService.editCart(request.getParameter("prodid"),
                            request.getParameter("qty"),
                            (LineItemCollection) request.getSession().getAttribute("cart")));
                    view = request.getRequestDispatcher("cart.jsp");
                    break;
                case "cget":
                    request.setAttribute("cart-items", request.getSession().getAttribute("cart"));
                    view = request.getRequestDispatcher("cart.jsp");
                    break;
                case "radd":
                    request.setAttribute("isAdded", productService.addRecipe("steps", "rname", (List<IngredientItem>) request.getSession().getAttribute("ingredients")));

                    if ((boolean) request.getAttribute("isAdded")) {
                        request.setAttribute("msg", "Recipe was added");
                    } else {
                        request.setAttribute("msg", "Recipe was not added");
                    }
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "redit":
                    request.setAttribute("update", productService.recipeUpdate(request.getParameter("recipeID"),
                            request.getParameter("steps"),
                            (List<IngredientItem>) request.getSession().getAttribute("ingredients"), request.getParameter("recipeName")));

                    if ((boolean) request.getAttribute("update")) {
                        request.setAttribute("msg", "Recipe was updated");
                    } else {
                        request.setAttribute("msg", "Recipe was not updated");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "rdel":
                    request.setAttribute("isDeleted", productService.delRecipe(request.getParameter("recipeName")));

                    if ((boolean) request.getAttribute("isDeleted")) {
                        request.setAttribute("msg", "Recipe was deleted");
                    } else {
                        request.setAttribute("msg", "Recipe was not deleted");
                    }

                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "iview":
                    request.setAttribute("ingredient", productService.getIngredient(request.getParameter("ingredientID")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "iadd":
                    request.setAttribute("iIsAdded", productService.addIngredient(request.getParameter("ingredientName"), request.getParameter("ingredientNutrient")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "iedit":
                    request.setAttribute("iUpdated", productService.addIngredient(request.getParameter("ingredientName"), request.getParameter("ingredientNutrient")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
                    break;
                case "idel":
                    request.setAttribute("iDelete", productService.delIngredient(request.getParameter("ingredientID")));
                    view = request.getRequestDispatcher("TestingPage.jsp");
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