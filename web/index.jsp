<%-- 
    Document   : index
    Created on : 25 Jan 2022, 12:22:36 PM
    Author     : Studio13
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome to Miss Pat's bakery</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>


    <header>

        <nav class="nav bd-grid">
            <div>
                <a href="#" class="nav__logo">Mrs Pat's Bakery</a>
            </div>

            <div class="nav__menu" id="nav-menu"  style="padding-left: 50px;">
                <ul class="nav__list">
                    <li class="nav__item"><a href="index.jsp" class="nav__link active">Home</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cakes" class="nav__link">Cakes</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cookies" class="nav__link">Cookies</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=pies" class="nav__link">Pies</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=fresh_bread" class="nav__link">Bread</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cupcakes" class="nav__link">Cupcakes</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=pastries" class="nav__link">Pastries</a></li>
                    <li class="nav__item"><a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=brownies" class="nav__link">Brownies</a></li>
                    <li class="nav__item"><a href= "myaccount.jsp"  class="nav__link">My Account</a></li>
                    <li class="nav__item"><a href= "logpg.jsp"  class="nav__link">Login</a></li>
                    <li class="nav__item"><a href= http://localhost:8080/MrsPatOnlineBakerySystem/cart.jsp  class="nav__link">
                            <img src="https://img.icons8.com/external-flatart-icons-outline-flatarticons/64/000000/external-cart-supermarket-flatart-icons-outline-flatarticons.png" style="width: 30px; height: 30pxpx;"/>
                        </a></li>
                </ul>


            </div>

        </nav>

    </header>
    <body>



        <div class="products">
            <div class="container">
                <div class="item item1">
                    <a href="">
                        <img class="demo" src="https://handletheheat.com/wp-content/uploads/2020/10/BAKERY-STYLE-CHOCOLATE-CHIP-COOKIES-9-637x637-1.jpg" style="height:100%"alt="Pie">
                    </a>


                </div>
                <div class="item item2">
                    <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=pies">
                        <img class="demo" src="https://i.ytimg.com/vi/RoHWiA6pogg/maxresdefault.jpg" style="height:100%"alt="Pie">
                    </a>
                </div>
                <div class="item item3">
                    <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cakes">
                        <img class="demo" src="https://upload.wikimedia.org/wikipedia/commons/0/04/Pound_layer_cake.jpg" style="height:100%"alt="cupcakes">
                    </a>
                </div>
                <div class="item item4">
                    <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=brownies">
                        <img class="demo" src="https://img.taste.com.au/F7vjDzvl/taste/2020/12/kitkat-brownies-168004-2.jpg" style="height:100%" onclick="currentSlide(4)" alt="cupcakes">
                    </a>
                </div>
                <div class="item item5">
                    <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=fresh_bread">
                        <img class="demo" src="https://www.kingarthurbaking.com/sites/default/files/2020-02/the-easiest-loaf-of-bread-youll-ever-bake.jpg" style="height :100%" onclick="currentSlide(4)" alt="bread">
                    </a>

                </div>
                <div class="item item6">
                    <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pview&category=cupcakes">
                        <img class="demo" src="https://www.twosisterscrafting.com/wp-content/uploads/2016/01/easter-cupcakes-1200-featured-735x735.jpg" style="height:100%" onclick="currentSlide(4)" alt="cupcakes">

                    </a>
                </div>

            </div>

        </div>

        <script src="main.js"></script>
        <script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>
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

        /*--------------------------------------------------------------------------------*/
        .container {
            display: grid;
            grid-template-columns: 300px 300px 300px;
            grid-template-rows: 300px 300px;
            grid-gap: 1rem;

        }



        /* OTHER STYLES */

        .products {

            height: 50%;
            width: 90%;
            display: flex;
            justify-content: center;
            align-items: center;
            padding-top: 5%
        }


        .item {
            background-color: #1EAAFC;
            background-image: linear-gradient(130deg, #6C52D9 0%, #1EAAFC 85%, #3EDFD7 100%);
            box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
            color: #fff;
            border-radius: 4px;
            border: 6px solid white;
        }

        /*-------------------------------------------*/
        @property {
            syntax: '<number>';
            initial-value: 0;
            inherits: false;
        }


        .demo {
            --k: 0;
            --j: calc(1 - var(--k));
            --list: transparent calc(50% - 4vmin), red 0  calc(50% + 4vmin), transparent 0;
            place-self: center;
            -o-object-fit: cover;
            object-fit: cover;
            width: 90vmin;
            height: 90vmin;
            -webkit-filter: grayScale(var(--j));
            filter: grayScale(var(--j));
            --mask: 
                radial-gradient(closest-side, red calc(50% - 1px), transparent 50%), 
                radial-gradient(closest-side, 
                transparent calc(50% - 25% + var(--k)*2*25% - 1px), 
                red calc(50% - 25% + var(--k)*2*25%) calc(var(--k)*100% + var(--j)*50% - 1px), 
                transparent calc(var(--k)*100% + var(--j)*50%)), 
                linear-gradient(var(--list)), 
                linear-gradient(90deg, var(--list)), 
                linear-gradient(45deg, var(--list)), 
                linear-gradient(-45deg, var(--list));
            -webkit-mask: var(--mask);
            mask: var(--mask);
            -webkit-mask-composite: add, intersect, add, add;
            mask-composite: add, intersect, add, add;
            transition: --k .2s ease-out;
        }

        img:hover {
            --k: 1 ;
        }
        .pname:hover{
            --k: 1 ;
            padding:10%;
        }
        /*# sourceMappingURL=styles.css.map */

        /*----------------------------------------------------*/


    </style>
</html>
