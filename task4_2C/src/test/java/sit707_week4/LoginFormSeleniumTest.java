package sit707_week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginFormSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testValidLogin() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("validUsername");  // Replace with valid username
        passwordField.sendKeys("validPassword");  // Replace with valid password
        loginButton.click();

        String expectedUrl = "https://www.bunnings.com.au/dashboard";  // Adjust based on successful login URL
        Assert.assertEquals("Login failed!", expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testInvalidUsername() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("invalidUsername");
        passwordField.sendKeys("validPassword");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-message"));  // Adjust based on the actual error message locator
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @Test
    public void testInvalidPassword() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("validUsername");
        passwordField.sendKeys("invalidPassword");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-message"));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyUsername() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("");
        passwordField.sendKeys("validPassword");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-message"));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyPassword() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("validUsername");
        passwordField.sendKeys("");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-message"));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        driver.get("https://www.bunnings.com.au/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        usernameField.sendKeys("");
        passwordField.sendKeys("");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error-message"));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
