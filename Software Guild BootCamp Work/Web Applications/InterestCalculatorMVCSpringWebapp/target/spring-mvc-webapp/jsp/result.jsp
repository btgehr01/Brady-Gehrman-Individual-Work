<%-- 
    Document   : result
    Created on : May 2, 2019, 10:53:42 AM
    Author     : 19bgehrman
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Results</title>
    </head>
    <body>
        <h1>Interest Results</h1>
        <div>
            <c:forEach var="currentYear" items="${listOfYears}">
                <h1> 
                    <c:out value="${currentYear.getYear()}"/>
                </h1>

                <h2>Starting balance: </h2>

                <c:out value="${currentYear.getBeginningBalance()}"/>

                <h2>Amount gained:</h2>

                <c:out value="${currentYear.getAmountEarned()}"/>

                <h2>End of year Balance:</h2>

                <c:out value="${currentYear.getEndingBalance()}"/>

            </c:forEach>
        </div>

        <a href="index.jsp">Return To Calculator!</a>
    </body>
</html>
