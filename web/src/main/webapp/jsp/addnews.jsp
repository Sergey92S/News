<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 06.06.2016
  Time: 18:50
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
    <style type="text/css">
        .input_button_style
        { margin-left:10px; text-align:center; overflow:hidden; width:130px; height:20px; border:1px solid #3D3D3D; background-color:#2B2B2B; border-radius:4px; }
        .input_font_style
        { color:#fff; font-size:16px; font-weight:bold; }
        .input_input_style
        { margin-top:-50px; margin-left:-410px; -moz-opacity:0; filter:alpha(opacity=0); opacity:0; font-size:150px; height:100px; }
    </style>
</head>
<body>
    <tiles:insertDefinition name="addnewslayout" />
</body>

</html>
