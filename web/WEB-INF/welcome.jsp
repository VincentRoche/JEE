<%-- 
    Document   : welcome
    Created on : 26 oct. 2018, 15:41:04
    Author     : Jacques
--%>

<%@page import="jee.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees(JPA) - Welcome</title>
    </head>
    <body>
        <h1> My JPA Employees</h1>
        <form action="">

            <table border = 1>

                <tr>
                    <td><b>Detail</b></td>
                    <td><b>Name</b></td>
                    <td><b>First name</b></td>
                    <td><b>Home phone</b></td>
                    <td><b>Mobile phone</b></td>
                    <td><b>Office phone</b></td>
                    <td><b>Adress</b></td>
                    <td><b>Postal code</b></td>
                    <td><b>City</b></td>
                    <td><b>Email</b></td>
                </tr>

                <c:forEach items="${employeesList}" var="emp">
                    <tr>
                        <td>  <INPUT TYPE="radio" NAME='radios' VALUE="" CHECKED ></td>
                        <td><c:out value="${emp.name}"/></td>
                        <td><c:out value="${emp.firstname}"/></td>
                        <td><c:out value="${emp.telhome}"/></td>
                        <td><c:out value="${emp.telmob}"/></td>
                        <td><c:out value="${emp.telpro}"/></td>
                        <td><c:out value="${emp.adress}"/></td>
                        <td><c:out value="${emp.postalcode}"/></td>
                        <td><c:out value="${emp.city}"/></td>
                        <td><c:out value="${emp.email}"/></td>
                    </tr>
                </c:forEach>
            </table>
            
            <input type='submit' name="action" value="Delete"/>
            <input type='submit' name="action" value="Details"/>
            <input type='submit' name="action" value="Add"/>
            
        </form>

    </body>
</html>
