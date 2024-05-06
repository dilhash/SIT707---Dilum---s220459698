
package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testLoginSuccessful() {
        Assert.assertTrue(LoginService.login("dilum", "dilum_pass", "2000-11-13"));
    }

    @Test
    public void testLoginNullUsername() {
    	Assert.assertFalse(LoginService.login(null, "dilum_pass", "2000-11-13"));
    }

    @Test
    public void testLoginEmptyUsername() {
        Assert.assertFalse(LoginService.login("", "dilum_pass", "2000-11-13"));
    }

    @Test
    public void testLoginNullPassword() {
        Assert.assertFalse(LoginService.login("dilum", null, "2000-11-13"));
    }

    @Test
    public void testLoginEmptyPassword() {
        Assert.assertFalse(LoginService.login("dilum", "", "2000-11-13"));
    }

    @Test
    public void testLoginNullDob() {
        Assert.assertFalse(LoginService.login("dilum", "dilum_pass", null));
    }

    @Test
    public void testLoginInvalidDobFormat() {
        Assert.assertFalse(LoginService.login("dilum", "dilum_pass", "11-11-2000"));
    }

    @Test
    public void testLoginWrongCredentials() {
        Assert.assertFalse(LoginService.login("invalid_user", "wrong_password", "2000-11-13"));
    }
}
