package za.co.bakery.controllers;

import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.User;
import za.co.bakery.manager.DBPoolManagerBasic;

public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message = "";
        String prs = request.getParameter("pro");
        RequestDispatcher view=null;
        if (prs != null) {
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            if (prs.equals("login")) {
//                String email = request.getParameter("email");
//                String password = request.getParameter("password");
//                boolean userValidation = userService.isUserValid(email, password);
//                HttpSession session = request.getSession();
//                if (userValidation) {
//                    message = "Valid User";
//                } else {
//                    message = "Invalid User";
//                }
//                session.setAttribute("Valid", message);
//                view = request.getRequestDispatcher("davelogin.jsp");
//                view.forward(request, response);
//            }
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
//                if(valid){
//                    request.setAttribute("valid", valid);
//                }else
//                {
//                    request.setAttribute("invalid", valid);
//                }
//       if (prs.equals("register")) {
//                UserDOA userReg = new UserServiceImpl();
//                //userReg.registerUser(prs, prs, prs, prs, prs);
//                String title = request.getParameter("title");
//                String lname = request.getParameter("lastName");
//                String fname = request.getParameter("firstName");
//                String email = request.getParameter("email");
//                String password = request.getParameter("password");
//                userReg.registerUser(title, lname, fname, email, password);
//            }
