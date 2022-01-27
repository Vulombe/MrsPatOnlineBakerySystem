<%-- 
    Document   : index
    Created on : Jan 14, 2022, 11:46:56 AM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head >
    
  
    
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
            <form method="post"   action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol">
                <input type="hidden" name="pro" value="register">
                <h1>Create Account</h1>
                <p style="color:white"> <label form="title" >Title: </label>
                <select name= "title" id="title">
                    <option value="Mr">Mr</option>
                    <option value="Mrs">Mrs</option>
                    <option value="Ms">Ms</option>
                    <option value="Dr">Dr</option>
                    <option value="Prof">Prof</option>
                    </select></p> 
                <input type="text" name="firstName" placeholder="First Name"  required=""/>
                <input type="text" name="lastName" placeholder="Last Name"  required=""/>
                <input type="text"  name="loginEmail" placeholder="Email"  required=""/>
                <input  type="text"  name="contactNumber" placeholder="Contact Number"  required=""/>
                <input type="password"  name="loginPassword" placeholder="Password"  required=""/>
                <input type="Confirm password"  name="confPassword" placeholder="confirm password"  required=""/>
                <button type="submit" class="btnCreate"> Sign Up </button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form class="form" method="get" action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol">
                <input type="hidden" name="pro" value="login">
                <h1> Login </h1>
        
                <input type="text" name="loginEmail" placeholder="Email" required>
                <input type="password" name="loginPassword" placeholder="Password" required>
                <button type="submit" class="btnLogin"> Login </button>
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
    <button class="btnback" id="back" onclick="goBack()">BACK</button>
    <script src="main.js"></script>
    <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
</body>

</html>