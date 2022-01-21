<%-- 
    Document   : admin
    Created on : Jan 21, 2022, 8:50:52 AM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin login</title>
    </head>
    <body>
        <h1></h1>
    <center>
         <div class="form-container ">
         <form method="post" action="http://localhost/MrsPatOnlineBakerySystem/UserController>
                <input type="hidden" name="pro" value="login">
                <h1> Login </h1>
        
                <input type="email" name="loginEmail" placeholder="Email">
                <input type="Password" name="loginPassword" placeholder="Password">
                <button type="submit"> Login </button>
            </form>
         </div>
    </center>
    </body>
      <script src="main.js"></script>
</html>
