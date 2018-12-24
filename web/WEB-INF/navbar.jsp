<%-- 
    Document   : navbar
    Created on : 24 déc. 2018, 03:14:13
    Author     : Vincent
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="Controller">Employee management</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="Controller">Employee list</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a>Your session is active</a></li>
            <li><a href="Controller?action=Logout"><span class="glyphicon glyphicon-off"></span> Logout</a></li>
        </ul>
    </div>
</nav>