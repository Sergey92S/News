<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 21.06.2016
  Time: 11:53
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
<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header" />
    </div>
    <div id="nav">
        <tiles:insertAttribute name="nav" />
    </div>
    <div id="content">

        <c:forEach var="news" items="${result2}">
            <form name="saveEditForm" method="POST" action="FrontController" enctype="multipart/form-data">
                <input type="hidden" name="command" value="multisubmitedit"/>
                <input type="hidden" name="option" value="${news.getId()}"/>
                <table>

                    <tr>
                        <td><fmt:message key="newslist.label.author"/>:</td>
                        <td><input type="text" name="author" value="<c:out value="${news.getAuthor()}"/>"></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.date"/>:</td>
                        <td><input type="date" name="date" value="<c:out value="${news.getDate()}"/>"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.title"/>:</td>
                        <td><input type="text" name="title" size="170" value="<c:out value="${news.getTitle()}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.content"/>:</td>
                        <td><textarea name="content" rows="6" cols="170">${news.getContent()}</textarea></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="newslist.label.image"/>:</td>

                        <td><div class="input_button_style">
                            <div class="input_font_style"><fmt:message key="addnews.button.choose"/></div>
                            <input type="file" name="file" id="file" size="1" onchange="loadFile(event)" class="input_input_style">
                        </div>
                            <script>
                                var loadFile = function (event) {
                                    var output = document.getElementById('output');
                                    output.src = URL.createObjectURL(event.target.files[0]);
                                };
                            </script>
                        </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <img src="${news.getImage()}" id="output"  class="img-test"/>
                            <label id="namefile"></label>
                        </td>
                    </tr>

                </table>
                <table align="center">
                    <td><input type="submit" name="submit" value="Save"/></td>
                    <td><input type="submit" name="submit" value="Cancel"/></td>
                </table>

            </form>
        </c:forEach>

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#file').change(function() {
                    $('#file').each(function() {
                        var name = this.value;
                        reWin = /.*\\(.*)/;
                        var fileTitle = name.replace(reWin, "$1");
                        reUnix = /.*\/(.*)/;
                        fileTitle = fileTitle.replace(reUnix, "$1");
                        $('#namefile').html(fileTitle);
                    });
                });
            });
        </script>

        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${errorValidationMessage}</font></span>

    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>
