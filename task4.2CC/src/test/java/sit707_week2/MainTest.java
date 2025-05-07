package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    
    WebDriver driver;
    
    // Setup method for WebDriver
    @Before
    public void setUp() {
        // Path to Chrome Driver (updated to your specified path)
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @Test
    public void testLoginValid() throws InterruptedException {
        // Test Case 1: Valid username and password
        driver.get("https://www.bunnings.com.au/login");
        
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("emmalujosephwork@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Emmalu@jsp3");
        
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        
        // Add delay for page load
        Thread.sleep(5000);
        
        // Expected URL after successful login
        String expectedUrl = "https://www.bunnings.com.au/";
        String actualUrl = driver.getCurrentUrl();
        
        // Print the URLs for debugging
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);
        
        // Assert the URLs match
        Assert.assertEquals("Login failed, URL doesn't match", expectedUrl, actualUrl);
    }

    @Test
    public void testLoginInvalidPassword() throws InterruptedException {
        // Test Case 2: Valid username and invalid password
        driver.get("https://www.bunnings.com.au/login");
        
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("emmalujosephwork@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("wrongpassword");
        
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        
        // Add delay for page load
        Thread.sleep(5000);
        
        // Assert the login page URL is still the same due to failed login
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Login Failed URL: " + actualUrl);
        Assert.assertTrue("Login failed, user is redirected unexpectedly", actualUrl.contains("login"));
    }

    @Test
    public void testLoginInvalidUsername() throws InterruptedException {
        // Test Case 3: Invalid username and valid password
        driver.get("https://www.bunnings.com.au/login");
        
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("invaliduser@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Emmalu@jsp3");
        
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        
        // Add delay for page load
        Thread.sleep(5000);
        
        // Assert the login page URL is still the same due to failed login
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Login Failed URL: " + actualUrl);
        Assert.assertTrue("Login failed, user is redirected unexpectedly", actualUrl.contains("login"));
    }

    @Test
    public void testLoginInvalidCredentials() throws InterruptedException {
        // Test Case 4: Invalid username and invalid password
        driver.get("https://www.bunnings.com.au/login");
        
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("invaliduser@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("wrongpassword");
        
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        
        // Add delay for page load
        Thread.sleep(5000);
        
        // Assert the login page URL is still the same due to failed login
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Login Failed URL: " + actualUrl);
        Assert.assertTrue("Login failed, user is redirected unexpectedly", actualUrl.contains("login"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
