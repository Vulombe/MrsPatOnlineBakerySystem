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

        String prs = request.getParameter("pro");
        RequestDispatcher view = null;
        if (prs != null) {
            ServletContext sc = request.getServletContext();
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            UserService userService = new UserServiceImpl(dbpm);
            HttpSession session = request.getSession();
            if (prs.equals("login")) {
                String email = request.getParameter("loginEmail");
                String password = request.getParameter("loginPassword");
                boolean userValidation = userService.isUserValid(email, password);

                if (userValidation) {

                    User user = new User(email, password);
                    user = userService.read(user);
                    if (user.getUserRole().equals("ADMIN")) {
                        session.setAttribute("role", user.getUserRole().ADMIN);
                    }
                    session.setAttribute("user", user);
                    view = request.getRequestDispatcher("index.jsp");
                } else {
                    String message = "Invalid email or password try again";
                    request.setAttribute("Error", message);
                    //view = request.getRequestDispatcher("Error.jsp");
                }

                view.forward(request, response);
            }
            if (prs.equals("register")) {

                String title = request.getParameter("title");
                String lname = request.getParameter("lastName");
                String fname = request.getParameter("firstName");
                String email = request.getParameter("loginEmail");

                if (email != null) {
                    email = email.toLowerCase();
                }
                String password = request.getParameter("loginPassword");
                String confirmPassword = request.getParameter("loginEmail");
                String contactNumber = request.getParameter("contactNumber");
                
                if (password.equals(confirmPassword)) {
                    User user = userService.create(title, fname, lname, email, contactNumber, password);
                    if (user == null) {
                        //Use was not created
                        view = request.getRequestDispatcher("Error.jsp");
                    } else {
                        session.setAttribute("user", user);
                        view = request.getRequestDispatcher("TestingPage.jsp");
                    }
                    view.forward(request, response);
                }

            }
            if (prs.equals("logout")) {
                session.removeAttribute("user");
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
            if(prs.equals("delete"))
            {
                String email = request.getParameter("loginEmail");
                User user = new User(email);
                boolean deleted = userService.delete(user.getEmailAddress());
                view = request.getRequestDispatcher("TestingPage.jsp");
                view.forward(request, response);
            }
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
    }

}
