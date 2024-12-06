<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login or User Register</title>
</head>
<body>

    <h2>-------- Please, Enter Your Name and Password to Login and Access Football Teams CRUD Actions Page --------</h2> <br><br>

    <!-- Login form -->
    <form method="Post" action="LoginServlet">
        Name: <input type="text" name="name" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form><br>

    ------------------------ Or Click the Button Below to Register New User -------------------------- <br><br>

    <!-- Redirect to registration page -->
    <form action="userActions.jsp">
        <button>Register</button>
    </form>

</body>
</html>
