<%@ page import="static java.awt.SystemColor.text" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Hello, ${user}.</h1>
        <p> Do/see profile things here</p>
    </div>
</body>
</html>
