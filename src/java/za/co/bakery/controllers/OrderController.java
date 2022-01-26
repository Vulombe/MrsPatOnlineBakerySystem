/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.bakery.manager.DBPoolManagerBasic;
import za.co.bakery.service.OrderService;
import za.co.bakery.service.OrderServiceImpl;
import za.co.bakery.service.UserService;
import za.co.bakery.service.UserServiceImpl;

/**
 *
 * @author student12
 */

public class OrderController extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ServletContext sc = request.getServletContext();
            DBPoolManagerBasic dbpm = (DBPoolManagerBasic) sc.getAttribute("dbconn");
            OrderService orderService = new OrderServiceImpl(dbpm);
            
            String prs = request.getParameter("pro");
            
            if(prs!=null)
                prs = prs.toLowerCase();
                switch (prs)
                {
                    
                    case "icreate":
                        
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
