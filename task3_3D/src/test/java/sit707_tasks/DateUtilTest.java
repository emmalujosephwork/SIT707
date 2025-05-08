package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224791713"; // Replace with your ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Emmalu Joseph"; // Replace with your name
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
        int rand_day_1_to_31 = 1 + new Random().nextInt(31);
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

    // Tests for leap year
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
    public void testFebruary29NonLeapYearShouldThrowException() {
        try {
            new DateUtil(29, 2, 2023); // Non-leap year, should throw exception
            Assert.fail("Exception should have been thrown for invalid date");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid day"));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateJune31() {
        new DateUtil(31, 6, 2024); // Invalid date (June has 30 days)
    }

    @Test
    public void testDecember31ShouldIncrementToJan1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals("1 January 2025", date.toString());
    }
}
