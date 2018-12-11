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
        <table>
            <tr>
                <td>NAME</td>
                <td>FIRST NAME</td>
                <td>HOME PHONE</td>
                <td>MOBILE PHONE</td>
                <td>OFFICE PHONE</td>
                <td>ADDRESS</td>
                <td>POSTAL CODE</td>
                <td>CITY</td>
                <td>EMAIL</td>
            </tr>

            <c:forEach items="${employeesList}" var="emp">
                <tr>
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
    </body>
</html>
