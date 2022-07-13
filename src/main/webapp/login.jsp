<%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/13/22
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="partials/head.jsp" %>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<br><br>
<form action="login.jsp" method="POST">
    <label for="uname">Username:</label>
    <input type="text" id="uname" name="uname"/>
    <br><br>
    <label for="pw">Password:</label>
    <input type="text" id="pw" name="pw"/>
    <br><br>
    <button type="submit">Submit</button>
</form>

    <c:choose>
        <c:when test='${param.uname.equalsIgnoreCase("admin") && param.pw.equals("password")}'>
            <c:redirect url = "profile.jsp"/>
        </c:when>
        <c:otherwise>
<%--            <c:redirect url = "login.jsp"/>--%>
        </c:otherwise>
    </c:choose>



<br><br><br><br><br><br>
<%@ include file="partials/footer.jsp" %>
</body>
</html>
