<%-- 
    Document   : Vproduct
    Created on : Jan 28, 2022, 12:38:53 PM
    Author     : student11
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="za.co.bakery.domain.Product"%>
<%@page import="za.co.bakery.domain.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%Product products = (Product) request.getAttribute("prod");%>
        <title>Item Information</title>

    </head>

        <header>
        
        <nav class="nav bd-grid">
            
            <%User u= (User) request.getSession().getAttribute("user");%>
            <div>
                <a href="#" class="nav__logo">Mrs Pat's Bakery</a>
            </div>

            <div class="nav__menu" id="nav-menu">
                <ul class="nav__list">
                    <li class="nav__item"><a href="index.jsp" class="nav__link active">Home</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cakes" class="nav__link">Cakes</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cookies" class="nav__link">Cookies</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=pies" class="nav__link">Pies</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=fresh_bread" class="nav__link">Bread</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cupcakes" class="nav__link">Cupcakes</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=pastries" class="nav__link">Pastries</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=brownies" class="nav__link">Brownies</a></li>       
                     <%if (u != null) {%>
                    <li class="nav__item"><h2><%u. getLastName();%><h2></li>
                    <li class="nav__item"><a href= "http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=logout"  class="nav__link">Logout</a></li>
                    <%
                        }else{
                    %>
                      <li class="nav__item"><a href= "logpg.jsp"  class="nav__link">Login</a></li>
                     
                      <%}%>
                        <%if (request.getSession().getAttribute("cart") != null) {%>
                    <li class="nav__item"><a href= http://localhost:8080/MrsPatOnlineBakerySystem/cart.jsp  class="nav__link">
                          
                            <img src="https://img.icons8.com/external-flatart-icons-outline-flatarticons/64/000000/external-cart-supermarket-flatart-icons-outline-flatarticons.png" style="width: 30px; height: 30pxpx;"/>
                        </a></li>
                          <%}%>
                </ul>
            </div>


        </nav>

    </header>
    <body>
        <br>
        <div class="view bd-grid2">

            <h1 class="catName"><%=products.getName()%> </h1>

            <div class="product" >

                <div class="wrapper" style="align-content: left">

                    <!-- items -->
                    <div class="items">
                        <!-- single item -->
                        <ul class="nav__list2">



                            <li class=" productsInline"> 

                                <div  class="item">
                                    <h1 class=""></h1>

                                    <% if (products != null) {%>
                                    <li> <img src="<%=products.getPicture()%> "alt="item" style="width: 720px; height: 200px;" "/>
                                        <br>
                                        <p class="price">Price: R <em><%=products.getPrice()%> </em></p>
                                        <br>
                                      <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=cadd&qty=1&page=2&prodid=<%=products.getProductID()%>">

                                            <button class="add-to-cart" type="button" >Add to cart</button></a>
                                    </li>
                                    <li>   <h2  class="name" ><%=products.getName()%> </h2> 

                                        <p> <b>Description:</b></p><p><%=products.getDescription()%></p><br>
                                        <p><b> Warning:</b></p><p><%=products.getWarning()%></P></li>
                                    <li>

                                    </li>


                                    <%} else {%>
                                    <p>No Items Available</p>
                                    <%}%>


                                </div>
                            </li>


                            <!--/ single item -->
                        </ul>

                    </div>
                    <!--/ items -->
                </div>
                <!--/ wrapper -->


            </div>


        </div>
    </body>
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
        *,
        ::before,
        ::after {
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

        h1,
        h2,
        p {
            margin: 0;
        }

        ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        a {
            text-decoration: none;
            color: #fff;
            font-size: 14px;
            text-decoration: none;
            margin: 15px 0;

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
            width: 100%;
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
                alignment-adjust: right;

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
            alignment-adjust: left;

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

        .view {

            background-color: white;

        }

        .bd-grid2 {
            max-width: 90%;
            display: block;
            -ms-grid-columns: 100%;
            grid-template-columns:100%;
            grid-column-gap: 2rem;
            width: calc(100% - 2rem);
            margin-left: var(--mb-2);
            margin-right: var(--mb-2);
            height: 800px;
        }

        .bd-grid2 {
            margin-left: auto;
            margin-right: auto;
            alignment-adjust: left;

        }


        h1.catName {
            text-align: center;
        }
    </style>
    <style class="product">
        .wrapper {
            padding-left: 20px;
            padding-right: 20px;
            margin: 2px auto;
            padding: 20px;     





        }

        .clear {
            clear: both;
        }

        .items {



        }

        .item {
            background-color: #fff;
            float: left;
            margin: 0 10px 10px 0;
            width: 205px;
            padding: 10px;
            height: 190px;
            position:left;
            display: grid;

        }

        .item img {
            display: block;
            margin: auto;

        }

        .name {
            font-size: 16px;
            display: block;
            border-bottom: 1px solid #ccc;
            margin: 0 0 10px 0;
            padding: 0 0 5px 0;
        }

        button {
            display: inline-block;
            background-color: var(--first-color);
            color: #fff;
            padding: .75rem 2.5rem;
            font-weight: var(--font-semi);
            border-radius: .5rem;
            cursor: pointer;
        }
        .productsInline{
            display:grid;     

        }
        .nav__list2 {
            display: -webkit-box;
            display: -ms-flexbox;
            display: fixed;
            padding-top: 0;
            display: grid;
            /*grid-template-columns: repeat(auto-fit, minmax(200px, 2fr));*/
            grid-template-columns: auto auto auto auto;
            grid-gap: 5rem;





        }


    </style>

    </
</html>
