<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class = "box">
    <h1 id = "loginHeader">
        Welcome
    </h1>
    <h2 id = "loginUnderHeader">
        we're so excited to see you again!
    </h2>
    <form action="LoginServlet" method="Post">
        <div class="lort">
        <label for="name">Username:</label>
        <p class="wrongUsername" style="visibility:<%=request.getAttribute("wrongUsername")%> ">- username or password is invalid</p>
        </div>
        <input type="text" id="name" name="name" placeholder= "Username" style = "border:<%=request.getAttribute("borderColor")%> ">

        <div class="lort">
        <label for="pass1">Password:</label>
        <p class="wrongPassword" style="visibility:<%=request.getAttribute("wrongUsername")%> ">- username or password is invalid</p>
        </div>
        <input type="password" id="pass1" name="pass1" placeholder="Password" style = "border: <%=request.getAttribute("borderColor")%>">

        <input type="submit" value="Login">
    </form>
    <div class="needhelp">
        <p class="newUser">New user?</p> <a class="contactUs" href="Register.jsp">Register account</a>
    </div>
</div>
<br/>
</body>
</html>