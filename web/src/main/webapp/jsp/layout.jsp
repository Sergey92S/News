<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 21.06.2016
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html lang="${language}">
<head>
    <title>News</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header" />
    </div>
    <div id="nav">
        <tiles:insertAttribute name="nav" />
    </div>
    <div id="content">
        <h1>HELLO</h1>
    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>
