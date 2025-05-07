package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceSeleniumTest {

    @Test
    public void testLoginSuccess() throws InterruptedException {
        // Set the path for the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Use the correct file path for your login.html
        driver.get("file:///C:/Users/emmal/OneDrive/Documents/Deakin/SIT707/SIT707/SIT707/7.1P-resources/pages/login.html");

        // Enter the correct credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("emmalu");

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("emma_pass");

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");  // Correct Date format in yyyy-mm-dd

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.submit();

        // Wait for the page to load after form submission
        Thread.sleep(2000); // Wait for the page to load after form submission

        // Check if the title of the page matches "success"
        String title = driver.getTitle();
        Assert.assertEquals("success", title);  // Assert that the title is "success"

        // Quit the driver after the test
        driver.quit();
    }

    @Test
    public void testLoginFailure() throws InterruptedException {
        // Set the path for the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Use the correct file path for your login.html
        driver.get("file:///C:/Users/emmal/OneDrive/Documents/Deakin/SIT707/SIT707/SIT707/7.1P-resources/pages/login.html");

        // Enter incorrect credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("wrong_user");

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("wrong_pass");

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");  // Correct date of birth but incorrect username/password

        // Add a delay to ensure the data is entered properly
        Thread.sleep(1000);  // Wait for 1 second

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.submit();

        // Wait for the page to load after form submission
        Thread.sleep(2000); // Wait for the page to load after form submission

        // Check if the title of the page matches "fail"
        String title = driver.getTitle();
        Assert.assertEquals("fail", title);  // Assert that the title is "fail"

        // Quit the driver after the test
        driver.quit();
    }
}
