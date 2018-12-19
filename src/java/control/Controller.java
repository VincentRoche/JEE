/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.DataAccess;
import jee.model.User;
import utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jee.model.EmployeeBean;

/**
 *
 * @author Jacques
 */
public class Controller extends HttpServlet {

    //@EJB
    //private EmployeesSessionBean employeesSessionBean;

    ArrayList<EmployeeBean> listEmployees;
    ArrayList<User> listUsers;
    DataAccess db;
    String queryEmployees;
    String queryUser;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //To be able to use the "session" object like we did in the JSPs
        HttpSession session = request.getSession();
        db = new DataAccess();
        Connection connection = db.getConnection();
        Statement statement = db.getStatement(connection);
        queryUser = "SELECT LOGIN,PASSWORD FROM CREDENTIALS";
        ResultSet rs = db.getResultSet(statement, queryUser);
        listUsers = db.getUsers(rs);



        // User input
        String loginEntered = request.getParameter(Constants.LOGIN_FIELD);
        String pwdEntered = request.getParameter(Constants.PWD_FIELD);

        User user = null;
        user = (User)session.getAttribute("user");

        
        //Compare credentials only if the user has entered something
        if (loginEntered != null && pwdEntered != null) {
            if (loginEntered.isEmpty() || pwdEntered.isEmpty()) {
                request.setAttribute("loginError", Constants.ERROR_LOGIN_EMPTY);
                request.getRequestDispatcher(Constants.INDEX_PAGE).forward(request, response);
            }
            else {
                boolean ok = false;
                for (User u : listUsers) {

                    if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPwd())) {
                        // create the user
                        user = new User();
                        user.setLogin(loginEntered);
                        user.setPwd(pwdEntered);
                        
                        // add it to the session
                        session.setAttribute("user", user);
                        
                        /*listEmployees = new ArrayList<>();
                        listEmployees.addAll(employeesSessionBean.getEmployees());*/
                        
                        queryEmployees = "Select ID, NAME, FIRSTNAME from Employees";
                        ResultSet rs1 = db.getResultSet(statement, queryEmployees);
                        listEmployees = db.getEmployees(rs1);

                        // Store the list of employees in a scope object
                        session.setAttribute("employeesList", listEmployees);

                        request.getRequestDispatcher(Constants.WELCOME_PAGE).forward(request, response);
                        
                        
                        
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    request.setAttribute("loginError", Constants.ERROR_LOGIN_FAILED);
                    request.getRequestDispatcher(Constants.INDEX_PAGE).forward(request, response);
                }
            }
        }
        
        if (user == null) { 
            System.out.print("User null");
            request.getRequestDispatcher(Constants.INDEX_PAGE).forward(request, response);
        }
        else {   // connected and on welcome page maybe (or on add)
            String action = request.getParameter("action");
            
            if (action == null) {
                //no button has been selected
                System.out.print("no button test");
                
            } else switch (action) {
            //delete button was pressed
                case "Delete":
                    int radioButton = Integer.parseInt(request.getParameter("radios")); // you get the emplId in the button value
                    //DEBUG:
                    System.out.print("radioButton:" + radioButton);
                    db.deleteEmployee(radioButton); // remove from db
                    for (EmployeeBean e : listEmployees) {
                        if (e.getId() == radioButton)
                        {
                            listEmployees.remove(e); // remove from current list
                            break;
                        }
                    }
                    
                    System.out.print("delete test");
                    break;
            //add button was pressed
                case "Add":
                    add(request, response);
                    break;
            //add button was pressed
                case "Details":
                    int radioButton1 = Integer.parseInt(request.getParameter("radios")); // you get the emplId in the button value
                   
                    for (EmployeeBean e : listEmployees) {
                        if (e.getId() == radioButton1)
                        {
                            request.setAttribute("emp", listEmployees.get(e.getId()-1));
                            request.setAttribute("firstname", listEmployees.get(e.getId()-1));
                            
                            break;
                        }
                    }
                    add(request, response);
                    
                    
                    System.out.print("details test");
                    
                    
                    
                    break;
                case "SaveEmployee":
                    String name = request.getParameter("name");
                    String firstName = request.getParameter("firstname");
                    String homePhone = request.getParameter("homephone");
                    String mobilePhone = request.getParameter("mobilephone");
                    String officePhone = request.getParameter("officephone");
                    String address = request.getParameter("address");
                    String postalCode = request.getParameter("postalcode");
                    String city = request.getParameter("city");
                    String email = request.getParameter("email");
                    db.addEmployee(name, firstName, homePhone, mobilePhone, officePhone, address, postalCode, city, email);
                    
                    queryEmployees = "Select ID, NAME, FIRSTNAME from Employees";
                    ResultSet rs1 = db.getResultSet(statement, queryEmployees);
                    listEmployees = db.getEmployees(rs1);
                   
                    break;
            //someone has altered the HTML and sent a different value!
                default:
                    System.out.print("default test");
                    break;
            }
            
            request.getRequestDispatcher(Constants.WELCOME_PAGE).forward(request, response);
        }
        
        //TODO : when users disconnects need to delete "user" in the session

    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher(Constants.FORM_DETAILS_PAGE).forward(request, response);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
