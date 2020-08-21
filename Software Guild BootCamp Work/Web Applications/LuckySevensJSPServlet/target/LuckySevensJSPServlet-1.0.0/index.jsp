<%-- 
    Document   : index
    Created on : Apr 24, 2019, 9:40:20 AM
    Author     : 19bgehrman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <h4>Welcome to the Lucky Sevens main Menu</h4>
        <h2>The Rules are below:</h2>
        <p>Each round, the program rolls a virtual pair of dice for the user
            If the sum of the 2 dice is equal to 7, the player wins $4; otherwise, the player loses $1</p>
        <fieldset>
            <legend> Needed Information To Participate in this game</legend>
            <form type="post" action="LuckySevensJSPServlet">
                <table>
                    <tr>
                        <th align="right">Money Input:</th>
                        <td align="left"><input value="$0.00" type="text" name="money" onfocus="this.value = ''" /></td>
                    </tr>
                </table>
                <input type="submit" style="margin: 5px" class="btn btn-default " value="Play The Game">
            </form>
        </feildset>
</body>
</html>
