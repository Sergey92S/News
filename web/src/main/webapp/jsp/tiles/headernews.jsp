<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 17.06.2016
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
    <table align="center" width="95%">
        <td>
            <span style="font-weight:bold">News Management</span>
        </td>
        <td><font size="5" color="white" face="Arial">_____________________________________________________________________________</font>
        </td>
        <td>
            <form>
                <table>
                    <td>
                        <a href="?command=newslist&language=en" ${language == 'en' ? 'selected' : ''}>English</a>
                    </td>
                    <td>
                        <a href="?command=newslist&language=ru" ${language == 'ru' ? 'selected' : ''}>Russian</a>
                    </td>
                </table>

            </form>
        </td>
    </table>
