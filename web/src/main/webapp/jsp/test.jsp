<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 17.06.2016
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html lang="${language}">
<head>
    <title>News</title>
    <link rel="stylesheet" type="text/css" href="jsp/style.css">
</head>
<body>
<div id="container">
    <tiles:insert attribute="header" />
    <tiles:insert attribute="nav" />

    <div id="content">
        <h1>HELLO</h1>
    </div>

    <tiles:insert attribute="footer" />
</div>
</body>
</html>
