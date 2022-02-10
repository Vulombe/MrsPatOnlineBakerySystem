<%-- 
    Document   : productDel
    Created on : Feb 9, 2022, 10:36:48 AM
    Author     : student11
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.co.bakery.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete product</title>
    </head>
    <body>
        <h1>Delete Product</h1>
        <form action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pdelete" >
            <input type="hidden" name="pro" value="pdelete">
            <select name="prodid" id="mySelect" "style=" height: 60px;">
                <% if (products != null) {
                        for (Product p : products) {
                %>
                <option value="<%=p.getProductID()%>"><%=p.getName()%></option>
                <% }};%>     
            </select>
            <input class="button" type="submit"value="submit" name="submit">
        </form>
    </body>
</html>
