package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

    // Test valid credentials
    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("emmalu", "emma_pass", "1990-01-01"));
    }

    // Test invalid username
    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(LoginService.login("wronguser", "emma_pass", "1990-01-01"));
    }

    // Test invalid password
    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(LoginService.login("emmalu", "wrongpass", "1990-01-01"));
    }

    // Test invalid date of birth
    @Test
    public void testInvalidDob() {
        Assert.assertFalse(LoginService.login("emmalu", "emma_pass", "1990-02-01"));
    }

    // Test empty input for all fields (boundary case)
    @Test
    public void testEmptyFields() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    // Test invalid date format (boundary case)
    @Test
    public void testInvalidDateFormat() {
        Assert.assertFalse(LoginService.login("emmalu", "emma_pass", "01-01-1990"));
    }
}
