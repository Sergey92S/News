<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 21.06.2016
  Time: 11:55
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

        <c:forEach var="news" items="${result}">
            <form name="deleteForm" method="POST" action="FrontController">
                <input type="hidden" name="option" value="${news.getId()}"/>
                <input type="hidden" name="command" value="multisubmit"/>
                <table>

                    <tr>
                        <td><fmt:message key="newslist.label.author"/>:</td>
                        <td><c:out value="${news.getAuthor()}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.date"/>:</td>
                        <td><c:out value="${news.getDate()}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.title"/>:</td>
                        <td><c:out value="${news.getTitle()}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.content"/>:</td>
                        <td><c:out value="${news.getContent()}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.image"/>:</td>
                        <td><img src="${news.getImage()}" class="img-test"/></td>
                    </tr>

                </table>
                <table align="center">
                    <td><input type="submit" name="submit" value="Edit"/></td>
                    <td><input type="submit" name="submit" value="Delete"/></td>
                </table>
            </form>
        </c:forEach>

    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>