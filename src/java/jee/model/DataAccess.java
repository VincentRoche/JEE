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
                employee.setId(rs.getInt("ID"));
                employee.setName(rs.getString("NAME"));
                employee.setFirstname(rs.getString("FIRSTNAME"));
                employee.setTelhome(rs.getString("TELHOME"));
                employee.setTelmob(rs.getString("TELMOB"));
                employee.setTelpro(rs.getString("TELPRO"));
                employee.setAddress(rs.getString("ADRESS"));
                employee.setPostalcode(rs.getString("POSTALCODE"));
                employee.setCity(rs.getString("CITY"));
                employee.setEmail(rs.getString("EMAIL"));
                
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
            output = output + empl.getFirstname() + "  -  " + empl.getName() + "<br/>";
        }
        return output;
    }
    
    public  void addEmployee(String name, String firstName, String homePhone, String mobilePhone, String officePhone, String address, String postalCode, String city, String email)
    {
        String query = "INSERT INTO EMPLOYEES (NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) VALUES ('" + name + "', '" + firstName + "', '" + homePhone + "', '" + mobilePhone + "', '" + officePhone + "', '" + address + "', '" + postalCode + "', '" + city + "', '" + email + "')";
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateEmployee(String id, String name, String firstName, String homePhone, String mobilePhone, String officePhone, String address, String postalCode, String city, String email) {
        String query = "UPDATE EMPLOYEES SET NAME = '" + name + "', FIRSTNAME = '" + firstName + "', TELHOME = '" + homePhone + "', TELMOB = '" + mobilePhone + "', TELPRO = '" + officePhone + "', ADRESS = '" + address + "', POSTALCODE = '" + postalCode + "', CITY = '" + city + "', EMAIL = '" + email + "' WHERE ID =" + id;
        try {
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteEmployee(int emplId) {
        DataAccess db = new DataAccess();
        String queryDelete = "DELETE from EMPLOYEES WHERE ID=" + emplId ;
        
        try {
            // execute the query
            db.getStatement(db.getConnection()).executeUpdate(queryDelete);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getUsers(ResultSet rs) {
        usersList = new ArrayList<>();
        try {
            while (rs.next()) {
                User u = new User();
                u.setLogin(rs.getString("LOGIN"));
                u.setPwd(rs.getString("PASSWORD"));
                usersList.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
}
