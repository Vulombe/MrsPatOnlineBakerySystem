<%-- 
    Document   : index
    Created on : Jan 14, 2022, 11:46:56 AM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="za.co.bakery.domain.User"%>

<!DOCTYPE html>
<html>

<head >
    
  
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width-device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="sie-edge" />
    <link href="https://unpkg.com/ionicons@4.2.2/dist/css/ionicons.min.css" rel="stylesheet">
   <!--<link rel="stylesheet" type="text/css" href="style.css">--> 
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
    <button class="btnback" id="back" onclick="history.back()">BACK</button>
 <!--<script src="main.js"></script>-->   
    <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
</body>


<style>

/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
/* 
    Created on : Jan 14, 2022, 11:47:43 AM
    Author     : student11
*/
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');
head{
    background-image: url("https://img.icons8.com/ios-filled/50/000000/circled-left.png");
    
}

* {
    box-sizing: border-box;
    
}

body {
    font-family: 'Montserrat', sans-serif;
    background: #f6f5f7;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: -20px 0 50px;
   background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);

    background-size: cover;
}

h1 {
    font-weight: bold;
    margin: 0;
    color: beige;
}

p {
    font-size: 14px;
    font-weight: bold;
    line-height: 20px;
    letter-spacing: 0.5px;
    margin: 20px 0 30px;
}

span {
    font-size: 12px;
    color: black;
}

a {
    color: #fff;
    font-size: 14px;
    text-decoration: none;
    margin: 15px 0;
}

.container {
    border-radius: 10px;
    box-shadow: 0 14px 28px rgba(173,216,230,1), 0 10px 10px rgba(173,216,230,1);
    position: absolute;
    overflow: hidden;
    width: 768px;
    max-width: 100%;
    min-height: 480px;
    opacity: 0.8;
    background-color:black;
}

.form-container form {
    background: rgba(45, 52, 54, 1.0);
    display: flex;
    flex-direction: column;
    padding: 0 50px;
    height: 100%;
    width: 100%;
    justify-content: center;
    align-items: center;
    text-align: center;
}

.social-container {
    margin: 20px 0;
}

.social-container a {
    border: 1px solid #ddd;
    border-radius: 50%;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    margin: 0 5px;
    height: 40px;
    width: 40px;
}


.form-container input {
    background: #eee;
    border: none;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}

button {
    border-radius: 20px;
    border: 1px solid #ff4b2b;
    background: #ff4b2b;
    color: #fff;
    font-size: 12px;
    font-weight: bold;
    padding: 12px 45px;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
}

input[type=text] {
    width: 240px;
    text-align: center;
    background: transparent;
    border: none;
    border-bottom: 1px solid #fff;
    font-family: 'PLay', sans-serif;
    font-size: 16px;
    font-weight: 200px;
    padding: 10px 0;
    transition: border 0.5s;
    outline: none;
    color: #fff;
    font-weight: bold;
}

input[type=password] {
    width: 240px;
    text-align: center;
    background: transparent;
    border: none;
    border-bottom: 1px solid #fff;
    font-family: 'PLay', sans-serif;
    font-size: 16px;
    font-weight: bold;
    padding: 10px 0;
    transition: border 0.5s;
    outline: none;
    color: #fff;
}

input[type=email] {
    width: 240px;
    text-align: center;
    background: transparent;
    border: none;
    border-bottom: 1px solid #fff;
    font-family: 'PLay', sans-serif;
    font-size: 16px;
    font-weight: 200px;
    padding: 10px 0;
    transition: border 0.5s;
    outline: none;
    color: #fff;
    font-weight: bold;
}

button:active {
    transform: scale(0.95);
}

button:focus {
    outline: none;
}

button.ghost {
    background: transparent;
    border-color: #ff4b2b;
    background-color: #ff4b2b
}

.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all 0.6s ease-in-out;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}

.sign-up-container {
    left: 0;
    width: 50%;
    z-index: 1;
    opacity: 0;
}

.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform 0.6s ease-in-out;
    z-index: 100;
}

.overlay {
    background: transparent;
    background: linear-gradient(to right, #ff4b2b, #ff416c) no repeat 0 0 /cover;
    color: #fff;
    position: absolute;
    left: -100%;
    height: 100%;
    width: 200%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.overlay-panel {
    position: absolute;
    top: 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 0 40px;
    height: 100%;
    width: 50%;
    text-align: center;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.overlay-right {
    right: 0;
    transform: translateX(0);
}

.overlay-left {
    transform: translateX(-20%);
}

/*....Animation....*/

/*....Move signin to the right....*/
.container.right-panel-active .sign-in-container {
    transform: translateX(100%);
}

/*....Move overlay to the left....*/
.container.right-panel-active .overlay-container {
    transform: translateX(-100%);
}

/*....Bring sign up over sign in....*/
.container.right-panel-active .sign-up-container {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
}

/*...Move overlay back to right....*/
.container.right-panel-active .overlay {
    transform: translateX(50%);
}

.container.right-panel-active .overlay-left {
    transform: translateX(0);
}

.container.right-panel-active .overlay-right {
    transform: translateX(20%);
}

/*//////////////////// slide show////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
* {
  box-sizing: border-box;
}

/* Position the image container (needed to position the left and right arrows) */
.container {
  position: relative;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

/* Add a pointer when hovering over the thumbnail images */
.cursor {
  cursor: pointer;
}

/* Next & previous buttons */
.prev,
.next {
  cursor: pointer;
  position: absolute;
  top: 40%;
  width: auto;
  padding: 16px;
  margin-top: -50px;
  color: white;
  font-weight: bold;
  font-size: 20px;
  border-radius: 0 3px 3px 0;
  user-select: none;
  -webkit-user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover,
.next:hover {
  background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* Container for image text */
.caption-container {
  text-align: center;
  background-color: #222;
  padding: 2px 16px;
  color: white;
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Six columns side by side */
.column {
  float: left;
  width: 16.66%;
}

/* Add a transparency effect for thumnbail images */
.demo {
  opacity: 0.6;
}

.active,
.demo:hover {
  opacity: 1;
}
/* nav bar/////////////////////////////////////////////////////////////////////////*/

ul {
    list-style-type: none;
    margin: 1px;
    padding: 1px;
    overflow: hidden;
   /* background-color: #8842d5;*/
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: left;
    padding: 15px 17px;
    text-decoration: none;
}

/* A color changes when hovered over */
li a:hover {
    background-color: #7300ff;
}
div b{
    height: 400px;
background-color: white;
font-family: white;


}
/*///////////////////catagories///////////////////////*/
h4{
    font-weight: bold;
    color:black;
    font-weight: bold;
    margin: 0;
    font-size: 16px;
    display: block;
    border-bottom: 3px solid #ccc;
    margin: 0 0 10px 0;
    padding: 0 0 5px 0;
}
h3{
    font-weight: bold;
  color:black;
    
    margin: 0; 
     display: inline-block;
    background-color: black;
    color: #fff;
    font-size: 20px;
    font-weight: normal;
    text-transform: uppercase;
    padding: 7px 0px;
    float: left;
}

   
    
   *  {
        
    margin: 0;
    padding: 0;
}
body1 {
    background-color: #F2EEE9;
    font: normal 13px/1.6 Georgia, Serif;
    color: #333;
}
.wrapper {
    width: 705px;
    margin: 10px auto;
   padding: 1px;
}

.clear {
    clear: both;
}
.items {
    display:block;
    margin: 40px 0;
    
}
.item {
    background-color: #fff;
    float: left;
    margin: 0 100px 10px 0;
    width: 90px;
    padding: 10px;
    height: 900px;
}
.item img {
    display: block;
    margin: auto;
    color: white;
    width: 50%;
    height: 20%;
}

button {
    border: 1px solid #722A1B;
    padding: 4px 14px;
    background-color: #fff;
    color: #722A1B;
    text-transform: uppercase;
    float: right;
    margin: 5px 0;
    font-weight: bold;
    cursor: pointer;
    align-items: center;
}


.cakesbtn{
    
 align-content: center;
}
span1 {
    float: right;
    color: white;
    font-size: 12px;
    color: beige;
}
.shopping-cart {
    display: inline-block;
    background: url('http://cdn1.iconfinder.com/data/icons/jigsoar-icons/24/_cart.png') no-repeat 0 0;
    width: 60px;
    height: 44px;
    margin: 0 10px 0 0;
}
.div1 {
height: 80%;
background-color: white;
font-family: white;
width: 90%;


}


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

}


</style>

<script>

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
	container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
	container.classList.add("right-panel-active");
});

fistForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());
///////////////// slide show
var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  var captionText = document.getElementById("caption");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}
//// back and forward button
function goBack() {
	window.history.back();
	console.log('We are in previous page');
}

</script>
</html>