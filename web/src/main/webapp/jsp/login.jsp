<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form name="loginForm" method="POST" action="FrontController">
    <input type="hidden" name="command" value="login"/> Login:<br/> <input
        type="text" name="login" value=""/> <br/>Password:<br/> <input
        type="password" name="password" value=""/> <br/> <br/> <input
        type="submit" value="Log in"/>
</form>
<hr/>
<form name="registrationForm" method="POST" action="FrontController">
    <input type="hidden" name="command" value="registration"/> If you
    have not have an account you can register by filling this fields and
    clicking the button below <br/>
    <table>
        <tr>
            <td>Name(ivan):</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>Surname(ivanov):</td>
            <td><input type="text" name="surname" value=""/></td>
        </tr>
        <tr>
            <td>Login(ivan.ivanov@gmail.com):</td>
            <td><input type="text" name="loginPerson" value=""/></td>
        </tr>
        <tr>
            <td>Password(123456):</td>
            <td><input type="text" name="passwordPerson" value=""/></td>
        </tr>
    </table>
    <br/> <input type="submit" value="Registration"/>
</form>
<hr/>
<br/> ${errorLoginPassMessage}
<br/> ${errorLoginRegistrationPassMessage}
<br/> ${errorRegistrationPassMessage}
<br/> ${wrongAction}
<br/> ${nullPage}
<br/> Links for guest...
<br/> Debug info - session = ${sessionScope}
</body>
</html>