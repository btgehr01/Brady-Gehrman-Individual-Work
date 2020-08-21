<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Flooring Calculator Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                </ul>    
            </div>
            <h2>Please input the information below and press the submit button below to receive a calculation!</h2>
            <div>
                <fieldset>
                    <legend> Needed Flooring Information </legend>
                    <form method="POST" action="getFlooringEstimate">
                        <table>
                            <tr style="margin-bottom: 10px">
                                <th align="right">Width of Room:</th>
                                <td align="left"><input value="0" type="text" style="margin-left: 5px" name="widthOfFloor" onfocus="this.value = ''" /></td>
                            </tr>
                            <tr style="margin-bottom: 10px">
                                <th align="right">Length of Room:</th>
                                <td align="left"><input value="0" type="text" style="margin-left: 5px" name="lengthOfFloor" onfocus="this.value = ''"/></td>
                            </tr>
                            <tr style="margin-bottom: 10px">
                                <th align="right">Cost Per Sqft of Material:</th>
                                <td align="left"><input value="0.00" type="text" style="margin-left: 5px" name="costPerSqFoot" onfocus="this.value = ''" /></td>
                            </tr>
                        </table>
                        <input type="submit" style="margin: 5px" value="Find Total Theoretical Cost"></input>
                    </form>
                </fieldset>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

