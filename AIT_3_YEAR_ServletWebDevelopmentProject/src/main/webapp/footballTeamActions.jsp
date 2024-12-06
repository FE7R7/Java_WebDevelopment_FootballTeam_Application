<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Football Team Actions</title>
</head>
<body>
    <h2>Hello <c:out value="${userLoggedIn}"/> Welcome, You Are Logged In</h2><br><br>
    
    ------------------------------------------ Go to User Actions Page or Logout ------------------------------------------<br><br>
    <form action="userActions.jsp">
        <button>User Actions</button>
    </form><br>
    Or<br><br>
    <form method="Post" action="LogoutServlet">
        <button>Logout</button>
    </form><br>

    ------------------------------------ Please, choose a Football Teams CRUD Action --------------------------------<br><br>
    
    -------- CREATE -> Register Football Teams --------<br><br>
    <form method="Post" action="RegisterFootballTeamServlet">
        Enter Team Name: <input type="text" name="name"><br><br>
        Enter Team Nationality: <input type="text" name="nationality"><br><br>
        Enter Stadium Name: <input type="text" name="stadium"><br><br>
        
        <!-- Hidden field to pass the userId -->
        <input type="hidden" name="userId" value="${userId}">
        
        <input type="submit" value="Register New Football Team">
    </form><br>
    
    Created: <input type="text" name="teamNameCreated" value="${teamNameCreated}"><br><br><br>

    -------- READ -> Read Football Team --------<br><br>
    <form method="Post" action="ReadFootballTeamServlet">
        ID: <input type="text" name="id"><br><br>
        
        <!-- Hidden field to pass the userId -->
        <input type="hidden" name="userId" value="${userId}">
        
        <input type="submit" value="Read Football Team Register"><br><br>
    </form><br><br>
    
    Team Name: <input type="text" name="name" value="${teamReadAfterSearch.name}"><br><br>
    Nationality: <input type="text" name="nationality" value="${teamReadAfterSearch.nationality}"><br><br>
    Stadium: <input type="text" name="stadium" value="${teamReadAfterSearch.stadium}"><br><br>

    -------- READ ALL -> List All Football Teams --------<br><br>
    <form method="Post" action="ListAllFootballTeamServlet">
        <button>List All Football Teams</button>
    </form><br><br>

    <!-- Display the teams -->
    <c:if test="${not empty newTeamList}">
        <table border="1">
            <tr>
                <th>Team Name</th>
                <th>Nationality</th>
                <th>Stadium</th>
            </tr>
            <c:forEach var="team" items="${newTeamList}">
                <tr>
                    <td><c:out value="${team.name}"/></td>
                    <td><c:out value="${team.nationality}"/></td>
                    <td><c:out value="${team.stadium}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if><br><br>

    -------- UPDATE -> Update Football Team --------<br><br>
    <form method="Post" action="UpdateFootballTeamServlet">
        ID: <input type="text" name="id"><br><br>
        Team Name: <input type="text" name="name"><br><br>
        Nationality: <input type="text" name="nationality"><br><br>
        Stadium: <input type="text" name="stadium"><br><br>
        
        <!-- Hidden field to pass the userId -->
        <input type="hidden" name="userId" value="${userId}">
        
        <input type="submit" value="Update Football Team Register">
    </form><br>

    Updated: <input type="text" name="teamNameUpdated" value="${teamNameUpdated}"><br><br><br>

    -------- DELETE -> Remove Football Team --------<br><br>
    <form method="Post" action="RemoveFootballTeamServlet">
        Enter Team Name: <input type="text" name="name"><br><br>
        Enter Nationality: <input type="text" name="nationality"><br><br>
        
        <!-- Hidden field to pass the userId -->
        <input type="hidden" name="userId" value="${userId}">
        
        <input type="submit" value="Remove Football Team Register">
    </form><br>

    Removed: <input type="text" name="teamNameDeleted" value="${teamNameDeleted}"><br><br><br>

</body>
</html>
