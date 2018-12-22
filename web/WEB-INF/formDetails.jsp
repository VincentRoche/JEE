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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <title>Add employee</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            
            <div class="card">
                <div class="card-header">Employee</div>
                <div class="card-body">
                    <form name="loginFrm" action="Controller" method="post">
                        <input type="hidden" name="id" class="form-control" value="${emp.id}"/>
                        Name <input type="text" name="name" class="form-control" value="${emp.name}"/>
                        First name <input type="text" name="firstname" class="form-control" value="${emp.firstname}"/>
                        Home phone <input type="text" name="homephone" class="form-control" value="${emp.telhome}"/>
                        Mobile phone <input type="text" name="mobilephone" class="form-control" value="${emp.telmob}"/>
                        Office phone <input type="text" name="officephone" class="form-control" value="${emp.telpro}"/>
                        Address <input type="text" name="address" class="form-control" value="${emp.address}"/>
                        Postal code <input type="text" name="postalcode" class="form-control" value="${emp.postalcode}"/>
                        City <input type="text" name="city" class="form-control" value="${emp.city}"/>
                        Email <input type="text" name="email" class="form-control" value="${emp.email}"/>
                        <input type="submit" name="action" value="SaveEmployee" class="btn btn-primary"/> 
                        <input type="submit" name="action" value="Cancel" class="btn btn-danger"/>
                    </form>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
