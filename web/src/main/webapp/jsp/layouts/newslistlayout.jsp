<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 21.06.2016
  Time: 11:47
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

        <c:set var="perPage" scope="session" value="${5}"/>
        <c:set var="pageStart" value="${param.start}"/>



        <c:if test="${totalCount <= pageStart}">
            <c:set var="pageStart" value="${pageStart - perPage}"/>
        </c:if>

        <c:if test="${empty pageStart or pageStart < 0}">
            <c:set var="pageStart" value="0"/>
        </c:if>

        <a href="?command=newslist&start=${pageStart - perPage}"><<</a>
        ${pageStart + 1} - ${pageStart + perPage}
        <a href="?command=newslist&start=${pageStart + perPage}">>></a>

        <form name="deletehrefForm" method="POST" action="FrontController">
            <input type="hidden" name="command" value="deletehref"/>
            <table>
                <tr>
                    <table>
                        <c:forEach var="news" items="${result3}" begin="${pageStart}" end="${pageStart + perPage - 1}">
                            <tr>
                                <td>
                                    <table name="news">
                                        <tr>
                                            <span style="font-weight:bold"><c:out value="${news.getTitle()}"/></span>
                                        </tr>
                                        <tr>
                                            <td>[<c:out value="${news.getAuthor()}"/>]</td>
                                            <td>-<c:out value="${news.getDate()}"/></td>
                                        </tr>
                                        <tr>
                                            <td><img src="${news.getImage()}" class="img-test"/></td>
                                            <td><c:out value="${news.getContent()}"/></td>
                                        </tr>
                                    </table>
                                </td>
                                <td><a href="FrontController?command=view&option=${news.getId()}">view</a></td>
                                <td><a href="FrontController?command=edit&option=${news.getId()}">edit</a></td>
                                <td><input type="checkbox" name="newstodelete" value="${news.getId()}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                </tr>
                <tr align="right">
                    <table align="right">
                        <td></td>

                        <c:if test="${result3.size() > 0}">
                            <td><input type="submit" align="right" value="Delete"/></td>
                        </c:if>

                    </table>
                </tr>
            </table>
        </form>

        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${deleteSuccessMessage}</font></span>
        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${errorValidationMessage}</font></span>

    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>
