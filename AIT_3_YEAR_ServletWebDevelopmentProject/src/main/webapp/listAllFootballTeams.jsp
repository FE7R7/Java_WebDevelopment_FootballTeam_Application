<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>List Of All Football Teams</title>
</head>

<body>

    <h2>---------------------------------- List Of All Football Teams ----------------------------------</h2> <br><br>

    <!-- Iterate through the teams for the logged-in user -->
    <c:forEach items="${newTeamList}" var="listOfTeams">
        Team Name: <c:out value="${listOfTeams.name}" />
        / Team Nationality: <c:out value="${listOfTeams.nationality}" />
        / Team Stadium: <c:out value="${listOfTeams.stadium}" /><br><br>
    </c:forEach><br><br>

    -------- Please Click the Button Below to Go Back to Football Page to Perform Other Actions --------<br><br>

    <!-- Button to go back to the football team actions page -->
    <form action="footballTeamActions.jsp">
        <button>Football Team Page</button>
    </form><br>

</body>

</html>
