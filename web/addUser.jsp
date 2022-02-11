<%-- 
    Document   : addUser
    Created on : Feb 10, 2022, 1:21:10 PM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
        <h1 class="a">Create Account!</h1>
      
        <div class="box">
            <form method="post"   action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=register">
                <input type="hidden" name="pro" value="register">
                <h1 class="a">Create Account</h1>
                <br>
                <p style="color:white"> <label form="title" >Title: </label>
                <select name= "title" id="title">
                    <option value="Mr">Mr</option>
                    <option value="Mrs">Mrs</option>
                    <option value="Ms">Ms</option>
                    <option value="Dr">Dr</option>
                    <option value="Prof">Prof</option>
                    </select>  </p> 
                    <br>
              
                <input type="text" name="firstName" placeholder="First Name"  required=""/>
                <br>
                <br>
                <input type="text" name="lastName" placeholder="Last Name"  required=""/>
                <br>
                <br>
                <input type="text"  name="loginEmail" placeholder="Email"  required=""/>
                <br>
                <br>
                <input  type="text"  name="contactNumber" placeholder="Contact Number"  required=""/>
                <br>
                <br>
                <input type="password"  name="loginPassword" placeholder="Password"  required=""/>
                <br>
                <br>
                <input type="Confirm password"  name="confPassword" placeholder="confirm password"  required=""/>
                <br>
                <br>
                <button type="submit" class="btnCreate"> Sign Up </button>
            </form>
        </div>
        <br>
    <center>
              <button class="btnback" id="back" onclick="goBack()">BACK</button>
    </center>
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

