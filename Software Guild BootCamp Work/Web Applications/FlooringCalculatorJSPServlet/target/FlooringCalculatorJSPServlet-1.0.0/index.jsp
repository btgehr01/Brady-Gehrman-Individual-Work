<%-- 
    Document   : index
    Created on : Apr 23, 2019, 9:07:10 AM
    Author     : 19bgehrman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>

</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>SG Flooring</h1>
        <h4>Welcome to the SoftwareGuild Flooring Calculator!! </h4>
        <h4>Our Web Application can calculate the theoretical cost of your future flooring installation, please fill in the infomation below!(:</h4>
        <!--        <form>
                    <fieldset>
                        <legend>Needed Flooring Information</legend>
                        <p>
                            <label for="width" style="margin : 20px">Width of Room: </label>
                            <input type="text" name="widthOfFloor" id="width"><input>
                        </p>
                        <p>
                            <label for="length" style="margin : 20px">Length of Room: </label>
                            <input type="text" name="lengthOfFloor" id="length"><input>
                        </p>
                        <p>
                            <label for="cost" style="margin : 20px">Cost Per Sqft of Material: </label>
                            <input type="text" name="costPerSqFoot" id="cost"><input>
                        </p>
                        <button type="button" action="FlooringServlet" class="btn btn-default col-md-6">Find Total Theoretical Cost</button>
                    </fieldset>
                </form>-->


        <div>
            <fieldset>
                <legend> Needed Flooring Information </legend>
                <form method="POST" action="FlooringServlet">
                    <table>
                        <tr>
                            <th align="right">Width of Room:</th>
                            <td align="left"><input value="0" type="text" name="widthOfFloor" onfocus="this.value=''" /></td>
                        </tr>
                        <tr>
                            <th align="right">Length of Room:</th>
                            <td align="left"><input value="0" type="text" name="lengthOfFloor" onfocus="this.value=''"/></td>
                        </tr>
                        <tr>
                            <th align="right">Cost Per Sqft of Material:</th>
                            <td align="left"><input value="0.00" type="text" name="costPerSqFoot" onfocus="this.value=''" /></td>
                        </tr>
                    </table>
                    <button type="submit" style="margin: 5px" class="btn btn-default ">Find Total Theoretical Cost</button>
                </form>
                
        </div>
    </fieldset>
</body>
</html>
