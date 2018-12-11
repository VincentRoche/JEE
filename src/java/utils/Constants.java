/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Jacques
 */
public class Constants {

    //Constantes related to the properties file
    public static final String PATH_PROPERTIES_FILE = "utils/db.properties";
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PWD = "dbPwd";

    public static final String LOGIN_FIELD = "loginField";
    public static final String PWD_FIELD = "pwdField";
    
    public static final String ERROR_LOGIN_EMPTY = "You must enter values in both fields";
    public static final String ERROR_LOGIN_FAILED = "Connection failed! Verify your login/password and try again.";

    public static final String INDEX_PAGE = "WEB-INF/login.jsp";
    public static final String WELCOME_PAGE = "WEB-INF/welcome.jsp";
}
