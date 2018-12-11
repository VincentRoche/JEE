<%-- 
    Document   : welcome
    Created on : 26 oct. 2018, 15:41:04
    Author     : Jacques
--%>

<%@page import="jee.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EmployeesScriptlets - Welcome</title>
    </head>
    <body>
        <h1> My Employees!</h1>

        
        

        

        <form action="">

            <table border="1">
                <tbody>
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
       
                    <c:forEach items="${employeesList}" var= "emp" >
                        
                        <tr> 
                            <td>  <input type="radio" name="radios" value="" checked=""></td>
                            <td><strong> <c:out value="${emp.name}" /></strong> </td>
                            <td><c:out value="${emp.firstName}" /></td>
                            <td><c:out value="${emp.homePhone}" /></td>
                            <td><c:out value="${emp.mobilePhone}" /></td>
                            <td><c:out value="${emp.officePhone}" /></td>
                            <td><c:out value="${emp.adress}" /></td>
                            <td><c:out value="${emp.postalCode}" /></td>
                            <td><c:out value="${emp.city}" /></td>
                            <td><c:out value="${emp.email}" /></td>
                            
                        </tr> 
                    </c:forEach>
                       

               
                </tbody>
            </table>
            <input type="submit" name="action" value="Detail">
			<input type="submit" name="action" value="Update">
            <input type="submit" name="action" value="Delete">
            
        </form>
   
        
        

        <%

            // User myUser = (User)session.getAttribute("keyUser");
            //User myUser = (User)session.getAttribute("userBean");
//            out.println("LOGIN      :     " + myUser.getLogin());
//            out.println("PASSWORD      :     " + myUser.getPwd());

        %>


    </body>
</html>
