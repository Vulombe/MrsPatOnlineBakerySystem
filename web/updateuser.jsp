<%-- 
    Document   : updateuser
    Created on : Feb 10, 2022, 1:23:08 PM
    Author     : student11
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.co.bakery.domain.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="box">
            <form method="GET" action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=viewusers"> 
                <input type="hidden" name="pro" value="viewusers">

                <select name= "userList" id="userList">
                    <% List<User> u = (ArrayList<User>) request.getAttribute("userList");
                if ( u!= null) {
                    for (User us : u) {%>
                    <option value="<%=us.getID()%>"><%=us.getEmailAddress()%></option> 
                    <% }}%>
                    
                    
                </select>
               <button>Submit</button>
            </form>
        </div>

    </body>
</html>
<style>




    body{
        background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
        color: #212121;
        margin: 0;
        padding: 0;
    }
    div{
        align:center;
    }
    .a{

        color: #fff;

        text-decoration: none;
        margin: 15px 0;
    }
    * {
        box-sizing: border-box;
    }



    .box {
        background-color: black;
        border: 15px solid transparent;
        border-image: linear-gradient(135deg, #CDDC39, #1976D2) 1;
        border-radius: 100px;
        height: 700px;
        margin: 0 auto;
        padding: 10px;
        width: 700px;
    }
    .popup {
        position: relative;
        display: inline-block;
        cursor: pointer;
    }
</style>

