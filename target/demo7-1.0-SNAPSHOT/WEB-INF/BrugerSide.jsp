<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 25/10/2021
  Time: 21.23
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bruger siden</title>
    <link rel="stylesheet" href="style2.css" type="text/css">
</head>
<body>

<h1>Velkomme til brugersiden <%=request.getAttribute("name")%> du er logget ind som ${sessionScope.navn}</h1>

her kan du oprette emner til din huske sedel



<form action="Emnetilfoej" method="get">

    <label for="name">Emne:</label><br>
    <input type="text" id="name" name="emne"><br>

    <input type="submit" value="Tilføj emne">

</form>

<br>

<form action="Sletemne" method="post">

    <label for="name">Slet emne:</label><br>
    <input type="text" id="sletEmne" name="emne"><br>

    <input type="submit" value="Slet emne">

</form>

<br>
<br>
<br>

<c:forEach items="${sessionScope.emneListe}" var="emne">

    ${emne}
    <br>

</c:forEach>



</body>
</html>
