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
import java.sql.ResultSet;
import java.sql.Statement;
import jee.model.EmployeeBean;

public class Controller extends HttpServlet {
    
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
        
        // To be able to use the "session" object like we did in the JSPs
        HttpSession session = request.getSession();
        db = new DataAccess();
        Connection connection = db.getConnection();
        Statement statement = db.getStatement(connection);
        queryEmployees = Constants.QUERY_SELECT_EMPLOYEES;
        queryUser = Constants.QUERY_SELECT_CREDENTIALS;
        ResultSet rs = db.getResultSet(statement, queryUser);
        listUsers = db.getUsers(rs);
        
        
        
        // User input
        String loginEntered = request.getParameter(Constants.LOGIN_FIELD);
        String pwdEntered = request.getParameter(Constants.PWD_FIELD);
        
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        
        // Compare credentials only if the user has entered something in the login form
        if (loginEntered != null && pwdEntered != null) {
            // Error if one of the fields is empty
            if (loginEntered.isEmpty() || pwdEntered.isEmpty()) {
                request.setAttribute(Constants.REQUEST_LOGIN_ERROR, Constants.ERROR_LOGIN_EMPTY);
                // Forwarded to index page later
            }
            else {
                boolean ok = false;
                // Searching credentials...
                for (User u : listUsers) {
                    // If the credentials are correct
                    if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPwd())) {
                        // create the user
                        user = new User();
                        user.setLogin(loginEntered);
                        user.setPwd(pwdEntered);
                        
                        // add it to the session
                        session.setAttribute(Constants.SESSION_USER, user);
                        
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    // Credentials not found or incorrect
                    request.setAttribute(Constants.REQUEST_LOGIN_ERROR, Constants.ERROR_LOGIN_FAILED);
                    // Forwarded to index page later
                }
            }
        }
        
        if (user == null) {
            // User redirected to login page if they are not logged in
            request.getRequestDispatcher(Constants.INDEX_PAGE).forward(request, response);
        }
        else // If the user is logged in
        {
            // User connected and on welcome page maybe (or on details)
            
            String action = request.getParameter(Constants.REQUEST_ACTION);
            boolean forwarded = false; // If false at the end, the welcome page will be displayed
            
            // If a form button was pressed
            if (action != null) switch (action) {
                
                //delete button was pressed
                case Constants.ACTION_DELETE:
                    int radioButton = Integer.parseInt(request.getParameter(Constants.REQUEST_RADIOS)); // you get the emplId in the button value
                    db.deleteEmployee(radioButton); // remove from db
                    break;
                    
                    //add button was pressed
                case Constants.ACTION_ADD:
                    add(request, response);
                    forwarded = true;
                    break;
                    
                    //details button was pressed
                case Constants.ACTION_DETAILS:
                    int radioButton1 = Integer.parseInt(request.getParameter(Constants.REQUEST_RADIOS)); // you get the emplId in the button value
                    
                    for (EmployeeBean e : listEmployees) {
                        if (e.getId() == radioButton1)
                        {
                            request.setAttribute(Constants.REQUEST_EMPLOYEE, e);
                            
                            break;
                        }
                    }
                    add(request, response);
                    forwarded = true;
                    break;
                    
                    //save button was pressed in the details page
                case Constants.ACTION_SAVE:
                    // Get form values
                    String id = request.getParameter(Constants.REQUEST_ID);
                    String name = request.getParameter(Constants.REQUEST_NAME);
                    String firstName = request.getParameter(Constants.REQUEST_FIRSTNAME);
                    String homePhone = request.getParameter(Constants.REQUEST_HOMEPHONE);
                    String mobilePhone = request.getParameter(Constants.REQUEST_MOBILEPHONE);
                    String officePhone = request.getParameter(Constants.REQUEST_OFFICEPHONE);
                    String address = request.getParameter(Constants.REQUEST_ADDRESS);
                    String postalCode = request.getParameter(Constants.REQUEST_POSTALCODE);
                    String city = request.getParameter(Constants.REQUEST_CITY);
                    String email = request.getParameter(Constants.REQUEST_EMAIL);
                    
                    // If it is an update of an existing employee
                    if (!id.isEmpty()) {
                        db.updateEmployee(id, name, firstName, homePhone, mobilePhone, officePhone, address, postalCode, city, email);
                    }
                    // If it is a new employee
                    else {
                        db.addEmployee(name, firstName, homePhone, mobilePhone, officePhone, address, postalCode, city, email);
                    }
                    
                    
                    break;
                    
                    //logout link was pressed
                case Constants.ACTION_LOGOUT:
                    session.removeAttribute(Constants.SESSION_USER); // Deleting user session
                    request.getRequestDispatcher(Constants.GOODBYE_PAGE).forward(request, response);
                    forwarded = true;
                    
                    break;
                    
                    //someone has altered the HTML and sent a different value!
                default:
                    break;
            }
            
            // If the user has not been forwarded yet, we display the welcome page (employee list)
            if (!forwarded) {
                listEmployees = db.getEmployees(db.getResultSet(statement, queryEmployees)); // Updating employee list
                request.setAttribute(Constants.REQUEST_EMPLOYEELIST, listEmployees);
                request.getRequestDispatcher(Constants.WELCOME_PAGE).forward(request, response);
            }
        }
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
