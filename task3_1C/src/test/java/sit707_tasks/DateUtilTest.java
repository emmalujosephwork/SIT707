package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Emmalu Joseph
 * Student ID: 224791713
 */
public class DateUtilTest {
    
    @Test
    public void testStudentIdentity() {
        String studentId = "224791713";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Emmalu Joseph";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        // January max boundary area: max+1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("January31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }
    
    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        // January max boundary area: max-1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("January31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testNominalJanuary() {
        int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testNominalJanuary > " + date);
        date.increment();
        System.out.println(date);
    }
    
    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        // Code here
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }
    
    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        // Code here
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }
    
    @Test
    public void testLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);  // Leap year, Feb 29
        date.increment();
        Assert.assertEquals(1, date.getDay());  // March 1
    }

    @Test
    public void testNonLeapYear() {
        DateUtil date = null;
        try {
            date = new DateUtil(29, 2, 2023);  // Non-leap year, Feb 29 should be invalid
            date.increment();  // This line should never be executed because exception should be thrown
            Assert.fail("Exception should be thrown for Feb 29 in non-leap year");
        } catch (RuntimeException e) {
            // Expected exception
            Assert.assertTrue(e.getMessage().contains("Invalid day: February 29th in non-leap year"));
        }
    }

}
