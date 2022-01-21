<%-- 
    Document   : index
    Created on : Jan 14, 2022, 11:46:56 AM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head >
    <button id="back" onclick="goBack()">BACK</button>
    <button id="forward" onclick="goForward()">FORWARD</button>
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width-device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="sie-edge" />
    <link href="https://unpkg.com/ionicons@4.2.2/dist/css/ionicons.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Mrs Pat's bakery</title>
</head>

<body>

    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="#">
                <h1>Create Account</h1>
                <p style="color:white"> <label for="title" >Title: </label>
                <select name= "title" id="title">
                    <option value=””>Mr</option>
                    <option value=””>Mrs</option>
                    <option value=””>Ms</option>
                    <option value=””>Dr</option>
                    <option value=””>Prof</option>
                    </select></p> 
                <input type="text" name="firstName" placeholder="First Name"  required=""/>
                <input type="text" name="lastName" placeholder="Last Name"  required=""/>
                <input type="text"  name="signEmail" placeholder="Email"  required=""/>
                <input  type="text"  name="contactNumber" placeholder="Contact Number"  required=""/>
                <input type="password"  name="signPassword" placeholder="Password"  required=""/>
                <button>Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
           <form action="http://localhost:8080/MrsPatOnlineBakerySystem/userController" method="post">
                <h1> Login </h1>
        
                <!--                get session and check if there is a User. If there is then check if it is an admin. If it is, then enable
                admin features, else leave default features-->
                
<!--                if there is a user in the session, change the login button to logout button-->

                
                <input type="email" name="loginEmail" placeholder="Email">
                <input type="Password" name="loginPassword" placeholder="Password">
                <button type="submit">Login</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome</h1>
                    <p>To Mrs Pat's Bakery</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1></h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    <script src="main.js"></script>
    <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
</body>

</html>