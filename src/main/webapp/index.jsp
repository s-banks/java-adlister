<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="partials/head.jsp" %>
    <title><%= "some title" %></title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<br><br>
    <c:if test="true">
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
<br><br><br><br><br><br>
<%@ include file="partials/footer.jsp" %>
</body>
</html>
