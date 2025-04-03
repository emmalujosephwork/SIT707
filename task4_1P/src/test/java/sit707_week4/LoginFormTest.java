package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Emmalu Joseph
 */
public class LoginFormTest {

    // Test for student identity (Make sure the student ID and name are not null)
    @Test
    public void testStudentIdentity() {
        String studentId = "224791713";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    // Test for student name (Make sure the student name is not null)
    @Test
    public void testStudentName() {
        String studentName = "Emmalu Joseph";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Test case for empty username and empty password (Don't care about validation code)
    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertTrue("Login should fail for empty username and password", !status.isLoginSuccess());
        Assert.assertEquals("Error message should be 'Empty Username'", "Empty Username", status.getErrorMsg());
    }

    // Test case for wrong username and correct password (Don't care about validation code)
    @Test
    public void testWrongUsernameCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("emmalujoseph", "emmalu_pass");
        Assert.assertTrue("Login should fail for wrong username", !status.isLoginSuccess());
        Assert.assertEquals("Error message should be 'Credential mismatch'", "Credential mismatch", status.getErrorMsg());
    }

    // Test case for correct username and wrong password (Don't care about validation code)
    @Test
    public void testCorrectUsernameWrongPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("emmalu", "wrong_password");
        Assert.assertTrue("Login should fail for wrong password", !status.isLoginSuccess());
        Assert.assertEquals("Error message should be 'Credential mismatch'", "Credential mismatch", status.getErrorMsg());
    }

    // Test case for correct username and correct password (No validation code)
    @Test
    public void testCorrectUsernameCorrectPasswordAndNoValidationCode() {
        LoginStatus status = LoginForm.login("emmalu", "emmalu_pass");
        Assert.assertTrue("Login should succeed for correct username and password", status.isLoginSuccess());
        Assert.assertEquals("Error message should be the validation code", "123456", status.getErrorMsg());
    }

    // Test case for correct username, correct password, and empty validation code
    @Test
    public void testCorrectUsernameCorrectPasswordEmptyValidationCode() {
        LoginStatus status = LoginForm.login("emmalu", "emmalu_pass");
        if (status.isLoginSuccess()) {
            boolean valid = LoginForm.validateCode("");
            Assert.assertFalse("Validation code should be invalid when it's empty", valid);
        }
    }

    // Test case for correct username, correct password, and wrong validation code
    @Test
    public void testCorrectUsernameCorrectPasswordWrongValidationCode() {
        LoginStatus status = LoginForm.login("emmalu", "emmalu_pass");
        if (status.isLoginSuccess()) {
            boolean valid = LoginForm.validateCode("abcd");
            Assert.assertFalse("Validation code should be invalid", valid);
        }
    }

    // Test case for correct username, correct password, and correct validation code
    @Test
    public void testCorrectUsernameCorrectPasswordCorrectValidationCode() {
        LoginStatus status = LoginForm.login("emmalu", "emmalu_pass");
        if (status.isLoginSuccess()) {
            boolean valid = LoginForm.validateCode("123456");
            Assert.assertTrue("Validation code should be valid", valid);
        }
    }
}
