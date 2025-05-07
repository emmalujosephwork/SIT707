package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationServiceTest {

    @Test
    public void testRegistrationSuccess() throws InterruptedException {
        // Set the path for the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Use the correct file path for your register.html
        driver.get("file:///C:/Users/emmal/OneDrive/Documents/Deakin/SIT707/SIT707/SIT707/7.1P-resources/pages/register.html");

        // Enter valid registration details
        WebElement fnameField = driver.findElement(By.id("fname"));
        fnameField.sendKeys("John");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement lnameField = driver.findElement(By.id("lname"));
        lnameField.sendKeys("Doe");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("john@example.com");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");  // Correct Date format in yyyy-mm-dd

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.submit();

        // Wait for the server to respond after form submission
        Thread.sleep(2000);  // Wait for 2 seconds to ensure the server has processed the form

        // Check the server's response, should be "ok" if registration was successful
        WebElement response = driver.findElement(By.tagName("body"));
        String responseText = response.getText();
        Assert.assertTrue(responseText.contains("status\":\"ok"));

        driver.quit();
    }

    @Test
    public void testRegistrationFailure() throws InterruptedException {
        // Set the path for the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Use the correct file path for your register.html
        driver.get("file:///C:/Users/emmal/OneDrive/Documents/Deakin/SIT707/SIT707/SIT707/7.1P-resources/pages/register.html");

        // Enter registration details with an already used email (e.g., "johndoe@example.com" already exists)
        WebElement fnameField = driver.findElement(By.id("fname"));
        fnameField.sendKeys("Jane");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement lnameField = driver.findElement(By.id("lname"));
        lnameField.sendKeys("Smith");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("johndoe@example.com");

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement dobField = driver.findElement(By.id("dob"));
        dobField.sendKeys("1990-01-01");  // Correct Date format in yyyy-mm-dd

        // Wait for the input to be processed
        Thread.sleep(1000);  // 1 second delay

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.submit();

        // Wait for the server to respond after form submission
        Thread.sleep(2000);  // Wait for 2 seconds to ensure the server has processed the form

        // Check the server's response, should contain "status":"error"
        WebElement response = driver.findElement(By.tagName("body"));
        String responseText = response.getText();
        Assert.assertTrue(responseText.contains("status\":\"error"));

        driver.quit();
    }
}
