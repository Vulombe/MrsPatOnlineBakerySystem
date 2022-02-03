<%-- 
    Document   : product
    Created on : Jan 28, 2022, 9:48:37 AM
    Author     : student11
--%>

<%@page import="java.util.List"%>
<%@page import="za.co.bakery.domain.LineItem"%>
<%@page import="za.co.bakery.domain.LineItemCollection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.co.bakery.domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping Cart</title>
    </head>

    <header>

        <nav class="nav bd-grid">
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
        <br>
        <div class="view bd-grid2">

            <h1 class="catName">Shopping Cart</h1>
            <br>
            <div class="shopping-cart">

                <div class="column-labels">
                    <label class="product-image">Image</label>
                    <label class="product-details">Product</label>
                    <label class="product-price">Price</label>
                    <label class="product-quantity">Quantity</label>
                    <label class="product-removal">Remove</label>
                    <label class="product-line-price">Total</label>
                </div>

                <%LineItemCollection lineItemCol = (LineItemCollection) request.getSession().getAttribute("cart");
                    double subTotal = 0.0;
                    if (lineItemCol != null) {
                        List<LineItem> items = lineItemCol.getCart();
                        for (LineItem li : items) {
                %>
                <div class="product">
                    <div class="product-image">
                        <img src="<%=li.getProduct().getPicture()%> "style="width: 200px; height: 150px;">
                    </div>
                    <div class="product-details">
                        <div class="product-title"><%=li.getProduct().getName()%></div>
                        <p class="product-description"><%=li.getProduct().getDescription()%></p>
                    </div>
                    <div class="product-price"><%=li.getProduct().getPrice()%></div>

                    <div class="product-quantity">
                        <input type="qty" value=<%=li.getQty()%> min="1">
                    </div>
                    <div class="product-removal">
                        <a href="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=cedit&qty=1&prodid=<%=li.getProduct().getProductID()%>">
                            <button class="remove-product">
                                Remove 1
                            </button>
                        </a>
                    </div>
                    <div class="product-line-price"><%=li.price()%></div>
                </div>
                <% //subTotal+=li.productPrice()

                        }
                    }%>
                <div class="totals">
                    <!-- <div class="totals-item">
                       <label>Subtotal</label>
                       <div class="totals-value" id="cart-subtotal">71.97</div>
                     </div>
                     <div class="totals-item">
                       <label>Tax (5%)</label>
                       <div class="totals-value" id="cart-tax">3.60</div>
                     </div>
                     <div class="totals-item">
                       <label>Shipping</label>
                       <div class="totals-value" id="cart-shipping">15.00</div>
                     </div>-->
                    <div class="totals-item totals-item-total">
                        <label>Grand Total</label>
                        <div class="totals-value" id="cart-total"><%=lineItemCol.total()%></div>
                    </div>

                    <div>
                        <%if (request.getSession().getAttribute("user") != null) {%>
                        <a href="http://localhost:8080/MrsPatOnlineBakerySystem/ocontrol?pro=ocreate">
                            <button class="checkout">Checkout</button>
                        </a>
                        <%} else {%>
                        <p><i>Please Login to complete your order</i></p>
                        <%}%>
                    </div>


                </div> 
            </div>
        </div>
    </body>
</html>
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
        width: calc(100% - 2rem);
        /*  height: 800px;*/
        height:1028px;

    }
    .bd-grid2 {
        margin-left: auto;
        margin-right: auto;
    }


    h1.catName {
        text-align: center;
    }
</style>
<style>

    @import "compass/css3";
    /* Global "table" column settings */
    .product-image {
        float: left;
        width: 20%;
    }
    .product-details {
        float: left;
        width: 37%;
    }
    .product-price {
        float: left;
        width: 12%;
    }
    .product-quantity {
        float: left;
        width: 10%;
    }
    .product-removal {
        float: left;
        width: 9%;
    }
    .product-line-price {
        float: left;
        width: 12%;
        text-align: right;
    }
    /* This is used as the traditional .clearfix class */
    .group:before, .shopping-cart:before, .column-labels:before, .product:before, .totals-item:before, .group:after, .shopping-cart:after, .column-labels:after, .product:after, .totals-item:after {
        content: '';
        display: table;
    }
    .group:after, .shopping-cart:after, .column-labels:after, .product:after, .totals-item:after {
        clear: both;
    }
    .group, .shopping-cart, .column-labels, .product, .totals-item {
        zoom: 1;
    }
    /* Apply clearfix in a few places */
    /* Apply dollar signs */
    .product .product-price:before, .product .product-line-price:before, .totals-value:before {
        content: 'R';
    }
    /* Body/Header stuff */

    h1 {
        font-weight: 100;
    }
    label {
        color: #aaa;
    }
    .shopping-cart {
        max-width: 95%
    }
    /* Column headers */
    .column-labels label {
        padding-bottom: 15px;
        margin-bottom: 15px;
        border-bottom: 1px solid #eee;
    }
    .column-labels .product-image, .column-labels .product-details, .column-labels .product-removal {
        text-indent: -9999px;
    }
    /* Product entries */
    .product {
        margin-bottom: 20px;
        padding-bottom: 10px;
        border-bottom: 1px solid #eee;
    }
    .product .product-image {
        text-align: center;
    }
    .product .product-image img {
        width: 100px;
    }
    .product .product-details .product-title {
        margin-right: 20px;
        font-family: 'HelveticaNeue-Medium', 'Helvetica Neue Medium';
    }
    .product .product-details .product-description {
        margin: 5px 20px 5px 0;
        line-height: 1.4em;
    }
    .product .product-quantity input {
        width: 40px;
    }
    .product .remove-product {
        border: 0;
        padding: 4px 8px;
        background-color: #c66;
        color: #fff;
        font-family: 'HelveticaNeue-Medium', 'Helvetica Neue Medium';
        font-size: 12px;
        border-radius: 3px;
    }
    .product .remove-product:hover {
        background-color: #a44;
    }
    /* Totals section */
    .totals .totals-item {
        float: right;
        clear: both;
        width: 100%;
        margin-bottom: 10px;
    }
    .totals .totals-item label {
        float: left;
        clear: both;
        width: 79%;
        text-align: right;
    }
    .totals .totals-item .totals-value {
        float: right;
        width: 21%;
        text-align: right;
    }
    .totals .totals-item-total {
        font-family: 'HelveticaNeue-Medium', 'Helvetica Neue Medium';
    }
    .checkout {
        float: right;
        border: 0;
        margin-top: 20px;
        padding: 6px 25px;
        background-color: #6b6;
        color: #fff;
        font-size: 25px;
        border-radius: 3px;
    }
    .checkout:hover {
        background-color: #494;
    }
    /* Make adjustments for tablet */
    @media screen and (max-width: 650px) {
        .shopping-cart {
            margin: 0;
            padding-top: 20px;
            border-top: 1px solid #eee;
        }
        .column-labels {
            display: none;
        }
        .product-image {
            float: right;
            width: auto;
        }
        .product-image img {
            margin: 0 0 10px 10px;
        }
        .product-details {
            float: none;
            margin-bottom: 10px;
            width: auto;
        }
        .product-price {
            clear: both;
            width: 70px;
        }
        .product-quantity {
            width: 100px;
        }
        .product-quantity input {
            margin-left: 20px;
        }
        .product-quantity:before {
            content: 'x';
        }
        .product-removal {
            width: auto;
        }
        .product-line-price {
            float: right;
            width: 70px;
        }
    }
    /* Make more adjustments for phone */
    @media screen and (max-width: 350px) {
        .product-removal {
            float: right;
        }
        .product-line-price {
            float: right;
            clear: left;
            width: auto;
            margin-top: 10px;
        }
        .product .product-line-price:before {
            content: 'Item Total: $';
        }
        .totals .totals-item label {
            width: 60%;
        }
        .totals .totals-item .totals-value {
            width: 40%;
        }
    }

</style>
<script>
    /* Set rates + misc */
    var taxRate = 0.05;
    var shippingRate = 15.00;
    var fadeTime = 300;


    /* Assign actions */
    $('.product-quantity input').change(function () {
        updateQuantity(this);
    });

    $('.product-removal button').click(function () {
        removeItem(this);
    });


    /* Recalculate cart */
    function recalculateCart()
    {
        var subtotal = 0;

        /* Sum up row totals */
        $('.product').each(function () {
            subtotal += parseFloat($(this).children('.product-line-price').text());
        });

        /* Calculate totals */
        var tax = subtotal * taxRate;
        var shipping = (subtotal > 0 ? shippingRate : 0);
        var total = subtotal + tax + shipping;

        /* Update totals display */
        $('.totals-value').fadeOut(fadeTime, function () {
            $('#cart-subtotal').html(subtotal.toFixed(2));
            $('#cart-tax').html(tax.toFixed(2));
            $('#cart-shipping').html(shipping.toFixed(2));
            $('#cart-total').html(total.toFixed(2));
            if (total == 0) {
                $('.checkout').fadeOut(fadeTime);
            } else {
                $('.checkout').fadeIn(fadeTime);
            }
            $('.totals-value').fadeIn(fadeTime);
        });
    }


    /* Update quantity */
    function updateQuantity(quantityInput)
    {
        /* Calculate line price */
        var productRow = $(quantityInput).parent().parent();
        var price = parseFloat(productRow.children('.product-price').text());
        var quantity = $(quantityInput).val();
        var linePrice = price * quantity;

        /* Update line price display and recalc cart totals */
        productRow.children('.product-line-price').each(function () {
            $(this).fadeOut(fadeTime, function () {
                $(this).text(linePrice.toFixed(2));
                recalculateCart();
                $(this).fadeIn(fadeTime);
            });
        });
    }


    /* Remove item from cart */
    function removeItem(removeButton)
    {
        /* Remove row from DOM and recalc cart total */
        var productRow = $(removeButton).parent().parent();
        productRow.slideUp(fadeTime, function () {
            productRow.remove();
            recalculateCart();
        });
    }

</script>
