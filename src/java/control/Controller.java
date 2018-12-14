/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.Credentials;
import jee.model.DataAccess;
import jee.model.Employees;
import jee.model.EmployeesSessionBean;
import jee.model.User;
import utils.Constants;

/**
 *
 * @author Jacques
 */
public class Controller extends HttpServlet {

    @EJB
    private EmployeesSessionBean employeesSessionBean;

    ArrayList<Employees> listEmployees;
    ArrayList<Credentials> listUsers;
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

        // Credentials retrieved from the database
        listUsers = new ArrayList<>();
        listUsers.addAll(employeesSessionBean.getUsers());

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
                for (Credentials u : listUsers) {

                    if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPassword())) {
                        // create the user
                        user = new User();
                        user.setLogin(loginEntered);
                        user.setPwd(pwdEntered);
                        
                        // add it to the session
                        session.setAttribute("user", user);
                        
                        listEmployees = new ArrayList<>();
                        listEmployees.addAll(employeesSessionBean.getEmployees());

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
        
        if(user == null){ 
            System.out.print("User null");
            request.getRequestDispatcher(Constants.INDEX_PAGE).forward(request, response);
        }
        else{   // connected and on welcome page maybe (or on add)
            String action = request.getParameter("action");
            
            if (action == null) {
                //no button has been selected
                System.out.print("no button test");
                
            } else switch (action) {
            //delete button was pressed
                case "Delete":
                    String radioButton = request.getParameter("radios"); // you get the emplId in the button value
                    // TODO : delete the empl from the db
                    System.out.print("delete test");
                    break;
            //add button was pressed
                case "Add":
                    System.out.print("update test");
                    break;
            //add button was pressed
                case "Details":
                    System.out.print("details test");
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
