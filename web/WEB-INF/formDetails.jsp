<%-- 
    Document   : formDetails
    Created on : 11 déc. 2018, 11:06:25
    Author     : Claire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="loginFrm" action="Controller" method="post">
            Nom <input type="text" name="loginField" />
            <br />
            Prénom <input type="text" name="pwdField" />
            <br />
            Tel Dom <input type="text" name="loginField" />
            <br />
            Tel Mob <input type="text" name="pwdField" />
            <br />
            Tel Pro <input type="text" name="loginField" />
            <br />
            Adresse <input type="text" name="pwdField" />
            <br /> 
            Code postal <input type="text" name="loginField" />
            <br />
            Ville <input type="text" name="pwdField" />
            <br />    
            Adresse e-mail <input type="text" name="loginField" />
            <br />
            <input type="submit" name="btnSave" value="Save" /> 
            <input type="submit" name="btnCancel" value="Cancel" />
        </form>
    </body>
</html>
