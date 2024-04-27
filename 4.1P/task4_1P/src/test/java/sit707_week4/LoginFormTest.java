package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s220459698";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "DILUM";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		//1
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
	
	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCarValCode()
    {
		//2
		LoginStatus status = LoginForm.login(null, "123");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCarValCode()
    {
		//3
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
	
	@Test
	public void testFailWrongUsernameAndEmptyPasswordAndDontCarValCode()
    {
		//4
		LoginStatus status = LoginForm.login("abc", "");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Empty Password", status.getErrorMsg());
    }
	
	@Test
	public void testFailWrongUsernameAndWrongPasswordAndDontCarValCode()
    {
		//5
		LoginStatus status = LoginForm.login("abc", "123");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCarValCode()
    {
		//6
		LoginStatus status = LoginForm.login("ABC", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCarValCode()
    {
		//7
		LoginStatus status = LoginForm.login("ahsan", "");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Empty Password", status.getErrorMsg());
    }
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCarValCode()
    {
		//8
		LoginStatus status = LoginForm.login("ahsan", "123");
		Assert.assertTrue( status.isLoginSuccess() == false );
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
	@Test
	public void testPassCorrectUsernameAndCorrectPasswordAndReturncorrectValCode()
    {
		//9
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == true );
		//Assert.assertEquals("Credential mismatch", status.getErrorMsg());
		  Assert.assertTrue(status.getErrorMsg().contains("123456")); // Assuming validation code is "123456"
    }
	
	// testing for validatecode
	  @Test
	  public void testValidateCodeEmpty() {
	    Assert.assertFalse(LoginForm.validateCode(null));
	  }

	  @Test
	  public void testValidateCodeWrong() {
	    Assert.assertFalse(LoginForm.validateCode("abcd"));
	  }

	  @Test
	  public void testValidateCodeCorrect() {
	    LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
	    String validationCode = status.getErrorMsg(); // Assuming validation code is retrieved from errorMsg
	    Assert.assertTrue(LoginForm.validateCode(validationCode));
	  }
	
}
