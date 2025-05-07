package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MathQuestionSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64_1/chromedriver-win64/chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Implicit wait
    }

    @Test
    public void testQ1ValidAnswer() {
        driver.get("http://localhost:8082/q1");

        driver.findElement(By.id("number1")).sendKeys("5");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("7");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("12");  // Correct answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleep(1000);  // Delay for 1 second

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1InvalidAnswer() {
        driver.get("http://localhost:8082/q1");

        driver.findElement(By.id("number1")).sendKeys("5");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("7");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("10");  // Incorrect answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Wrong answer, try again.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testQ1InvalidInput() {
        driver.get("http://localhost:8082/q1");

        driver.findElement(By.id("number1")).sendKeys("five");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("seven");
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed for invalid input
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid input, please enter valid numbers.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testQ2ValidAnswer() {
        driver.get("http://localhost:8082/q2");

        driver.findElement(By.id("number1")).sendKeys("10");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("4");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("6");  // Correct answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleep(1000);  // Delay for 1 second

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ2InvalidAnswer() {
        driver.get("http://localhost:8082/q2");

        driver.findElement(By.id("number1")).sendKeys("10");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("4");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("8");  // Incorrect answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Wrong answer, try again.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void testQ2InvalidInput() {
        driver.get("http://localhost:8082/q2");

        driver.findElement(By.id("number1")).sendKeys("ten");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("four");
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed for invalid input
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid input, please enter valid numbers.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    // Test for valid multiplication input for Q3
    @Test
    public void testQ3ValidAnswer() {
        driver.get("http://localhost:8082/q3");

        driver.findElement(By.id("number1")).sendKeys("6");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("8");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("48");  // Correct answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        sleep(1000);  // Delay for 1 second

        // You can check if redirected to a success page or any other expected outcome
        // Assert.assertTrue(driver.getCurrentUrl().contains("/success"));
    }

    // Test for invalid multiplication input for Q3
    @Test
    public void testQ3InvalidAnswer() {
        driver.get("http://localhost:8082/q3");

        driver.findElement(By.id("number1")).sendKeys("6");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("8");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("result")).sendKeys("50");  // Incorrect answer
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Wrong answer, try again.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    // Test for invalid multiplication input for Q3 (non-numeric input)
    @Test
    public void testQ3InvalidInput() {
        driver.get("http://localhost:8082/q3");

        driver.findElement(By.id("number1")).sendKeys("six");
        sleep(1000);  // Delay for 1 second
        driver.findElement(By.id("number2")).sendKeys("eight");
        sleep(1000);  // Delay for 1 second

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Assert that the error message is displayed for invalid input
        sleep(1000);  // Delay for 1 second
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Invalid input, please enter valid numbers.')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Introduce a delay in milliseconds (1000ms = 1 second)
    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
