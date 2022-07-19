<%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/18/22
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Yay, ads!</title>
</head>
<body>
<h1>Ads here.</h1>
<c:forEach var="ad" items="${ads}">
    <div>
        <h2>${ad.title}</h2>
        ${ad.description}
        <br>
    </div>
</c:forEach>
</body>
</html>
