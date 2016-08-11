<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 21.06.2016
  Time: 11:49
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

        <form onsubmit="return checkForm(this)" name="saveForm" method="POST" enctype="multipart/form-data" action="FrontController">
            <input type="hidden" name="command" value="multisubmit"/> <br/>
            <table>
                <tr>
                    <td><fmt:message key="newslist.label.author"/>:</td>
                    <td><input id="author" type="text" name="author" value=""></td>
                    <td id='err_author' class='error'><span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial"></font></span></td>
                </tr>
                <tr>
                    <td><fmt:message key="newslist.label.date"/>:</td>
                    <td><input id="date" type="date" name="date" placeholder="dd/mm/YYYY" value=""/></td>
                    <td id='err_date' class='error'></td>
                </tr>
                <tr>
                    <td><fmt:message key="newslist.label.title"/>:</td>
                    <td><input id="title" type="text" name="title" value=""/></td>
                    <td id='err_title' class='error'></td>
                </tr>
                <tr>
                    <td><fmt:message key="newslist.label.content"/>:</td>
                    <td><textarea id="con" name="content" rows="6" cols="100"></textarea></td>
                    <td id='err_con' class='error'></td>
                </tr>
                <tr>
                    <td><fmt:message key="newslist.label.image"/>:</td>
                    <%--<td><input id="image"  type="file" name="image" accept="image/*" onchange="loadFile(event)">--%>
                    <td><div class="input_button_style">
                        <div class="input_font_style"><fmt:message key="addnews.button.choose"/></div>
                        <input type="file" name="file" id="file" size="1" onchange="loadFile(event)" class="input_input_style">
                    </div>
                    </td>

                    <td id='err_image' class='error'></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <img id="output" class="img-test"/>
                        <label id="namefile"></label>
                    </td>
                </tr>
                        <script>
                            var loadFile = function (event) {
                                var output = document.getElementById('output');
                                output.src = URL.createObjectURL(event.target.files[0]);
                            };
                        </script>

            <%--<tr>--%>
            <%--<td><div id="namefile"></div></td>--%>
            <%--<td><div class="input_button_style">--%>
                <%--<div class="input_font_style">Выбрать файл</div>--%>
                <%--<input type="file" name="select_file" id="file" size="1" class="input_input_style">--%>
            <%--</div></td>--%>
                <%--</tr>--%>
            </table>
            <table align="center">
                <td><input onclick="setSubmit(this)" type="submit" name="submit" value="Save"/></td>
                <td><input onclick="setSubmit(this)" type="submit" name="submit" value="Cancel"/></td>
            </table>
        </form>

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

        <script type="text/javascript">

            function setSubmit (button)
            {
                submitName = button.value;
            }

            function checkForm(form){

                if (submitName == "Cancel")
                {
                    return true;
                }

                if (document.getElementById('author').value==""){
                    document.getElementById('err_author').innerHTML='Author`s name is requared';
                    document.getElementById('err_author').style.color = 'red';

                    return false;
                }
                else {
                    document.getElementById('err_author').innerHTML="";
                };
                if (document.getElementById('date').value==""){
                    document.getElementById('err_date').innerHTML='Date is requared';
                    document.getElementById('err_date').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_date').innerHTML="";
                };
                if (document.getElementById('title').value==""){
                    document.getElementById('err_title').innerHTML='Title is requared';
                    document.getElementById('err_title').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_title').innerHTML="";
                };
                if (document.getElementById('con').value==""){
                    document.getElementById('err_con').innerHTML='Content is requared';
                    document.getElementById('err_con').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_con').innerHTML="";
                };
                if (document.getElementById('file').value==""){
                    document.getElementById('err_image').innerHTML='Image is requared';
                    document.getElementById('err_image').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_image').innerHTML="";
                };
                return true;
            };
        </script>

        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${errorValidationMessage}</font></span>
    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>
