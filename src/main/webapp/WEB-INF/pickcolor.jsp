<%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/15/22
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
    <%@ include file="../partials/head.jsp" %>
</head>
<body>
<%@ include file="../partials/navbar.jsp" %>
<form action="/pickcolor" method="POST">
    <label for="color">Favorite Color:</label><br>
    <input type="text" id="color" name="color" placeholder="Input your favorite color">
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
