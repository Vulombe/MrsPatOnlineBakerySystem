<%-- 
    Document   : admin
    Created on : Jan 31, 2022, 12:26:26 PM
    Author     : student11
--%>

<%@page import="java.util.Scanner"%>
<%@page import="za.co.bakery.controllers.ProductController"%>
<%@page import="za.co.bakery.controllers.AdminController"%>
<%@page import="za.co.bakery.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



          
</head>
<body>

 <h class="a">Welcome Admin</h>
    <div>
        <center>
            <b class="a"> <font size="+4">Products</b></font>

            <br></br>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=padd"> 

                <button onclick="" value="padd"> Add product </button></a></a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=pdel">
                <button onclick="" value="pdel" > Delete product</button>
            </a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=pedt">
                <button onclick="" value="pedt">  Update product</button></a>

           <!-- <br></br>     

           <b class="a"> <font size="+4">Recipe</b></font>
            <br></br>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=radd">
              
                <button onclick="" value="radd">Add Recipe </button>
            </a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=rdel">
            <button onclick=""value="rdel"> Delete Recipe</button>
            </a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=redit">
                <button onclick="" value="redit">Update Recipe </button> </a>  -->
   <br></br> 

          <b class="a"> <font size="+4"> ingredient</b></font>
            <br>
<a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=iadd">
            <button onClick="" value="iadd"> Add ingredient</button></a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=idel">
                <button onclick="" value="idel">Delete ingredient</button></a>
            <a href="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=iedit">
                <button onclick="" value="iedit">Update ingredient</button></a>

            <br>
 <b class="a"> <font size="+4">Users</b></font>
            <br></br>
<a href="addUser.jsp">
    <button onclick="" value="register">Add User</button></a>
            <a href="deleteUser.jsp">
                <button onClick="" value="delete"> Delete User</button></a>
            <a href="updateuser.jsp">
                <button onclick="" value="viewusers">Update User</button> </a>         
    </div>
</center>
<br></br>
<br></br>
        <center> <button class="btnback" id="back" onclick="goBack()">BACK</button></center>
       
 <script src="main.js"></script>
 <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
</body>

<style>
    body{
        background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
    }

    button{

        border-radius: 20px;
        border: 1px solid #ff4b2b;
        background: grey;
        color: #fff;
        font-size: 12px;
        font-weight: bold;
        padding: 20px 60px;
        letter-spacing: 1px;
        text-transform: uppercase;
        transition: transform 80ms ease-in;

        div{
            background-color: grey;
            margin-right:5%;

        }
        label {

        }
    }
    .a {
        color: #fff;
       
        text-decoration: none;
        margin: 15px 0;
   
    button.btnback{
     border: 1px solid #722A1B;
    padding: 4px 14px;
    background-color: #fff;
    color: #722A1B;
    text-transform: uppercase;
    float: right;
    margin:54px 0;
    font-weight: bold;
    cursor: pointer;

}}


</style>
</html>     


         

           



























