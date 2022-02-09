package za.co.bakery.controllers;

import za.co.bakery.service.UserService;
import za.co.bakery.service.UserAddressService;
import za.co.bakery.service.UserServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.UserAddressServiceImpl;

public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String prs = request.getParameter("pro");
        RequestDispatcher view = null;

        if (prs != null) {
            prs = prs.toLowerCase();
            ServletContext sc = request.getServletContext();
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            UserService userService = new UserServiceImpl(dbpm);
            UserAddressService userAddressService = new UserAddressServiceImpl(dbpm);
            HttpSession session = request.getSession();
            //---------------------
            if (prs.equals("login")) {
                String email = request.getParameter("loginEmail");
                String password = request.getParameter("loginPassword");
                boolean userValidation = userService.isUserValid(email, password);
                if (userValidation) {
                    User user = userService.read(new User(email, password));
                    session.setAttribute("user", user);
                    view = request.getRequestDispatcher("index.jsp");
                } else {
                    request.setAttribute("errormsg", "Invalid email or password try again");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
            }
            //---------------------
            if (prs.equals("register")) {

                User user = userService.create(
                        request.getParameter("title"),
                        request.getParameter("firstName"),
                        request.getParameter("lastName"),
                        request.getParameter("loginEmail"),
                        request.getParameter("contactNumber"),
                        request.getParameter("loginPassword"),
                        request.getParameter("confPassword"));
                if (user == null) {
                    request.setAttribute("errormsg", "Invalid information");
                    view = request.getRequestDispatcher("error.jsp");
                }
                session.setAttribute("user", user);
                view = request.getRequestDispatcher("index.jsp");

                view.forward(request, response);
            }//git addedd

            //---------------------
            if (prs.equals("update")) {
                boolean updated = userService.read(
                        request.getParameter("title"),
                        request.getParameter("firstName"),
                        request.getParameter("lastName"),
                        request.getParameter("loginEmail"),
                        request.getParameter("contactNumber"),
                        request.getParameter("loginPassword"));
                if (updated) {
                    view = request.getRequestDispatcher("TestingPage.jsp");
                } else {
                    request.setAttribute("errormsg", "Unable to update user. Try again!");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
            }

            //---------------------
            if (prs.equals("delete")) {
                if (userService.delete(request.getParameter("loginEmail"))) {
                    request.setAttribute("msg", "User Was Deleted");
                    view = request.getRequestDispatcher("TestingPage.jsp");
                } else {
                    request.setAttribute("errormsg", "Unable to delete user");
                    view = request.getRequestDispatcher("error.jsp");
                }
                view.forward(request, response);
            }

            //---------------------
            if (prs.equals("viewusers")) {

            }
            //---------------------
            if (prs.equals("logout")) {
                session.removeAttribute("user");
                view = request.getRequestDispatcher("TestingPage.jsp");
                view.forward(request, response);
            }
            //---------------------

            if (prs.equals("aadd")) {

                User user = (User) request.getSession().getAttribute("user");

                if (userAddressService.checkAddress(user)) {
                    UserAddress userAddress = userAddressService.readUserAddress(user);

                    boolean readAddress = userAddressService.readtoUpdate(
                            Integer.parseInt(request.getParameter("houseNumber")),
                            request.getParameter("streetAddress"),
                            request.getParameter("city"),
                            request.getParameter("state"),
                            request.getParameter("zipCode"),
                            user);
                    request.setAttribute("userAddress", userAddress);
                    request.setAttribute("user", user);
                    view = request.getRequestDispatcher("payment.jsp");

                } else {
                    boolean userAddress = userAddressService.add(
                            Integer.parseInt(request.getParameter("houseNumber")),
                            request.getParameter("streetAddress"),
                            request.getParameter("city"),
                            request.getParameter("state"),
                            request.getParameter("zipCode"),
                            user);
                    request.setAttribute("useraddressvalid", userAddress);
                    request.setAttribute("userAddress", userAddressService.readUserAddress(user));
                    view = request.getRequestDispatcher("payment.jsp");
                }

                view.forward(request, response);
            }
            //---------------------
            if (prs.equals("radd")) {
                boolean readAddress = false;
                User user = (User) request.getSession().getAttribute("user");

                if (user != null) {
                    if (userAddressService.checkAddress(user) && request.getParameter("editC") == null) {

                        UserAddress ua = userAddressService.readUserAddress(user);

                        request.setAttribute("readAddress", ua);
                        request.setAttribute("user", user);
                        view = request.getRequestDispatcher("currentAddress.jsp");
                    } else if (userAddressService.checkAddress(user) == false) {
                        request.setAttribute("user", user);
                        view = request.getRequestDispatcher("addressAdd.jsp");
                    } else if (userAddressService.checkAddress(user) && request.getParameter("editC").equals("edit")) {
                        request.setAttribute("user", user);
                        view = request.getRequestDispatcher("addressAdd.jsp");

                    }

                }
                view.forward(request, response);
            }

            if (prs.equals("gopayment")) {
                 User user = (User) request.getSession().getAttribute("user");
                   UserAddress ua = userAddressService.readUserAddress(user);

                  request.setAttribute("readAddress", ua);
                        request.setAttribute("user", user);
                view = request.getRequestDispatcher("payment.jsp");
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
