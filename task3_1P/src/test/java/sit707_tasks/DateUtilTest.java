package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "123456789"; // Replace with your ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Your Name"; // Replace with your name
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testNominalJanuary() {
        int rand_day_1_to_31 = 2 + new Random().nextInt(30);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        date.increment();
        Assert.assertEquals(rand_day_1_to_31 + 1, date.getDay());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // --- Other Months + Leap Year Test Cases ---

    @Test
    public void testApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals("1 May 2024", date.toString());
    }

    @Test
    public void testFebruary28LeapYearShouldGoToFeb29() {
        DateUtil date = new DateUtil(28, 2, 2024); // Leap year
        date.increment();
        Assert.assertEquals("29 February 2024", date.toString());
    }

    @Test
    public void testFebruary29LeapYearShouldGoToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024); // Leap year
        date.increment();
        Assert.assertEquals("1 March 2024", date.toString());
    }

    @Test
    public void testJune30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals("1 July 2024", date.toString());
    }

    @Test
    public void testDecember31ShouldIncrementToJan1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals("1 January 2025", date.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDateJune31() {
        new DateUtil(31, 6, 2024); // Invalid date
    }
}
