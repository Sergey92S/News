<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 23.06.2016
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table align="center" width="95%">
    <td>
        <span style="font-weight:bold">News Management</span>
    </td>
    <td><font size="5" color="white" face="Arial">_____________________________________________________________________________</font>
    </td>
    <td>
        <form>
            <c:forEach var="news" items="${result}">
            <table>
                <td>
                    <a href="?command=view&result=${result}&option=${news.getId()}&language=en" ${language == 'en' ? 'selected' : ''}>English</a>
                </td>
                <td>
                    <a href="?command=view&result=${result}&option=${news.getId()}&language=ru" ${language == 'ru' ? 'selected' : ''}>Russian</a>
                </td>
            </table>
            </c:forEach>
        </form>
    </td>
</table>
