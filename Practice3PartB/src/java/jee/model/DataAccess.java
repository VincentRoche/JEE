/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacques
 */
public class DataAccess {

    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    private String dbUrl;
    private String user;
    private String pwd;
    private ArrayList<EmployeeBean> employeesList;
    private ArrayList<User> usersList;

    public Connection getConnection() {
        //try {
            
            dbUrl = "jdbc:derby://localhost:1527/JEEDB";
            user = "jee";
            pwd = "jee";
            
            /*
            //TODO: put a class loader ressource
            InputStream db = new InputStream("Utils/db.properties");
            Properties p = new Properties();
            p.load(db);
            dbUrl = p.getProperty("dbUrl");
            user = p.getProperty("user");
            pwd = p.getProperty("pwd");

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
        

        try {

            dbConn = DriverManager.getConnection(dbUrl, user, pwd);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return dbConn;
    }

    public Statement getStatement(Connection dbConn) {
        try {
            stmt = dbConn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return stmt;

    }

    public ResultSet getResultSet(Statement stmt, String query) {

        try {
            rs = stmt.executeQuery(query);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return rs;

    }

    public ArrayList getEmployees(ResultSet rs) {
        employeesList = new ArrayList<EmployeeBean>();
        try {
            while (rs.next()) {
                EmployeeBean employee = new EmployeeBean();
                
                employee.setName(rs.getString("NAME"));
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setHomePhone(rs.getString("TELHOME"));
                employee.setMobilePhone(rs.getString("TELMOB"));
                employee.setOfficePhone(rs.getString("TELPRO"));
                employee.setAdress(rs.getString("ADRESS"));
                employee.setPostalCode(rs.getString("POSTALCODE"));
                employee.setCity(rs.getString("CITY"));
                employee.setEmail(rs.getString("EMAIL"));
                
                employeesList.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return employeesList;
    }

    public String showEmployees(ArrayList<EmployeeBean> employeesList) {
           String output = "";
        for (EmployeeBean empl : employeesList) {
            output = output + empl.getFirstName() + "  -  "+empl.getName() + "<br/>";
        }
        
        return output;

    }
    
        public ArrayList getUsers(ResultSet rs) {
        usersList = new ArrayList<User>();
        try {
            while (rs.next()) {
                User u = new User();
                u.setLogin(rs.getString("LOGIN"));
                u.setPwd(rs.getString("PWD"));
                usersList.add(u);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return usersList;
    }

}
