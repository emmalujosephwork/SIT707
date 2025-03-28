package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * @author Emmalu joseph
 */
public class SeleniumOperations {

    // Sleep method to wait for a few seconds
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to automate OfficeWorks registration page
    public static void officeworks_registration_page(String url) {
        // Step 1: Set Chrome driver path
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe"); // Your driver path

        // Step 2: Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Step 3: Open the URL
        driver.get(url);
        
        // Wait for the page to load
        sleep(2);

        // Step 4: Locate and fill in the registration form for OfficeWorks
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Emma");

        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Joseph");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("emmalu@example.com");

        WebElement phone = driver.findElement(By.id("phoneNumber"));
        phone.sendKeys("0431123412");

        // Fill in the password field (meeting the requirements)
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Abcde@123");

        // Confirm password (using the same value)
        WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("Abcde@123");

        // Step 5: Locate and click the "Create Account" button
        WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
        createAccountButton.click();

        // Step 6: Capture the screenshot
        takeScreenshot(driver);

        // Step 7: Close the browser
        sleep(2);
        driver.close();
    }

    // Method to automate Odoo registration page
    public static void pro_registration_page(String url) {
        // Step 1: Set Chrome driver path
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe"); // Your driver path

        // Step 2: Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Step 3: Open the URL
        driver.get(url);
        
        // Wait for the page to load
        sleep(2);

        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("Emmalu");

        // Step 4: Locate and fill in the registration form for Odoo
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Jose");
        
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("emmajose@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password@123");

        // Step 5: Handle the "Terms and Conditions" checkbox with WebDriverWait
        try {
            // Use WebDriverWait for Selenium 3.x (pass integer for timeout)
            WebDriverWait wait = new WebDriverWait(driver, 10);  // Timeout in seconds (10 seconds)
            WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("terms-checkbox")));
            termsCheckbox.click();  // Click the checkbox to agree to the terms
        } catch (TimeoutException e) {
            System.out.println("Checkbox not clickable within the given time frame.");
            e.printStackTrace();
        }

        // If the checkbox is not clickable, use JavaScript to click it
        if (!driver.findElement(By.id("terms-checkbox")).isSelected()) {
            WebElement termsCheckbox = driver.findElement(By.id("terms-checkbox"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", termsCheckbox); // Force click using JavaScript
        }

        // Step 6: Locate and click the "Sign Up" button
        WebElement signUpButton = driver.findElement(By.cssSelector("button[type='submit']"));
        signUpButton.click();

        // Step 7: Capture the screenshot
        takeScreenshot(driver);

        // Step 8: Close the browser
        sleep(2);
        driver.close();
    }

    // Method to take a screenshot
    public static void takeScreenshot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
            System.out.println("Screenshot saved as screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle an alternative website (You can implement this similarly as above)
    public static void alternative_registration_page(String url) {
        // Similar steps as in officeworks_registration_page but for an alternative site
    }
}
