<%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/15/22
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Color</title>
    <%@ include file="../partials/head.jsp" %>
</head>
<body style="background-color: ${color}">
<%@ include file="../partials/navbar.jsp" %>
<h1>Your favorite color is: ${color}</h1>
</body>
</html>
