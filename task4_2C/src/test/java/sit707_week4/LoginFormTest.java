package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224791713";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Emmalu Joseph";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse("Login should fail for empty username and password", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameOnly() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse("Login should fail for empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyPasswordOnly() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse("Login should fail for empty password", status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testInvalidUsernameValidPassword() {
        LoginStatus status = LoginForm.login("wronguser", "ahsan_pass");
        Assert.assertFalse("Login should fail for wrong username", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongpass");
        Assert.assertFalse("Login should fail for wrong password", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        LoginStatus status = LoginForm.login("user", "pass");
        Assert.assertFalse("Login should fail for invalid credentials", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testValidUsernameAndPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Login should succeed with correct credentials", status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg()); // This is actually the validation code
    }

    @Test
    public void testValidationCodeEmpty() {
        Assert.assertFalse("Validation should fail for empty code", LoginForm.validateCode(null));
    }

    @Test
    public void testValidationCodeInvalid() {
        Assert.assertFalse("Validation should fail for wrong code", LoginForm.validateCode("wrong"));
    }

    @Test
    public void testValidationCodeValid() {
        Assert.assertTrue("Validation should pass for correct code", LoginForm.validateCode("123456"));
    }
}
