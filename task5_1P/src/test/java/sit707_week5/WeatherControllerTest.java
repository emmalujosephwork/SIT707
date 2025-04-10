package sit707_week5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherControllerTest {

    private WeatherController wController;
    private double[] temperatures; // Store temperature values for reuse

    @Before
    public void setUp() {
        // Arrange: Initialize the controller once for all tests
        wController = WeatherController.getInstance();
        temperatures = new double[wController.getTotalHours()];
        
        // Store the temperatures for later use
        for (int i = 0; i < wController.getTotalHours(); i++) {
            temperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "s224791713"; // Your actual student ID
        
        // Act & Assert
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "Emmalu Joseph"; // Your actual student name
        
        // Act & Assert
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        // Arrange
        double minTemperature = Double.MAX_VALUE;
        for (double temp : temperatures) {
            if (temp < minTemperature) {
                minTemperature = temp;
            }
        }

        // Act & Assert
        Assert.assertEquals("Min temperature mismatch", minTemperature, wController.getTemperatureMinFromCache(), 0.1);
    }

    @Test
    public void testTemperatureMax() {
        // Arrange
        double maxTemperature = Double.MIN_VALUE;
        for (double temp : temperatures) {
            if (temp > maxTemperature) {
                maxTemperature = temp;
            }
        }

        // Act & Assert
        Assert.assertEquals("Max temperature mismatch", maxTemperature, wController.getTemperatureMaxFromCache(), 0.1);
    }

    @Test
    public void testTemperatureAverage() {
        // Arrange
        double sumTemp = 0;
        for (double temp : temperatures) {
            sumTemp += temp;
        }
        double averageTemp = sumTemp / temperatures.length;

        // Act & Assert
        Assert.assertEquals("Average temperature mismatch", averageTemp, wController.getTemperatureAverageFromCache(), 0.1);
    }

    @Test
    public void testTemperaturePersist() {
        // Arrange
        int hour = 10;
        double temperature = 19.5;
        
        // Act
        String persistTime = wController.persistTemperature(hour, temperature);
        String now = new java.text.SimpleDateFormat("H:m:s").format(new java.util.Date());

        // Allow a small margin of error for time comparison
        String[] persistTimeParts = persistTime.split(":");
        String[] nowParts = now.split(":");
        
        int persistTimeInSeconds = Integer.parseInt(persistTimeParts[0]) * 3600 + Integer.parseInt(persistTimeParts[1]) * 60 + Integer.parseInt(persistTimeParts[2]);
        int nowInSeconds = Integer.parseInt(nowParts[0]) * 3600 + Integer.parseInt(nowParts[1]) * 60 + Integer.parseInt(nowParts[2]);

        // Assert that the difference between the two times is small (e.g., within 5 seconds)
        Assert.assertTrue("Persist time mismatch", Math.abs(persistTimeInSeconds - nowInSeconds) <= 5);
    }

    @Test
    public void tearDown() {
        // Close controller only after all tests
        wController.close();
    }
}
