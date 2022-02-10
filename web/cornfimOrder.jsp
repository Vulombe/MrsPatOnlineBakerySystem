<%-- 
    Document   : cornfimOrder
    Created on : 10 Feb 2022, 8:54:36 AM
    Author     : Studio13
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <meta http-equiv="refresh" content="10; url=index.jsp">
        <title>Add Address</title>
    </head>

    <body>

        <div class="container1">


            <div>
                <p class="textx" id="Order"></p>
            </div>

            <div class="contanier">

                <div class="main">

                    <br>
                    <div class="road">
                        <ul>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                        </ul>
                        <div class="bus">
                            <div class="back">
                                <div class="back1door"></div>
                                <div class="back2door"></div>
                                <div class="join"></div>
                            </div>
                            <div class="front">
                                <div class="black"></div>
                                <div class="light1"></div>
                                <div class="light2"></div>
                            </div>
                        </div>
                        <div class="gift"></div>

                        <div>

                        </div>

                    </div>
                </div>

            </div>
        </div>

    </body>
    <script>

        setTimeout(function () {
            document.location = "index.jsp";
        }, 5000); // <-- this is the delay in milliseconds

        const ashley = document.getElementById("Order");

        function lunchMenu(food1, food2) {
            ashley.innerHTML = `<strong>${food1} ${food2}.`;
        }

        setTimeout(lunchMenu, 2000, "Order", "Cornfirmed");

    </script>

    <style>

        .textx {
            text-align: center;
            color: blue;
            letter-spacing: 10px;
        }
        body {
            margin:inherit;
            margin-top:inherit;
            alignment-adjust:center
        }

        .container1 {
            max-width: 40rem;
            padding: 10vw 2rem 0;
            margin: 0 auto;
            height: 100vh;
        }

        .contanier {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
            background-color: white;
            z-index: -6;
        }

        .contanier {
            position: relative;
            display: flex;
            text-align: center;
            top: 100px;
            left: 100px;
        }

        .road {
            position: absolute;
            width: 350px;
            height: 100px;
            background-color: #2F363F;
            border-radius: 50px;
            z-index: -3;
            overflow: hidden;
        }

        ul {
            position: absolute;
            list-style-type: none;
            top: 25px;
            left: -25px;
            z-index: -2;
        }

        li {
            display: inline-block;
            position: relative;
            width: 20px;
            height: 6px;
            border-radius: 20px;
            background-color: #fff;
            margin-left: 5px;
            animation: new 9s infinite linear;

        }

        @keyframes new {

            0%,
            40% {
                opacity: 1;
                left: 350px;
            }

            50% {
                left: 0px;
            }

            75% {
                opacity: 1;
            }

            80% {
                opacity: 0;
            }

            100% {
                opacity: 0;
            }
        }

        .bus {
            position: absolute;
            animation: move 9s infinite 0s linear;
            right: 110px;

        }

        @keyframes move {
            0% {
                transform: scale(0);
                opacity: 1;
            }

            15% {
                transform: translateX(300px);
                opacity: 1;

            }

            25% {
                transform: translateX(-40px);
            }

            49% {
                transform: translateX(-40px);
            }

            55% {
                transform: translateX(10px);
            }

            65% {
                transform: translateX(-65px);
            }

            100% {
                transform: translateX(450px);
            }
        }

        .back {
            position: absolute;
            top: 20px;
            right: 0px;
            width: 100px;
            height: 60px;
            background-color: #DAE0E2;
            border-radius: 1px;
        }

        .back1door {

            position: absolute;
            top: 5px;
            right: 100px;
            width: 25px;
            height: 5px;
            background-color: #DAE0E2;
            animation: 10s linear infinite;
            transform-origin: 130% 130%;
            transform: rotateZ(-90deg);
            animation: move1 9s infinite 1.1s linear;
        }

        @keyframes move1 {
            0% {}

            15% {
                transform: rotate(-90deg);
            }

            20% {
                transform: rotate(25deg);
            }

            23% {
                transform: rotate(5deg);
            }

            30% {
                transform: rotate(-90deg);
            }
        }

        .back2door {

            position: absolute;
            top: 45px;
            right: 100px;
            width: 25px;
            height: 5px;
            background-color: #DAE0E2;
            animation: 10s linear infinite;
            transform-origin: 100% 100%;
            transform: rotateZ(90deg);
            animation: move2 9s infinite 1s linear;
        }

        @keyframes move2 {
            0% {}

            15% {
                transform: rotate(90deg);
            }

            20% {
                transform: rotate(-25deg);
            }

            23% {
                transform: rotate(5deg);
            }

            30% {
                transform: rotate(90deg);
            }
        }

        .front {
            position: absolute;
            top: 23px;
            right: -54px;
            width: 50px;
            height: 55px;
            background-color: #EA425C;
            border-radius: 0 10px 10px 0;
            z-index: -2;
        }

        .front::after {
            position: absolute;
            content: "";
            right: 0px;
            top: 0px;
            bottom: 0px;
            width: 33px;
            height: 100%;
            /* background-color:#B83227;*/
            border-radius: 0 10px 10px 0;
            z-index: -1;
        }

        .black {
            position: absolute;
            margin: 0 17px;
            top: 2px;
            width: 15px;
            height: 50px;
            background-color: #000;
            border-radius: 0 30px 30px 0;
        }

        .black::after {
            position: absolute;
            content: "";
            top: 10px;
            width: 100%;
            height: 5px;
            transform: skew(-10deg);
            background-color: #A4B0BD;
            opacity: 0.3;
        }

        .black::before {
            position: absolute;
            content: "";
            top: 20px;
            width: 100%;
            height: 5px;
            transform: skew(-10deg);
            background-color: #A4B0BD;
            opacity: 0.3;
        }

        .join {
            position: absolute;
            top: 15px;
            right: -10px;
            background-color: #DAE0E2;
            width: 20px;
            height: 30px;
            z-index: -3;
        }

        .light1 {
            position: absolute;
            top: 2px;
            right: 0px;
            width: 5px;
            height: 15px;
            background-color: #F3B431;
            border-radius: 10px;
        }

        .light1::after {
            position: absolute;
            content: "";
            top: 0px;
            left: 5px;
            width: 0px;
            height: 15px;
            background-color: #E1DA00;
            opacity: 0.5;
            box-shadow: 5px 0px 5px 1px #E1DA00,
                10px 0px 5px 2px #E1DA00,
                15px 0px 5px 3px #E1DA00,
                20px 0px 5px 4px #E1DA00,
                25px 0px 6px 5px #E1DA00,
                28px 0px 7px 6px #E1DA00;
            border-radius: 10px;
            opacity: 0.8;
        }

        .light2 {
            position: absolute;
            top: 38px;
            right: 0px;
            width: 5px;
            height: 15px;
            background-color: #F3B431;
            border-radius: 10px;
        }

        .light2::after {
            position: absolute;
            content: "";
            top: 0px;
            left: 5px;
            width: 0px;
            height: 15px;
            background-color: #E1DA00;
            opacity: 0.5;
            box-shadow: 5px 0px 5px 1px #E1DA00,
                10px 0px 5px 2px #E1DA00,
                15px 0px 5px 3px #E1DA00,
                20px 0px 5px 4px #E1DA00,
                25px 0px 6px 5px #E1DA00,
                28px 0px 7px 6px #E1DA00;
            border-radius: 10px;
            opacity: 0.8;

        }

        .gift {
            position: absolute;
            width: 35px;
            height: 35px;
            top: 35px;
            left: 0px;
            background-color: #FAD02E;
            border-radius: 10px;
            overflow: hidden;
            animation: giftan 9s infinite ease-in-out;


        }

        .gift::after {
            position: absolute;
            content: "";
            top: 16px;
            left: 0;
            right: 0;
            width: 35px;
            height: 3px;
            background-color: #616C6F;
            opacity: 0.8;
            border-radius: 1px;
            z-index: 1;
        }

        @keyframes giftan {
            0% {
                transform: scale(1.0);
            }

            10% {
                transform: translateX(20px);
            }

            30% {
                transform: translateX(20px);
            }

            36% {
                transform: scale(1.0) translateX(120px);
                opacity: 1;
                z-index: -1;
            }

            37% {
                opacity: 0;
            }

            100% {
                transform: scale(0) translateX(350px);
                opacity: 0;
            }
        }

        .text {
            position: absolute;
            margin: 30px;
            left: 40px;
            font-size: 1.5em;
            display: flex;
            color: #F3B431;
            font-style: bolder;
            animation: show2 9s infinite;
        }

        @keyframes show2 {

            0%,
            80% {
                opacity: 0;
            }
        }
    </style>

</html>