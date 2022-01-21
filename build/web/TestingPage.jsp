<%-- 
    Document   : TestingPage
    Created on : 18 Jan 2022, 12:58:38 PM
    Author     : Student03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    boolean y = (boolean)request.getAttribute("isDeleted");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>David and My test Page</title>
    </head>
    <body>
        <h1>Testing Page!!!!</h1>
        <%= y %>
        
    </body>
</html>
