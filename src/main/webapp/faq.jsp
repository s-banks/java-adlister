<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/13/22
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<% System.out.println("Hello World!");%>--%>
<%! String color; %>
<%
    if(request.getParameter("color") != null) {
    color = request.getParameter("color");
    }
%>
<%--<% request.setAttribute("numbers", "1, 2, 3, 4, 5");%>--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<h1>Frequently Asked Questions</h1>
<form action="faq.jsp" method="POST">
    <label for="color">What is your favorite color?</label>
    <input typoe="text" id="color" name="color"/>
    <button type="submit">Submit</button>
</form>
<%--<p>Your favorite color is: <%= color %></p>--%>

<%--<p>${numbers}</p>--%>
<%--<p>${trails}</p>--%>

<c:if test="${param.color != null}">
    <p>Your favorite color is: ${param.color}</p>
</c:if>

<%
    List<String> trails = new ArrayList<>();
    trails.add("Salado Creek Greenway");
    trails.add("Geology Trail");
    trails.add("Leon Creek Greenway");
%>
<% request.setAttribute("trails", trails);%>

<ul>
    <c:forEach var="trail" items="${trails}">
        <li>${trail}</li>
    </c:forEach>
</ul>

<c:if test="${param.color != null}">
    <c:choose>
        <c:when test='${param.color.equalsIgnoreCase("blue")}'>
            <h1>Whoa, blue is my favorite color too!</h1>
        </c:when>
        <c:otherwise>
            <h1>But...${param.color} is not blue...</h1>
        </c:otherwise>
    </c:choose>
</c:if>

</body>
</html>
