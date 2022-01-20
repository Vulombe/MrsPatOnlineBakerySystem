<%-- 
    Document   : TestingPage
    Created on : 18 Jan 2022, 12:58:38 PM
    Author     : Student03
--%>

<%@page import="za.co.bakery.domain.Role"%>
<%@page import="za.co.bakery.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>David and My test Page</title>
    </head>
    <body>
        <h1>Testing Page!!!!</h1>
        <% User user = (User)session.getAttribute("user");%>
        <H1>The user name is: <%=user.getLastName()%> </H1>
        <% if(user.getUserRole().equals(Role.CLIENT)){%>
          <H1>The user is a Client</H1>
          <%}else{%>
        <H1>The user is ADMIN</H1>
        <%}%>    
    </body>
</html>
