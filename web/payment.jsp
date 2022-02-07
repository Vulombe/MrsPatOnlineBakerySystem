<%-- 
    Document   : payment
    Created on : 07 Feb 2022, 10:04:17 AM
    Author     : Studio13
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>payment</title>
</head>
<body>
    <div id="wrapper">
        <div id="container">
      
          <div id="info">
            
             
              <br>
      
            <p>To: </p>
            <p>Order: </p>
      
            <div id="price">
      
              <h2>R 2 700</h2>
      
            </div>
          </div>
      
          <div id="payment">
      
            <form id="checkout">
      
              <input class="card" id="visa" type="button" name="card" value="">
              <input class="card" id="mastercard" type="button" name="card" value="">
      
              <label>Credit Card Number</label>
              <input id="cardnumber" type=text pattern="[0-9]{13,16}" name="cardnumber" requierd="true" placeholder="0123-4567-8901-2345">
      
              <label>Card Holder</label>
             <input id="cardholder" type="text" name="name" requierd="true" maxlength="50" placeholder="Cardholder">
      
              <label>Expiration Date</label>
              <label id="cvc-label">CVC/CVV</label>
              <div id="left">
                  <select name="month" id="month" onchange="" size="1">
                    <option value="00">MM</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                  </select>
              <p>/</p>
                  <select name="year" id="year" onchange="" size="1">
                    <option value="00">YY</option>
                    <option value="01">16</option>
                    <option value="02">17</option>
                    <option value="03">18</option>
                    <option value="04">19</option>
                    <option value="05">20</option>
                    <option value="06">21</option>
                    <option value="07">22</option>
                    <option value="08">23</option>
                    <option value="09">24</option>
                    <option value="10">25</option>
                  </select>
              </div>
      
      
              <input id="cvc" type="text" placeholder="Cvc/Cvv" maxlength="3" />
      
              <input class="btn" type="button" name="purchase" value="Purchase">
            </form>
             <input class="btn1" type="button" name="Back" value="Back">
          </div>
      
        </div>
      </div>
</body>
<style>
* {
	 margin: 0;
	 padding: 0;
	 box-sizing: border-box;
	 -webkit-transition: 0.2s ease-in-out;
	 -moz-transition: 0.2s ease-in-out;
	 -o-transition: 0.2s ease-in-out;
	 transition: 0.2s ease-in-out;
	 font-family: "proxima-nova", sans-serif;
	 font-weight: 400;
	 -webkit-font-smoothing: antialiased;
	 -moz-osx-font-smoothing: grayscale;
	 color: #6c7a89;
}
 *:focus {
	 outline: none;
}
 body {
	/* background-color: #e2fbf5;*/
        background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
}
 #wrapper {
	 position: absolute;
	 top: 50%;
	 margin-top: -240px;
	 left: 0;
	 width: 100%;
}
 #container {
	 width: 720px;
	 height: 480px;
	 margin: 0 auto;
	 box-shadow: 1px 1px 10px 2px rgba(0, 0, 0, 0.2);
	 -webkit-border-radius: 5px;
	 -moz-border-radius: 5px;
	 -ms-border-radius: 5px;
	 border-radius: 5px;
	 overflow: hidden;
	 background: #b3bead;
	 background: -moz-linear-gradient(45deg, rgba(179, 190, 173, 1) 0%, rgba(223, 229, 215, 1) 60%, rgba(252, 255, 244, 1) 100%);
	 background: -webkit-linear-gradient(45deg, rgba(179, 190, 173, 1) 0%, rgba(223, 229, 215, 1) 60%, rgba(252, 255, 244, 1) 100%);
	 background: linear-gradient(45deg, rgba(179, 190, 173, 1) 0%, rgba(223, 229, 215, 1) 60%, rgba(252, 255, 244, 1) 100%);
}
 #info {
	 width: 52%;
	 height: 480px;
	 float: left;
	 background: -moz-linear-gradient(45deg, rgba(149, 165, 166, 1) 0%, rgba(208, 215, 216, 0) 56%, rgba(255, 255, 255, 0) 100%);
	 background: -webkit-linear-gradient(45deg, rgba(149, 165, 166, 1) 0%, rgba(208, 215, 216, 0) 56%, rgba(255, 255, 255, 0) 100%);
	 background: linear-gradient(45deg, rgba(149, 165, 166, 1) 0%, rgba(208, 215, 216, 0) 56%, rgba(255, 255, 255, 0) 100%);
}
 #info #product {
	 width: 500px;
	 margin: -50px 0 -85px -65px;
}
 #info p {
	 width: 100%;
	 text-align: center;
	 line-height: 1.5em;
	 letter-spacing: 1px;
}
 #info #price {
	 width: 50%;
	 margin: 0 auto;
	 letter-spacing: 1px;
}
 #info #price h2 {
	 width: 100%;
	 text-align: center;
	 font-weight: 700;
	 color: #000;
	 padding-top: 10px;
}
 #payment {
	 width: 40%;
	 float: right;
	 padding: 95px 50px 25px 0;
}
 #checkout {
	 width: 100%;
}
 #checkout input {
	 margin-bottom: 15px;
}
 #checkout label {
	 float: left;
	 text-transform: uppercase;
	 letter-spacing: 1.5px;
	 font-size: 0.6em;
	 padding: 0 0 5px 10px;
}
 #checkout #cvc-label {
	 margin-left: 25px;
}
 #checkout .card {
	 width: 29%;
	 margin: 0 10% 25px 10%;
	 border: none;
	 background: none;
	 height: 50px;
	 cursor: pointer;
	 -webkit-filter: grayscale(100%);
	 filter: grayscale(100%);
}
 #checkout .card:focus {
	 -webkit-filter: none;
	 filter: none;
}
 #checkout #visa {
	 background-image: url("http://enwaara.se/codepen/visa.png");
	 background-repeat: no-repeat;
	 background-position: center center;
	 background-size: cover;
}
 #checkout #mastercard {
	 background-image: url("http://enwaara.se/codepen/mastercard.png");
	 background-repeat: no-repeat;
	 background-position: center center;
	 background-size: 118%;
}
 #checkout #cardnumber, #checkout #cardholder, #checkout #cvc {
	 width: 100%;
	 background: none;
	 border: 1px solid #6c7a89;
	 padding: 8px 19px;
	 -webkit-border-radius: 50px;
	 -moz-border-radius: 50px;
	 -ms-border-radius: 50px;
	 border-radius: 50px;
	 letter-spacing: 1px;
}
 #checkout #cardnumber:focus, #checkout #cardholder:focus, #checkout #cvc:focus {
	 border: 1px solid #00b894;
}
 #checkout ::-webkit-input-placeholder {
	 letter-spacing: 3px;
	 text-transform: uppercase;
	 font-size: 0.9em;
	 color: #bdc3c7;
}
 #checkout #cardnumber {
	 letter-spacing: 3px;
}
 #checkout #cardnumber::-webkit-input-placeholder {
	 font-size: 1em;
}
 #checkout #left {
	 width: 41%;
	 border: 1px solid #6c7a89;
	 -webkit-border-radius: 50px;
	 -moz-border-radius: 50px;
	 -ms-border-radius: 50px;
	 border-radius: 50px;
	 overflow: hidden;
	 padding: 3px 5px;
	 float: left;
}
 #checkout #left #month, #checkout #left #year {
	 background: none;
	 border: none;
	 padding: 5px;
	 -webkit-border-radius: 5px;
	 -moz-border-radius: 5px;
	 -ms-border-radius: 5px;
	 border-radius: 5px;
	 float: left;
	 font-size: 0.8em;
	 letter-spacing: 3px;
	 color: #bdc3c7;
	 -webkit-appearance: none;
	 -moz-appearance: none;
	 appearance: none;
}
 #checkout #left #month option, #checkout #left #year option {
	 background: #ececec;
}
 #checkout #left p {
	 float: left;
	 padding-top: 2px;
	 font-size: 1.2em;
	 color: #bdc3c7;
	 letter-spacing: 3px;
}
 #checkout #cvc {
	 width: 48%;
	 float: left;
	 margin-left: 11%;
}
 #checkout .btn {
	 background: #00b894;
	 border: none;
	 width: 100%;
	 padding: 12px 10px 10px 10px;
	 -webkit-border-radius: 50px;
	 -moz-border-radius: 50px;
	 -ms-border-radius: 50px;
	 border-radius: 50px;
	 text-transform: uppercase;
	 letter-spacing: 2px;
	 font-weight: 400;
	 color: #ececec;
	 cursor: pointer;
}
 #checkout .btn:hover {
	 background: #16a085;
}
 
.btn1{
          background: #00b894;
	 border: none;
	 width: 100%;
	 padding: 12px 10px 10px 10px;
	 -webkit-border-radius: 50px;
	 -moz-border-radius: 50px;
	 -ms-border-radius: 50px;
	 border-radius: 50px;
	 text-transform: uppercase;
	 letter-spacing: 2px;
	 font-weight: 400;
	 color: #ececec;
	 cursor: pointer;
    
    
}
</style>
</html>