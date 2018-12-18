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
            Name <input type="text" name="name" />
            <br />
            First name <input type="text" name="firstname" />
            <br />
            Home phone <input type="text" name="homephone" />
            <br />
            Mobile phone <input type="text" name="mobilephone" />
            <br />
            Office phone <input type="text" name="officephone" />
            <br />
            Address <input type="text" name="address" />
            <br /> 
            Postal code <input type="text" name="postalcode" />
            <br />
            City <input type="text" name="city" />
            <br />    
            Email <input type="text" name="email" />
            <br />
            <input type="submit" name="action" value="SaveEmployee" /> 
            <input type="submit" name="action" value="Cancel" />
        </form>
    </body>
</html>
