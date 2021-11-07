<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bruger siden</title>
    <link rel="stylesheet" href="../css/style2.css">
</head>
<body>

<h1>Velkomme til brugersiden <%=session.getAttribute("name")%></h1>

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
