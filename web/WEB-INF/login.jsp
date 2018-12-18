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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <title>Employees (JPA) - Login page</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <c:out value="${loginError}"/>
            <div class="card">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <form name="loginFrm" action="Controller" method="post">
                        <input type="text" id="loginField" name="loginField" class="form-control" placeholder="Login"/>
                        <br />
                        <input type="text" name="pwdField" class="form-control" placeholder="Password"/>
                        <br />
                        <input type="submit" name="btnOK" value="Login" class="btn btn-primary" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
