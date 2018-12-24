package utils;

public class Constants {

    //Constantes related to the properties file
    public static final String PATH_PROPERTIES_FILE = "utils/db.properties";
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PWD = "dbPwd";
    
    public static final String QUERY_SELECT_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String QUERY_UPDATE_EMPLOYEE = "";
    public static final String QUERY_DELETE_EMPLOYEE = "";
    public static final String QUERY_SELECT_CREDENTIALS = "SELECT LOGIN, PASSWORD FROM CREDENTIALS";
    
    public static final String SESSION_USER = "user";
    
    public static final String REQUEST_EMPLOYEELIST = "employeeList";
    public static final String REQUEST_LOGIN_ERROR = "loginError";
    public static final String REQUEST_ACTION = "action";
    public static final String REQUEST_RADIOS = "radios";
    public static final String REQUEST_EMPLOYEE = "emp";
    public static final String REQUEST_ID = "id";
    public static final String REQUEST_NAME = "name";
    public static final String REQUEST_FIRSTNAME = "firstname";
    public static final String REQUEST_HOMEPHONE = "homephone";
    public static final String REQUEST_MOBILEPHONE = "mobilephone";
    public static final String REQUEST_OFFICEPHONE = "officephone";
    public static final String REQUEST_ADDRESS = "address";
    public static final String REQUEST_POSTALCODE = "postalcode";
    public static final String REQUEST_CITY = "city";
    public static final String REQUEST_EMAIL = "email";
    
    public static final String ACTION_DELETE = "Delete";
    public static final String ACTION_ADD = "Add";
    public static final String ACTION_DETAILS = "Details";
    public static final String ACTION_SAVE = "SaveEmployee";
    public static final String ACTION_LOGOUT = "Logout";

    public static final String LOGIN_FIELD = "loginField";
    public static final String PWD_FIELD = "pwdField";
    
    public static final String ERROR_LOGIN_EMPTY = "You must enter values in both fields";
    public static final String ERROR_LOGIN_FAILED = "Connection failed! Verify your login/password and try again.";

    public static final String INDEX_PAGE = "WEB-INF/login.jsp";
    public static final String WELCOME_PAGE = "WEB-INF/welcome.jsp";
    public static final String FORM_DETAILS_PAGE = "WEB-INF/formDetails.jsp";
    public static final String GOODBYE_PAGE = "WEB-INF/goodbye.jsp";
}
