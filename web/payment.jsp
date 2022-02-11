<%-- 
    Document   : payment
    Created on : 07 Feb 2022, 10:04:17 AM
    Author     : Studio13
--%>

<%@page import="za.co.bakery.domain.User"%>
<%@page import="za.co.bakery.domain.LineItemCollection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Payment</title>
    </head>

    <body>

        <!--Radio button to switch between choose and add sales representative (choose default)-->
        <header>

            <nav class="nav bd-grid">
                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item"> Card <input type="radio" onclick="repVisible();" id="chooseInput" name="repRadio"></li>
                        <br><br>
                        <li class="nav__item">EFT <input type="radio" onclick="repVisible();" id="addInput" name="repRadio"></li>
                    </ul>
                </div>


            </nav>

        </header>

        <%LineItemCollection lineItemCol = (LineItemCollection) request.getSession().getAttribute("cart");
            User u = (User) request.getSession().getAttribute("user");
        %>

        <div id="wrapper">
            <div class="form-group" id="repIfChoose" style="display:none">
                <div id="container">

                    <div id="info">


                        <br>

                        <p>To: <%=u.getEmailAddress()%> </p>
                        <br>
                        <p>Total: R <%=lineItemCol.total()%> </p>
                        <br>
                        <p>Tax: <%=lineItemCol.tax() + "%"%> </p>
                        <br>
                        <p>Shipping: R <%=lineItemCol.shipping()%> </p>

                        <br>

                        <div id="price">

                            <h2>R <%=lineItemCol.grandTotal()%></h2>

                        </div>

                    
                    </div>

                    <div id="payment">
                        <form method="POST" action="http://localhost:8080/MrsPatOnlineBakerySystem/pacontrol?pro=payment&paymentType=CARD" id="checkout">

                            <input class="card" id="visa" type="button" name="card" value="">
                            <input class="card" id="mastercard" type="button" name="card" value="">

                            <label>Credit Card Number</label>
                            <input id="cardnumber" type=text pattern="[0-9]{13,16}" name="cardnumber" required="true"
                                   placeholder="0123-4567-8901-2345">

                            <label>Card Holder</label>
                            <input id="cardholder" type="text" name="name" required="true" maxlength="50"
                                   placeholder="Cardholder">

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


                            <input name="cvvNumber" id="cvc" type="text" placeholder="Cvc/Cvv" maxlength="3" />
                            <input class="btn" type="submit" name="purchase" value="Purchase">
                        </form>
                        <button onclick="history.back()" class="btn1" >Back</button>
                    </div>

                </div>
            </div>

            <div class="form-group" id="repIfAdd" style="display:none">
                <div id="container">

                    <div id="info">


                        <br>

                        <p>To: <%=u.getEmailAddress()%> </p>
                        <br>
                        <p>Total: R <%=lineItemCol.total()%> </p>
                        <br>
                        <p>Tax: <%=lineItemCol.tax() + "%"%> </p>
                        <br>
                        <p>Shipping: R <%=lineItemCol.shipping()%> </p>

                        <br>

                        <div id="price">

                            <h2>R <%=lineItemCol.grandTotal()%></h2>

                        </div>
                    </div>

                    <div id="payment">

                        <form method="POST" action="http://localhost:8080/MrsPatOnlineBakerySystem/pacontrol?pro=payment&paymentType=EFT" id="checkout">

                            <input class="card" id="visa" type="button" name="card" value="">
                            <input class="card" id="mastercard" type="button" name="card" value="">


                            <label>Bank</label>
                            <!--<input id="cardnumber" type=text name="cardnumber" required="true">-->

                            <div id="left">
                                <select name="Banks" id="Banks">
                                    <option value="Capitec">Capitec</option>
                                    <option value="FNB">FNB</option>
                                    <option value="Nedbank">Nedbank</option>
                                    <option value="TymeBank">TymeBank</option>
                                </select>

                            </div>
                            <label>Account Number</label>
                            <input id="cardholder" type="text" name="name" required="true" maxlength="50"
                                   placeholder="Account Number">

                            <label>Pin Number</label>
                            <input id="cardholder" type="password" name="name" required="true" maxlength="4"
                                   placeholder="pin Number">

                            <input class="btn" type="submit" name="purchase" value="Purchase">
                        </form>
                        <input class="btn1" type="button" name="Back" value="Back">
                    </div>

                </div>
            </div>
        </div>

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

            #checkout #cardnumber,
            #checkout #cardholder,
            #checkout #cvc {
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

            #checkout #cardnumber:focus,
            #checkout #cardholder:focus,
            #checkout #cvc:focus {
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

            #checkout #left #month,
            #checkout #left #year {
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

            #checkout #left #month option,
            #checkout #left #year option {
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

            .btn1 {
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

        <style>

            /*===== GOOGLE FONTS =====*/

            /*===== VARIABLES CSS =====*/
            :root {
                --header-height: 3rem;
                --font-semi: 600;
            }

            /*===== Colores =====*/
            :root {
                --first-color: #4070F4;
                --second-color: #0E2431;
            }

            /*===== Fuente y tipografia =====*/
            :root {
                --body-font: 'Poppins', sans-serif;
                --big-font-size: 2rem;
                --h2-font-size: 1.25rem;
                --normal-font-size: 0.938rem;
            }

            @media screen and (min-width: 768px) {
                :root {
                    --big-font-size: 3.5rem;
                    --h2-font-size: 2rem;
                    --normal-font-size: 1rem;
                }
            }

            /*===== Margenes =====*/
            :root {
                --mb-1: 0.5rem;
                --mb-2: 1rem;
                --mb-3: 1.5rem;
                --mb-4: 2rem;
                --mb-5: 2.5rem;
                --mb-6: 3rem;
            }

            /*===== z index =====*/
            :root {
                --z-back: -10;
                --z-normal: 1;
                --z-tooltip: 10;
                --z-fixed: 100;
            }

            /*===== BASE =====*/
            *, ::before, ::after {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
            }

            html {
                scroll-behavior: smooth;
            }

            body {
                background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
                margin: var(--header-height) 0 0 0;
                font-family: var(--body-font);
                font-size: var(--normal-font-size);
                color: var(--second-color);
            }

            h1, h2, p {
                margin: 0;
            }

            ul {
                margin: 0;
                padding: 0;
                list-style: none;
                alignment-adjust:  center;
            }

            a {
                text-decoration: none;
            }

            img {
                max-width: 100%;
                height: auto;
                display: block;
            }

            /*===== CLASS CSS ===== */
            .section-title {
                position: relative;
                font-size: var(--h2-font-size);
                color: var(--first-color);
                margin-top: var(--mb-2);
                margin-bottom: var(--mb-4);
                text-align: center;
            }

            .section-title::after {
                position: absolute;
                content: "";
                width: 64px;
                height: 0.18rem;
                left: 0;
                right: 0;
                margin: auto;
                top: 2rem;
                background-color: var(--first-color);
            }

            .section {
                padding-top: 3rem;
                padding-bottom: 2rem;
            }

            /*===== LAYOUT =====*/
            .bd-grid {
                max-width: 90%;
                display: -ms-grid;
                display: grid;
                -ms-grid-columns: 100%;
                grid-template-columns: 100%;
                grid-column-gap: 2rem;
                width: calc(100% - 2rem);
                margin-left: var(--mb-2);
                margin-right: var(--mb-2);
            }

            .l-header {
                width: 100%;
                position: fixed;
                top: 0;
                left: 0;
                z-index: var(--z-fixed);
                background-color: #fff;
                -webkit-box-shadow: 0 1px 4px rgba(146, 161, 176, 0.15);
                box-shadow: 0 1px 4px rgba(146, 161, 176, 0.15);
            }

            /*===== NAV =====*/
            .nav {


                height: var(--header-height);
                width:100%;
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-pack: justify;
                -ms-flex-pack: justify;
                justify-content: space-between;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center;
                font-weight: var(--font-semi);
                background-color: white;


            }

            @media screen and (max-width: 768px) {
                .nav__menu {
                    position: fixed;
                    top: var(--header-height);
                    right: -100%;
                    width: 80%;
                    height: 100%;
                    padding: 2rem;
                    background-color: var(--second-color);
                    -webkit-transition: .5s;
                    transition: .5s;
                    alignment-adjust:  right;

                }
            }

            .nav__item {
                margin-bottom: var(--mb-4);
            }

            .nav__link {
                position: relative;
                color: #fff;
            }

            .nav__link:hover {
                position: relative;
            }

            .nav__link:hover::after {
                position: absolute;
                content: "";
                width: 100%;
                height: 0.18rem;
                left: 0;
                top: 2rem;
                background-color: var(--first-color);
            }

            .nav__logo {
                color: var(--second-color);
                alignment-adjust:  left;

            }

            .nav__toggle {
                color: var(--second-color);
                font-size: 1.5rem;
                cursor: pointer;
            }

            /*Active menu*/
            .active::after {
                position: absolute;
                content: "";
                width: 100%;
                height: 0.18rem;
                left: 0;
                top: 2rem;
                background-color: var(--first-color);
            }

            /*=== Show menu ===*/
            .show {
                right: 0;
            }

            /*===== HOME =====*/
            .home {
                height: calc(100vh - 3rem);
                row-gap: 1rem;
            }

            .home__data {
                -ms-flex-item-align: center;
                -ms-grid-row-align: center;
                align-self: center;
            }

            .home__title {
                font-size: var(--big-font-size);
                margin-bottom: var(--mb-5);
            }

            .home__title-color {
                color: var(--first-color);
            }

            .home__social {
                display: -webkit-box;
                display: -ms-flexbox;
                display: flex;
                -webkit-box-orient: vertical;
                -webkit-box-direction: normal;
                -ms-flex-direction: column;
                flex-direction: column;
            }

            .home__social-icon {
                width: -webkit-max-content;
                width: -moz-max-content;
                width: max-content;
                margin-bottom: var(--mb-2);
                font-size: 1.5rem;
                color: var(--second-color);
            }

            .home__social-icon:hover {
                color: var(--first-color);
            }

            .home__img {
                position: absolute;
                right: 0;
                bottom: 0;
                width: 295px;
            }

            /*BUTTONS*/
            .button {
                display: inline-block;
                background-color: var(--first-color);
                color: #fff;
                padding: .75rem 2.5rem;
                font-weight: var(--font-semi);
                border-radius: .5rem;
            }

            .button:hover {
                -webkit-box-shadow: 0 10px 36px rgba(0, 0, 0, 0.15);
                box-shadow: 0 10px 36px rgba(0, 0, 0, 0.15);
            }





            .wrapper {
                display: -ms-grid;
                display: grid;
                -ms-grid-columns: 50% 30%;
                grid-template-columns: 50% 30%;
                list-style-type: square;
                /*
                 
                  
                  grid-column-gap:1em;
                  grid-row-gap:1em;
                  
                  grid-gap:0;*/
            }

            /* ===== CONTACT =====*/
            .contact__input {
                width: 100%;
                font-size: var(--normal-font-size);
                font-weight: var(--font-semi);
                padding: 1rem;
                border-radius: .5rem;
                border: 1.5px solid var(--second-color);
                outline: none;
                margin-bottom: var(--mb-4);
            }

            .contact__button {
                display: block;
                border: none;
                outline: none;
                font-size: var(--normal-font-size);
                cursor: pointer;
                margin-left: auto;
            }

            /* ===== FOOTER =====*/
            .footer {
                background-color: var(--second-color);
                color: #fff;
                text-align: center;
                font-weight: var(--font-semi);
                padding: 2rem 0;
            }

            .footer__title {
                font-size: 2rem;
                margin-bottom: var(--mb-4);
            }

            .footer__social {
                margin-bottom: var(--mb-4);
            }

            .footer__icon {
                font-size: 1.5rem;
                color: #fff;
                margin: 0 var(--mb-2);
            }

            /* ===== MEDIA QUERIES=====*/
            @media screen and (min-width: 768px) {
                body {
                    margin: 0;
                }
                .section {
                    padding-top: 4rem;
                    padding-bottom: 3rem;
                }
                .section-title {
                    margin-bottom: var(--mb-6);
                }
                .section-title::after {
                    width: 80px;
                    top: 3rem;
                }
                .nav {
                    height: calc(var(--header-height) + 1rem);
                }
                .nav__list {
                    display: -webkit-box;
                    display: -ms-flexbox;
                    display: flex;
                    padding-top: 0;
                }
                .nav__item {
                    margin-left: var(--mb-6);
                    margin-bottom: 0;
                }
                .nav__toggle {
                    display: none;
                }
                .nav__link {
                    color: var(--second-color);
                }
                .home {
                    height: 100vh;
                }
                .home__data {
                    -ms-flex-item-align: end;
                    align-self: flex-end;
                }
                .home__social {
                    padding-top: 0;
                    padding-bottom: 2.5rem;
                    -webkit-box-orient: horizontal;
                    -webkit-box-direction: normal;
                    -ms-flex-direction: row;
                    flex-direction: row;
                    -ms-flex-item-align: end;
                    align-self: flex-end;
                }
                .home__social-icon {
                    margin-bottom: 0;
                    margin-right: var(--mb-4);
                }
                .home__img {
                    width: 457px;
                    bottom: 15%;
                }
                .about__container, .skills__container {
                    grid-template-columns: repeat(2, 1fr);
                    -webkit-box-align: center;
                    -ms-flex-align: center;
                    align-items: center;
                    text-align: initial;
                }
                .about__img img {
                    width: 300px;
                }
                .work__container {
                    grid-template-columns: repeat(3, 1fr);
                    grid-template-rows: repeat(2, 1fr);
                    -webkit-column-gap: 2rem;
                    column-gap: 2rem;
                }
            }

            @media screen and (min-width: 1024px) {
                .bd-grid {
                    margin-left: auto;
                    margin-right: auto;
                }
                .home__img {
                    right: 10%;
                }
            }

        </style>

        <script>
            function repVisible() {
                if (document.getElementById('chooseInput').checked) {
                    document.getElementById('repIfChoose').style.display = 'block';
                    document.getElementById('repIfAdd').style.display = 'none';
                }
                if (document.getElementById('addInput').checked) {
                    document.getElementById('repIfChoose').style.display = 'none';
                    document.getElementById('repIfAdd').style.display = 'block';
                }
            }

        </script>

</html>