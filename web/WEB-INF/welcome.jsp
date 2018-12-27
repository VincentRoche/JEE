<%-- 
    Document   : welcome
    Created on : 26 oct. 2018, 15:41:04
    Author     : Jacques
--%>

<%@page import="jee.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Employees - Welcome</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <div class="container">
            
            <h1>List of Employees</h1>
            <form method="POST" action="">
                
                <!-- Error message if the list is empty, otherwise display the list. -->
                <c:choose>
                    <c:when test="${fn:length(employeeList) eq 0}">
                        <p style="color: blue; font-weight: bold">The club has no member!</p>
                    </c:when>
                    <c:otherwise>
                        
                        <table class="table table-striped">
                            
                            <tr>
                                <td><b>Detail</b></td>
                                <td><b>Name</b></td>
                                <td><b>First name</b></td>
                                <td><b>Home phone</b></td>
                                <td><b>Mobile phone</b></td>
                                <td><b>Office phone</b></td>
                                <td><b>Address</b></td>
                                <td><b>Postal code</b></td>
                                <td><b>City</b></td>
                                <td><b>Email</b></td>
                            </tr>
                            
                            <c:forEach items="${employeeList}" var="emp">
                                <tr>
                                    <td>  <INPUT TYPE="radio" NAME='radios' VALUE="${emp.id}" checked /></td>
                                    <td><c:out value="${emp.name}"/></td>
                                    <td><c:out value="${emp.firstname}"/></td>
                                    <td><c:out value="${emp.telhome}"/></td>
                                    <td><c:out value="${emp.telmob}"/></td>
                                    <td><c:out value="${emp.telpro}"/></td>
                                    <td><c:out value="${emp.address}"/></td>
                                    <td><c:out value="${emp.postalcode}"/></td>
                                    <td><c:out value="${emp.city}"/></td>
                                    <td><c:out value="${emp.email}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        
                        <input type='submit' name="action" value="Delete" action="Controller" class="btn btn-danger"/>
                        <input type='submit' name="action" value="Details" action="Controller" class="btn btn-info"/>
                    </c:otherwise>
                </c:choose>
                <input type='submit' name="action" value="Add" action="Controller" class="btn btn-primary"/>
                
            </form>
        </div>
    </body>
</html>
