<%-- 
    Document   : adminAdd
    Created on : Feb 1, 2022, 10:30:16 AM
    Author     : student11
--%>
<%@page import="za.co.bakery.domain.Category"%>
<%@page import="java.util.EnumSet"%>
<%@page import="za.co.bakery.domain.Recipe"%>
<%@page import="za.co.bakery.domain.Product"%>
<%@page import="za.co.bakery.domain.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.co.bakery.domain.IngredientItem"%>
<%@page import="java.util.List"%>
<%@page import="za.co.bakery.controllers.AdminController"%>
<%@page import="za.co.bakery.controllers.ProductController"%>
<%@page import="za.co.bakery.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Admin</title>

    </head>
    <body>


        <h1 class="a"><b>Admin</b></h1>
        <%
            String value = (String) request.getAttribute("admin");
            if (value.equalsIgnoreCase("padd")) {
        %>
    <center>
        <!--------------------------------PRODUCT ADD---------------------------------------------------------->

        <div class="box">

            <form action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=padd" ><!--product add-->
                <input type="hidden" name="pro" value="padd">

                <input type="text" size="50" name="name" placeholder="Enter name of product"  required=""style=" height: 40px;">
                <br></br>
                <input type="text" size="50"name="picture" placeholder="Enter picture adress "  required=""style=" height: 40px;">
                <br></br>
                <input type="number" size="50" name="price" placeholder="Enter price"  required=""style=" height: 40px;">
                <br></br>
                <select name="category" id="mySelect" "style=" height: 60px;">
                    <option>Pick the Category</option>
                    <% for (Category c : Category.values()) {%>
                    <option value="<%=c%>"><%=c%></option>
                    <% }; %>     
                </select>

                <br></br>
                <input type="text" size="50" name="warning" placeholder="Enter product warning"  required=""style=" height: 40px;">
                <br></br>
                <input type="text" size="50" name="description" placeholder="Enter product description"  required=""style=" height: 40px;">
                <br></br>
                <input type="hidden" name="pro" value="rlist">
                <select name="recipeID" id="recipeID" style="height:40px;" >
                    <%  List<Recipe> r = (ArrayList<Recipe>) request.getAttribute("recipes");
                        if (request.getAttribute("recipes") != null)
                            for (Recipe rr : r) {%>
                    <option value= "<%=rr.getRecipeID()%>" ><%=rr.getRecipeName()%></option>
                    <% } %>       
                </select>

                <br>
                <button>Submit</button> 

            </form>

        </div>    




        <!-------------------------------END PRODUCT ADD----------------------------------------------------------------------------------------------------------------------------------->
        <%               } else if (value.equalsIgnoreCase("pdelete")) {


        %>
        <!----------------------------BEGIN DELETE PRODUCT-------------------------------------->
        <div class="box">
            <form method ="POST" action="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol?pro=plist">
                <br></br>
                <select name="category" id="mySelect" "style=" height: 60px;">
                    <option>Pick the Category</option>
                    <% for (Category c : Category.values()) {%>
                    <option value="<%=c%>"><%=c%></option>
                    <% }; %>     
                </select>
                <input class="button" type="submit"value="submit" name="submit"> 
                <br>

            </form> 
        </div>           















        <!--------------------------------END DELETE PRODUCT----------------------------------------------------------------->
        <%                   } else if (value.equalsIgnoreCase("pedit")) {


        %>

        <div class="box">
            <form action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=pedit"  ><!-- update product--> 
                <!---update product----------------------------------------------------------------------------------------------->
                <input type="hidden" name="pro" value="pedit">
                <select name="prodid" id="prodid" style="height:40px;" >
                    <option>Pick the product</option>
                    <%  List<Product> r = (ArrayList<Product>) request.getAttribute("prolist");
                        if (request.getAttribute("prolist") != null)
                            for (Product rr : r) {%>
                    <option value= "<%=rr.getProductID()%>" ><%=rr.getName()%></option>
                    <% } %>       
                </select>
                <select name="field" id="field"style="height:40px;">
                    <option>Pick the field</option>
                    <option value="name">Name</option>
                    <option value="picture">Picture</option>
                    <option value="price">Price</option>
                    <option value="warning">Warning</option>
                    <option value="description">Description</option>
                </select>

                <input id="other-input" type="text" size="50" name="update" placeholder="Enter product update"  required=""style=" height: 40px;">


                <input class="button" type="submit"value="submit" name="update"> 
                </label>
                </div>   

            </form> 
        </div>        










        <!----------------------------------UPDATE PRODUCT--------------------------------------------------------------------->   
        <%     } else if (value.equalsIgnoreCase("radd")) {

        %>
        <!-----------------------------------RECIPE ADD-------------------------------------------------------------------------------------->

        <div class="box">
            <form action="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol">
                <input type="hidden" name="pro" value="radd">
                <input type="text" size="50"name="rname" placeholder="Enter recipe name "  required=""style=" height: 40px;">
                <br></br>
                <input type="text" size="50" name="steps" placeholder="Enter recipe steps"  required="""style=" height: 40px;">
                <br></br>
                <input  type="text" size="50" name="ingredients" placeholder="Enter recipe ingredients"  required=""style=" height: 40px;">
                <input type="hidden" name="pro" value="ilist">
                <select name="ingredientList" id="mySelect">
                    <% List<Ingredient> in = (ArrayList<Ingredient>) request.getAttribute("ingredientList");
                        if (request.getAttribute("ingredientList") != null)
                            for (Ingredient ing : in) {%>
                    <option><%=ing.getName()%></option> 
                    <% } %>
                </select>
                <br></br>
                <button>Submit</button> 
                <div class="popup">
                </div>
            </form>
        </div>
        <!---------------------Recipe ADD----------------------------------------------------------------------------------------------------------------------------->

        <%  } else if (value.equalsIgnoreCase("rdel")) {


        %>
        <!-----------------------------------------DELETE RECIPE------------------------------------------------------------------------------------------------>
        <div class="box">
            <form action="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol"  ><!-- delete recipe-->

                <input type="hidden" name="pro" value="rdel">
                <input type="text" size="50"name="name" placeholder="Enter product ID "  required=""style=" height: 40px;">
                <button>Submit</button> 
                <br></br>

            </form> 
        </div>
        <!-------------------------------------------END DELETE RECIPE--------------------------------------------------------------------------------------------> 
        <%               } else if (value.equalsIgnoreCase("redit")) {


        %>
        <!--------------------------------------------------update RECIPE-----------------------------------------------------------------------------------------------> 
        <div class="box">
            <form action="http://localhost:8080/MrsPatOnlineBakerySystem/acontrol"  >
                <input type="hidden" name="pro" value="redit">
                <select id="mySelect" onClick="check(this);">
                    <option>Choose The changes you would like to make:</option>   
                    <option name="ID">Product ID</option>
                    <option name="recipeName" >Product Recipe</option>
                    <option name="steps">Enter recipe steps</option>
                    <option name="ingredients">Enter recipe ingredients</option>
                </select>
        </div>
        <div id="other-div" style="display:none;" >
            <label class="a">Enter Changes
                <input id="other-input"></input>
                <button>Submit</button> 
            </label>
        </div>

    </form>    
    <!----------------------------------UPDATE RECIPE--------------------------------------------------------------------->  
    <% } else if (value.equalsIgnoreCase("iadd")) {


    %>
    <!---------------------------------------------ADD INGREDIENT------------------------------------------------------------------------------------------------>
    <div class="box">
        <form method="post" action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=iadd"  >
            <input type="hidden" name="pro" value="iadd">
            <input type="text" size="50" name="ingredientName" placeholder="Enter ingredient name"  required=""style=" height: 40px;">
            <br></br>
            <input type="text" size="50"name="ingredientNutrient" placeholder="Enter ingredient nutrient"  required=""style=" height: 40px;">
            <br></br>
              <button>Submit</button> 

        </form>
    </div> 

    <!------------------------------------------------------ END ADD INGREDIENT----------------------------------------------------------------------------------->
    <%               } else if (value.equalsIgnoreCase("idel")) {


    %>
    <!-----------------------------------------DELETE INGREDIENT------------------------------------------------------------------------------------------------> 
    <div class="box">
        <form action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=idel" ><!-- delete ingredient-->
            <input type="hidden" name="pro" value="idel">
           
            <select nam="name="ingredientid" id="ingredientid">
                <option>Select the Ingredient</option>
                 <% List<Ingredient> in = (ArrayList<Ingredient>) request.getAttribute("ingredientid");
                        if (request.getAttribute("ingredientid") != null)
                            for (Ingredient ing : in) {%>
                    <option><%=ing.getIngredientID()%></option> 
                    <% } %>
                    
            </select>
             
            <br>
             <input class="button" type="submit"value="submit" name="delete"> 

        </form> 
    </div>
    <!-------------------------------------------END DELETE INGREDIENT-------------------------------------------------------------------------------------------->
    <%               } else if (value.equalsIgnoreCase("iedit")) {


    %>
    <!--------------------------------------------------update INGREDIENT-----------------------------------------------------------------------------------------------> 
    <div class="box">
        <form action="http://localhost:8080/MrsPatOnlineBakerySystem/pcontrol?pro=iedit" id="formiup">
            <input type="hidden" name="pro" value="iedit">
           <input type="text" size="50" name="ingredientName" placeholder="Enter name of product"  required=""style=" height: 40px;">
            <br></br>
            <input type="text" size="50"name="ingredientNutrient" placeholder="Enter product nutrient"  required=""style=" height: 40px;">
            <br></br>
             <input class="button" type="submit" value="submit" name="submit"> 
       


        </form>   
    </div>
    <!----------------------------------UPDATE INGREDIENT--------------------------------------------------------------------->  
    <% } else if (value.equalsIgnoreCase("update")) {


    %>

    <!------------------------------------ADD USER-----------------------------------------------------------------------> 
    <div class="box">
        <form action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=update" >
            <input type="hidden" name="pro" value="update">
            <select name= "title" id="title">
                <option value="Mr">Mr</option>
                <option value="Mrs">Mrs</option>
                <option value="Ms">Ms</option>
                <option value="Dr">Dr</option>
                <option value="Prof">Prof</option>
            </select></p> 
            <input type="text" size="50" name="firstName" placeholder="Enter User's First name"  required=""style=" height: 40px;">
            <br></br>
            <input type="text" size="50"name="lastName" placeholder="Enter User's last name"  required=""style=" height: 40px;">
            <br></br>
            <input  type="text" size="50" name="loginEmail" placeholder="Enter Email"  required=""style=" height: 40px;">
            <br></br>
            <input type="text" size="50" name="contactNumber" placeholder="Enter contact Number"  required=""style=" height: 40px;">
            <br></br>  
            <input type="text" size="50" name="loginPassword" placeholder="Enter Password"  required=""style=" height: 40px;">
            <br></br> 
            <button>Submit</button>  
        </form>            
    </div>

    <!-----------------------------------END ADD USER------------------------------------------------------->
    <!-----------------------------------UPDATE USER-------------------------------------------------------->
    <%         } else if (value.equalsIgnoreCase("viewusers")) {


    %>
    <div class="box">
        <form action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=viewusers"  >
            <!---update product----------------------------------------------------------------------------------------------->
            <input type="hidden" name="pro" value="viewusers">
            <select id="mySelect" onClick="check(this);">
                <option>Choose The changes you would like to make:</option>   
                <option name="name">Product Name</option>
                <option name="picture" >Product Picture</option>
                <option name="price">Product Price</option>
                <option name="category">Product Category</option>
                <option name="warning">Product Warning</option>
                <option name="description">Product description</option>
                <option name="recipe">Product Recipe</option>
            </select>
    </div>
    <div id="other-div" style="display:none;">
        <label class="a">Enter Changes
            <input id="other-input"></input>
            <button>Submit</button> 
        </label>
    </div>

</form>    
<!-----------------------------------END UPDATE USER---------------------------------------------------->
<!-----------------------------------DELETE USER------------------------------------------------>
<%     } else if (value.equalsIgnoreCase("delete")) {

%>
<div class="box">
    <form action="http://localhost:8080/MrsPatOnlineBakerySystem/ucontrol?pro=delete">
        <input type="hidden" name="pro" value="delete">
        <input type="text" size="50"name="loginEmail" placeholder="Enter user login Email "  required=""style=" height: 40px;">
        <button>Submit</button> 
        <br></br>

    </form> 
</div> 
<% }%>
<center> <button id="back" onclick="goBack()">BACK</button></center>

</body>
<script src="main.js"></script>
<script>

    function check(elem) {

        if (elem.selectedIndex) {
            document.getElementById("other-div").style.display = 'block';
        } else {
            document.getElementById("other-div").style.display = 'none';
        }
    }
</script>

<style>
    body{
        background-image: url(https://www.teahub.io/photos/full/48-480241_bakery-hd.png);
        color: #212121;
        margin: 0;
        padding: 0;
    }
    div{
        align:center;
    }
    .a{

        color: #fff;
        font-size: 14px;
        text-decoration: none;
        margin: 15px 0;
    }
    * {
        box-sizing: border-box;
    }



    .box {
        background-color: black;
        border: 15px solid transparent;
        border-image: linear-gradient(135deg, #CDDC39, #1976D2) 1;
        border-radius: 100px;
        height: 700px;
        margin: 0 auto;
        padding: 10px;
        width: 700px;
    }
    .popup {
        position: relative;
        display: inline-block;
        cursor: pointer;
    }
</style>
</html>
