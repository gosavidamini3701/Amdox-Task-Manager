<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

<h2>Login</h2>

<form action="${pageContext.request.contextPath}/api/auth/login" method="post">

    <label>Username:</label><br>
    <input type="text" name="userOfficialEmail" required /><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required /><br><br>

    <button type="submit">Login</button>

</form>

<!-- Show error if login fails -->
<%
    if (request.getParameter("error") != null) {
%>
    <p style="color:red;">Invalid username or password</p>
<%
    }
%>

</body>
</html>
