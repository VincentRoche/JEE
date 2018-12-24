<%-- 
    Document   : login
    Created on : 26 oct. 2018, 15:38:24
    Author     : Jacques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Employees - Login page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-sm-4"></div><!-- To push the form on the middle -->
            <div class="col-sm-4">
                <span class="text-danger"><c:out value="${loginError}"/></span>
                <div class="panel panel-default">
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <form name="loginFrm" action="Controller" method="post">
                            <input type="text" id="loginField" name="loginField" class="form-control" placeholder="Login"/>
                            <br />
                            <input type="password" name="pwdField" class="form-control" placeholder="Password"/>
                            <br />
                            <input type="submit" name="btnOK" value="Login" class="btn btn-primary" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
