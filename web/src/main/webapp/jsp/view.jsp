<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 06.06.2016
  Time: 23:00
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
    <title>View</title>
    <link rel="stylesheet" type="text/css" href="jsp/style.css">
</head>
<body>
    <tiles:insertDefinition name="viewlayout" />
</body>
</html>
