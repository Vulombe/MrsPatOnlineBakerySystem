package za.co.bakery.controllers;

import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.User;

public class UserController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prs = request.getParameter("pro");
        if (prs != null) {
            String email = request.getParameter("title");
            String password = request.getParameter("lastName");
            if (prs.equals("login")) {
                boolean userValidation = userService.isUserValid(email, password);
                if(userValidation)
                {
                    
                }    
                RequestDispatcher view = request.getRequestDispatcher("loginAnswer.jsp");
                view.forward(request, response);
            }
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