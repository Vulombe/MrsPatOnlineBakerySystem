<%-- 
    Document   : cureentAddress
    Created on : 09 Feb 2022, 9:06:02 AM
    Author     : Studio13
--%>

<%@page import="za.co.bakery.domain.UserAddress"%>
<%@page import="za.co.bakery.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Address</title>
    </head>

    <body>
        <% User u = (User) request.getAttribute("user");
            UserAddress ua = (UserAddress) request.getAttribute("readAddress");

        %>
        <div class="container">

            <div class="div2">
                <div class="logo">
                    <img src="" alt="">
                </div>
                <form action="">
                    <h1>Shipping</h1>
                    <p>Current Address</p>
                    <hr />
                    <div class="form">

                        <div class="fields fields--2">
                            <label class="field">
                                <span class="field__label" for="firstname">First name</span>
                                <p class="field__input" type="text" id="firstname" ><%=u.getFirstName()%></p>
                            </label>
                            <label class="field">
                                <span class="field__label" for="lastname">Last name</span>
                                <p class="field__input" type="text" id="lastname" ><%=u.getLastName()%></p>
                            </label>
                        </div>
                        <label class="field">
                            <span class="field__label" for="address">House Number</span>
                            <p class="field__input" type="text" pattern="[0-9]" id="address" name="houseNumber" ><%=ua.getHouseNumber()%></p>
                        </label>
                        <label class="field">
                            <span class="field__label" for="address">Street</span>
                            <p class="field__input" type="text" id="address" name="street" ><%=ua.getStreetName()%></p>
                        </label>
                        <label class="field">
                            <span class="field__label" for="country">Country</span>
                            <p class="field__input" id="country">South Africa</p>

                        </label>
                        <div class="fields fields--3">
                            <label class="field">
                                <span class="field__label" for="zipcode">Zip code</span>
                                <p class="field__input" type="text" id="zipcode" ><%=ua.getZipCode()%></p>
                            </label>
                            <label class="field">
                                <span class="field__label" for="city">City</span>
                                <p class="field__input" type="text" id="city" ><%=ua.getCity()%></p>

                            </label>
                            <label class="field">
                                <span class="field__label" for="state">State</span>
                                <p class="field__input" type="text" id="state" ><%=ua.getState()%></p>
                            </label>
                        </div>
                    </div>
                </form>
                <br>
                <a href="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=goPayment">
                    <button class="button">Continue</button>
                </a>

                <br>
                <a href="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=radd&editC=edit">
                    <button class="button">Edit</button>
                </a>
                <br>
                <button class="button" onclick="history.back()">Back</button>
            </div>

        </div>
    </body>

    <style>
        @import url("https://rsms.me/inter/inter.css");

        :root {
            --color-gray: #737888;
            --color-lighter-gray: #e3e5ed;
            --color-light-gray: #f7f7fa;
        }

        *,
        *:before,
        *:after {
            box-sizing: inherit;
        }

        html {
            font-family: "Inter", sans-serif;
            font-size: 14px;
            box-sizing: border-box;
        }

        @supports (font-variation-settings: normal) {
            html {
                font-family: "Inter var", sans-serif;
            }
        }

        body {
            margin: 0;
            background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
        }

        h1 {
            margin-bottom: 1rem;
        }

        p {
            color: var(--color-gray);
        }

        hr {
            height: 1px;
            width: 100%;
            background-color: var(--color-light-gray);
            border: 0;
            margin: 2rem 0;
        }

        .container {
            max-width: 40rem;
            padding: 10vw 2rem 0;
            margin: 0 auto;
            height: 100vh;
        }

        .form {
            display: grid;
            grid-gap: 1rem;
            margin-top: -25px;
        }

        .field {
            width: 100%;
            display: flex;
            flex-direction: column;
            border: 1px solid var(--color-lighter-gray);
            padding: .5rem;
            border-radius: .25rem;

        }

        .field__label {
            color: var(--color-gray);
            font-size: 0.6rem;
            font-weight: 300;
            text-transform: uppercase;
            margin-bottom: 0.25rem
        }

        .field__input {
            padding: 0;
            margin: 0;
            border: 0;
            outline: 0;
            font-weight: bold;
            font-size: 1rem;
            width: 100%;
            -webkit-appearance: none;
            appearance: none;
            background-color: transparent;
        }

        .field:focus-within {
            border-color: #000;
        }

        .fields {
            display: grid;
            grid-gap: 1rem;
        }

        .fields--2 {
            grid-template-columns: 1fr 1fr;
        }

        .fields--3 {
            grid-template-columns: 1fr 1fr 1fr;
        }

        .button {
            background-color: #000;
            text-transform: uppercase;
            font-size: 0.8rem;
            font-weight: 600;
            display: block;
            color: #fff;
            width: 100%;
            padding: 1rem;
            border-radius: 0.25rem;
            border: 0;
            cursor: pointer;
            outline: 0;
        }

        .button:focus-visible {
            background-color: #333;
        }

        .container {
            background-color: aliceblue;
            width: 800px;
            height: 800px;
            margin-top: 50px;
        }

        .div2 {

            margin-bottom: 100px;

        }
    </style>

</html>
