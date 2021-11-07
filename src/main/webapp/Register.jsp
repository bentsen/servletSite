<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register-Site</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class = "box">
    <h1 id = "loginHeader">
        Welcome
    </h1>
    <h2 id = "loginUnderHeader">
        Register new account!
    </h2>
    <form action="RegisterServlet" method="Post">
        <label for="name">Username:</label>
        <input type="text" id="name" name="name" placeholder= "Username">

        <label for="pass1">Password:</label>
        <input type="password" id="pass1" name="pass1" placeholder="Password">

        <input type="submit" value="Register">
    </form>
</div>
<br/>
</body>
</html>
