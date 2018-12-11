<%-- 
    Document   : login
    Created on : 26 oct. 2018, 15:38:24
    Author     : Jacques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees (JPA) - Login page</title>
    </head>
    <body>
        <c:out value="${loginError}"/>
        <form name="loginFrm" action="Controller" method="post">
            Login <input type="text" name="loginField" />
            <br />
            Pass <input type="text" name="pwdField" />
            <br />
            <input type="submit" name="btnOK" value="Login" />
        </form>
    </body>
</html>
