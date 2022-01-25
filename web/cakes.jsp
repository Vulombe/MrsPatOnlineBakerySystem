<%-- 
    Document   : catagories
    Created on : Jan 18, 2022, 11:11:54 AM
    Author     : student11
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.co.bakery.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("prodList");%>

        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= request.getAttribute("theTitle")%></title>
    </head>

    <body id="body1">

        <link rel="stylesheet" type="text/css" href="style.css">
        <div class="div1">
            
            <h3><%= request.getAttribute("theTitle")%></h3><br>

            <%
                if (products != null) {%>
               
            <%
                for (Product product : products) {

            %> <div class="items">
            <br> 
            <img src=<%=product.getPicture()%> width="60px" height="60px"><br>
            Product Name: <%=product.getName()%>&nbsp;&nbsp;&nbsp; <br>Price: <%=product.getPrice()%>

            <%
                    }   %>
                               </div>
            <%
                }%>
         
      
            <br>
            <h4>Enjoy our CAKE</h4>
   
    </div>



</body>
<button  class="cakesbtn" id="back" onclick="goBack()">BACK</button>
<script src="cart.js"></script>
</html>
