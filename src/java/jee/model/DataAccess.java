/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;

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
        try {
            Properties prop = new Properties();
            InputStream input;
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            input = cl.getResourceAsStream(Constants.PATH_PROPERTIES_FILE);
            prop.load(input);
            
            dbUrl = prop.getProperty(Constants.DB_URL);
            user = prop.getProperty(Constants.DB_USER);
            pwd = prop.getProperty(Constants.DB_PWD);

            dbConn = DriverManager.getConnection(dbUrl, user, pwd);

        } catch (SQLException | IOException ex) {
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbConn;

    }

    public Statement getStatement(Connection dbConn) {
        try {
            stmt = dbConn.createStatement();
        } catch (SQLException ex) {
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmt;
    }

    public ResultSet getResultSet(Statement stmt, String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ArrayList getEmployees(ResultSet rs) {
        employeesList = new ArrayList<>();
        try {
            while (rs.next()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setName(rs.getString("NAME"));
                employeesList.add(employee);
            }
        } catch (SQLException ex) {
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeesList;
    }

    public String showEmployees(ArrayList<EmployeeBean> employeesList) {
        String output = "";
        for (EmployeeBean empl : employeesList) {
            output = output + empl.getFirstName() + "  -  " + empl.getName() + "<br/>";
        }
        return output;

    }
    
    public void deleteEmployees(int emplId){
        // TODO : delete the empl from the db
        
    }

    public ArrayList getUsers(ResultSet rs) {
            usersList = new ArrayList<>();
        try {
            while (rs.next()) {
                User u = new User();
                u.setLogin(rs.getString("LOGIN"));
                u.setPwd(rs.getString("PWD"));
                usersList.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    
}
