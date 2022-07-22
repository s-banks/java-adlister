<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/21/22
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="User Registration" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<%    String msg;
    if(session.getAttribute("msg")!=null){
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        msg= (String)session.getAttribute("msg");
        output.print("<p style='color:red;'> "+msg+" </p>");
    }
%>

<form action="/register" method="post" style="margin-left: 20px;">
    <label for="username">User Name:</label><br>
    <input type="text" id="username" name="username"><br>
    <br>
    <label for="email">Email Address:</label><br>
    <input type="text" id="email" name="email">
    <br>
    <label for="password">Password:</label><br>
    <input type="text" id="password" name="password"><br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
