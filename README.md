# JEE Project
By <br>
Guillaume Billès | Guillaume Farge | Morgan Wolf | Vincent Roche | Claire Huang<br>

<h1>Application features</h1>

<b>Login Page</b><br>
- Connection of a user <br>
- Error message if incorrect login or password <br>
- Error if login or password not entered <br>

<b>The default login : admin | password : admin</b>

<b>Employees List Page</b><br>
1) A click on Delete will remove the selected member from the database and will reload the updated list of employees<br>
2) A selection of one member and a click on Details will send the user to the Member details page<br>
3) A click on Add will redirect the user to an empty Member details page<br>
4) If you delete all the members the following message is displayed (in blue & bold) : The club has no member!<br> 

<b>Employees Details Page</b><br>
1) A click on Save will update the information about the current member and will redirect to the list page<br>
2) A click on Cancel will redirect to the list page without updating information about the current member<br>

<b>General functionalities</b>
<br>On the upper right of each page (except the login page obviously) show: <br>
1) "Your session is active" <br>
2) The icon that allows the user to logout (leave the session)<br>
<br>

1. Good bye page<br>
2. Constants are in the utils folder, in the file Constants.java<br>
3. Our database if configured as <br>
Base : PROJET<br>
User : adm<br>
Password : adm<br>
4) We have a script with 10 employees<br>

<h1>Version 1 (https://github.com/VincentRoche/JEE)</h1>
<h2>How to launch Version 1?</h2>
After cloning the project from this address : https://github.com/VincentRoche/JEE.git<br>
Step 1 : Create a JavaDB database (name=PROJET, username=adm, password=adm)<br>
Step 2 : Fill the database by executing sqlScript.sql (https://github.com/VincentRoche/JEE/blob/master/web/WEB-INF/sqlScript.sql)<br>
Step 2 : Clean and build the project<br>
Step 3 : Run the project

<h2>Features</h2>
In this version, you have the following features: <br>
o JSP (scriptlets accepted) + Java Beans + Servlet + JDBC<br>
o db.properties file to store information about the database <br>
o SQL script in /WEB-INF<br>
o All the JSPs in /WEB-INF <br>
o SGBD = Java DB<br>

<h3>Jsp, java beans, servlet, jdbc</h3>
Jsp are located in the web/WEB-INF folder<br>
Java beans are located in the jee/model folder<br>
In this version, the database used is JavaDB from NetBeans
<h3>db.properties</h3>
db.properties file is located in the src/java/utils folder<br>


<h1>Version 2 (this one)</h1>
<h2>How to launch Version 2?</h2>
After cloning the project from this address : https://github.com/ClaireH97/JEE2.git<br>
Step 1 : create a MySQL database named "PROJET"<br>
Step 2 : create an user "adm" with password "adm" (if you want to use different credentials, edit WEB-INF/glassfish-resources.xml)<br>
Step 3 : execute the SQL script to fill the database (https://github.com/ClaireH97/JEE2/blob/master/MavenPROJECT/src/main/webapp/WEB-INF/mysqlScript.sql)<br>
Step 4 : Clean and build the project<br>
Step 5 : Run the project

<h2>Features</h2>
In this version, you have the following features:<br>
o Maven project <br>
o JSP (EL et JSTL only / no Java code in JSPs)<br>
o Java Beans <br>
o Servlet <br>
o Persistance with JPA<br>
o SGBD : MySQL <br>
o Continuous delivery pipeline with Jenkins using that version<br>

<h3>Maven project :</h3>
This project has been created as a Maven Project in order to have a build automation.<br>
Maven project is a little bit different compared to a webApplication.<br>
Indeed, here, we can see how the software is built and all its dependencies (in Pom.xml).<br>

<h3>JSP, java server pages</h3>
In order to give access to the user to the different contents of our web application, all the pages are .jsp are presented in the WEB-INF folder.

<h3>JavaBeans</h3>
In order to respect the MVC model, you can find our javaBeans in the source package, folder : group2jee.projet2.jee.<b>model</b>

<h3>Servlet</h3>
Those servlet, will help us to treat the request and redirect the client through the different JSP 

<h3>Persistance with JPA </h3>
You can find our Persistance file at this path : src/main/resources/META-INF<br>
This Persistance file will be used by EmployeesSessionBean.java<br>

<h3>SGBD : MySQL</h3>
In order to use the MySQL Connection, please follow steps 1 and 2 above. <br>
If you check your Glassfish-ressources.xml, you will see the new jdbc connection pool that we have created in order to connect this maven project to MySQL (all params are here).

<h3>Continuous delivery pipeline with Jenkins</h3>
Please follow the different steps presented in the file <b>"How to create the pipeline.pdf" (https://github.com/ClaireH97/JEE2/blob/master/How%20to%20create%20the%20pipeline.pdf)</b>
