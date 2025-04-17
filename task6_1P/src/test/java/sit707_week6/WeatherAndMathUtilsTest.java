package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224791713"; // Your Student ID
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Emmalu Joseph"; // Your Full Name
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testCancelForHighWindSpeed() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancelForHighPrecipitation() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testCancelForCombinedConditions() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(45.1, 4.1));
    }

    @Test
    public void testWarnForHighWindSpeed() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.1, 0.0));
    }

    @Test
    public void testWarnForHighPrecipitation() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.1));
    }

    @Test
    public void testAllClearForNormalConditions() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 2.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindSpeed() {
        // Expecting IllegalArgumentException for negative wind speed
        WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);  
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrecipitation() {
        // Expecting IllegalArgumentException for negative precipitation
        WeatherAndMathUtils.weatherAdvice(10.0, -1.0);  
    }


    @Test
    public void testBoundaryConditions() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.0, 0.0));
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.0));
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.0, 0.0));
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.0));
    }

    @Test
    public void testSumNumbers() {
        Assert.assertEquals(10, WeatherAndMathUtils.sumNumbers(4)); // 1 + 2 + 3 + 4 = 10
        Assert.assertEquals(0, WeatherAndMathUtils.sumNumbers(0)); // sum of 0 is 0
        Assert.assertEquals(55, WeatherAndMathUtils.sumNumbers(10)); // 1 + 2 + ... + 10 = 55
    }

    @Test
    public void testCountOddNumbers() {
        // Normal case with a mix of even and odd numbers
        int[] nums1 = {1, 2, 3, 4, 5};
        Assert.assertEquals(3, WeatherAndMathUtils.countOddNumbers(nums1)); // 1, 3, 5 are odd

        // Empty array
        int[] nums2 = {};
        Assert.assertEquals(0, WeatherAndMathUtils.countOddNumbers(nums2));

        // Array with only odd numbers
        int[] nums3 = {1, 3, 5};
        Assert.assertEquals(3, WeatherAndMathUtils.countOddNumbers(nums3));

        // Array with all even numbers
        int[] nums4 = {2, 4, 6};
        Assert.assertEquals(0, WeatherAndMathUtils.countOddNumbers(nums4));

        // Array with a mix of negative and positive odd numbers
        int[] nums5 = {-1, 3, 5};
        Assert.assertEquals(3, WeatherAndMathUtils.countOddNumbers(nums5));

    }


    @Test
    public void testCountEvenNumbers() {
        // Normal case with a mix of even and odd numbers
        int[] nums1 = {1, 2, 3, 4, 5};
        Assert.assertEquals(2, WeatherAndMathUtils.countEvenNumbers(nums1)); // 2, 4 are even

        // Empty array
        int[] nums2 = {};
        Assert.assertEquals(0, WeatherAndMathUtils.countEvenNumbers(nums2));

        // Array with only even numbers
        int[] nums3 = {2, 4, 6};
        Assert.assertEquals(3, WeatherAndMathUtils.countEvenNumbers(nums3));

        // Array with all odd numbers
        int[] nums4 = {1, 3, 5};
        Assert.assertEquals(0, WeatherAndMathUtils.countEvenNumbers(nums4));

        // Array with a mix of negative and positive even numbers
        int[] nums5 = {-2, 4, 6};
        Assert.assertEquals(3, WeatherAndMathUtils.countEvenNumbers(nums5));

        // Test for null array, which should throw an exception
        try {
            WeatherAndMathUtils.countEvenNumbers(null);
            Assert.fail("Expected IllegalArgumentException for null input");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testIsPrime() {
        // Test with small primes and edge cases
        Assert.assertTrue(WeatherAndMathUtils.isPrime(2)); // Smallest prime
        Assert.assertFalse(WeatherAndMathUtils.isPrime(1)); // 1 is not prime
        Assert.assertFalse(WeatherAndMathUtils.isPrime(0)); // 0 is not prime
        Assert.assertFalse(WeatherAndMathUtils.isPrime(-5)); // Negative number is not prime
        Assert.assertTrue(WeatherAndMathUtils.isPrime(7)); // Prime number
        Assert.assertFalse(WeatherAndMathUtils.isPrime(8)); // Not prime
        Assert.assertTrue(WeatherAndMathUtils.isPrime(997)); // Large prime
    }
}
