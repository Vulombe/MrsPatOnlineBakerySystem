<%-- 
    Document   : loginAnswer
    Created on : Jan 17, 2022, 11:32:43 AM
    Author     : student12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Test Page</title>
    </head>
    <body>
        <form action="user" method="post">
            <table>
                <tr>
                    <td>
                        <input type="email" name="email" placeholder="Email Id" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" name="password" placeholder="Password" required="true"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <input type="reset" name="cancelBtn" placeholder="Cancel" />
                    </td>
                    <td>
                        <input type="submit" name="submitBtn" placeholder="Sign Up" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
