package sit707_week6;

public class WeatherAndMathUtils {
    public static final double DANGEROUS_WINDSPEED = 70.0;
    public static final double DANGEROUS_RAINFALL = 6.0;
    public static final double CONCERNING_WINDSPEED = 45.0;
    public static final double CONCERNING_RAINFALL = 4.0;

    /**
     * Advises weather alert based on wind-speed and precipitation.
     * 
     * @param windSpeed the wind speed in mph
     * @param precipitation the rainfall in inches
     * @return weather advice as String ("CANCEL", "WARN", or "ALL CLEAR")
     * @throws IllegalArgumentException if inputs are negative
     */
    public static String weatherAdvice(double windSpeed, double precipitation) {
        if (windSpeed < 0 || precipitation < 0) {
            throw new IllegalArgumentException("Wind speed and precipitation must be non-negative");
        }

        if (windSpeed >= DANGEROUS_WINDSPEED || precipitation >= DANGEROUS_RAINFALL
                || (windSpeed >= CONCERNING_WINDSPEED && precipitation >= CONCERNING_RAINFALL)) {
            return "CANCEL";
        } else if (windSpeed >= CONCERNING_WINDSPEED || precipitation >= CONCERNING_RAINFALL) {
            return "WARN";
        }
        
        return "ALL CLEAR";
    }


    /**
     * Checks if a number is even.
     * 
     * @param number the number to check
     * @return true if even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if a number is prime.
     * 
     * @param number the number to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the sum of numbers from 1 to n.
     * 
     * @param n the upper limit
     * @return the sum of numbers from 1 to n
     * @throws IllegalArgumentException if n is negative
     */
    public static int sumNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Counts the number of even numbers in an array.
     * 
     * @param numbers the array of numbers
     * @return count of even numbers
     * @throws IllegalArgumentException if array is null
     */
    public static int countEvenNumbers(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int count = 0;
        for (int num : numbers) {
            if (isEven(num)) {
                count++;
            }
        }
        return count;
    }

    public static int countOddNumbers(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

}
