package web.service;

import java.util.regex.Pattern;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {


  /**
   * Static method returns true for successful login, false otherwise.
   * @param username
   * @param password
   * @param dob (format mm/dd/yyyy)
   * @return
   */
  public static boolean login(String username, String password, String dob) {
    // Validate username, password and dob format
    if (!isValidUsername(username) || !isValidPassword(password) || !isValidDob(dob)){
      return false;
    }
    
    // Implement your actual authentication logic here (replace this with your database check)
    if ("dilum".equals(username) && "dilum_pass".equals(password)) {
      return true;
    }
    
    return false;
  }

  private static boolean isValidUsername(String username) {
    
    return username != null && username.trim().length() > 0;
  }

  private static boolean isValidPassword(String password) {
  
    return password != null && password.trim().length() > 0;
  }

  private static boolean isValidDob(String dob) {
	  String dobRegex = "^(\\d{4})-(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[01])$";
	  return dob != null && dob.matches(dobRegex);
	}


}