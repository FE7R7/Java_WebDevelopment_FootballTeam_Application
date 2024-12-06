<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>User Actions</title>
</head>

<body>

    <h2>-------- Once You Have Created Your User Register, Please Click the Button Below to Go Back to Login Page --------</h2> <br>

    <form action="indexLogin.jsp">
        <button>Login Page</button>
    </form><br><br>

    <c:if test="${empty userId}">
        <p>You need to log in to perform actions on user registers.</p>
    </c:if>

    <c:if test="${not empty userId}">

        -------- CREATE -> Register User --------<br><br>

        <form method='Post' action='RegisterUserServlet'>

            Enter Name: <input type='text' name='name'><br><br>
            Enter Email: <input type='text' name='email'><br><br>
            Enter Password: <input type='text' name='password'><br><br>

            <input type='submit' value='Register New User'>

        </form><br>

        Created: <input type="text" name="userNameCreated" value="${userNameCreated}"><br><br><br>

        -------- READ -> Read User Register --------<br><br>

        <form method='Post' action='ReadUserServlet'>

            ID: <input type='text' name='id' value="${userId}" readonly><br><br>

            <input type='submit' value='Read User Register'><br><br>

            Name: <input type="text" name="userName" value="${userReadAfterSearch.name}" readonly><br><br>
            Email: <input type="text" name="userEmail" value="${userReadAfterSearch.email}" readonly><br><br>
            Password: <input type="text" name="userPassword" value="${userReadAfterSearch.password}" readonly><br><br>

        </form><br><br>

        -------- UPDATE -> Update User Register --------<br><br>

        <form method='Post' action='UpdateUserServlet'>

            ID: <input type='text' name='id' value="${userId}" readonly><br><br>
          
            Name: <input type='text' name='name' value="${userReadAfterSearch.name}"><br><br>
            Email: <input type='text' name='email' value="${userReadAfterSearch.email}"><br><br>
            Password: <input type='text' name='password' value="${userReadAfterSearch.password}"><br><br>

            <input type='submit' value='Update User Register'>

        </form><br>

        Updated: <input type="text" name="userNameUpdated" value="${userNameUpdated}"><br><br><br>

        -------- DELETE -> Remove User Register --------<br><br>

        <form method='Post' action='RemoveUserServlet'>

            Enter Name: <input type='text' name='name' value="${userReadAfterSearch.name}" readonly><br><br>
            Password: <input type='text' name='password' value="${userReadAfterSearch.password}"><br><br>

            <input type='submit' value='Remove User Register'>

        </form><br>

        Removed: <input type="text" name="userNameDeleted" value="${userNameDeleted}"><br><br><br>

    </c:if>

</body>

</html>
