package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

    // Student Identity Test
    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "224791713"; // Replace with your student ID
        String studentName = "Emmalu Joseph"; // Replace with your name
        
        // Assert
        Assert.assertNotNull("Student ID is null", studentId);
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Test Minimum Temperature
    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        
        // Act
        double minTemp = wController.getTemperatureMinFromCache();
        
        // Assert
        Assert.assertTrue("Minimum temperature should be >= 1", minTemp >= 1);
        Assert.assertTrue("Minimum temperature should be <= 30", minTemp <= 30);
        
        // Cleanup
        wController.close();
    }

    // Test Maximum Temperature
    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        
        // Act
        double maxTemp = wController.getTemperatureMaxFromCache();
        
        // Assert
        Assert.assertTrue("Maximum temperature should be >= 1", maxTemp >= 1);
        Assert.assertTrue("Maximum temperature should be <= 30", maxTemp <= 30);
        
        // Cleanup
        wController.close();
    }

    // Test Average Temperature
    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        
        // Act
        double avgTemp = wController.getTemperatureAverageFromCache();
        
        // Assert
        Assert.assertTrue("Average temperature should be >= 1", avgTemp >= 1);
        Assert.assertTrue("Average temperature should be <= 30", avgTemp <= 30);
        
        // Cleanup
        wController.close();
    }

    // Test Temperature Persistence
    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
        
        try {
            // Get time range boundaries
            String startTime = sdf.format(new Date());
            
            // Act - persist temperature (this will include some delay)
            String persistTime = wController.persistTemperature(1, 25.0);
            
            // Get time after persistence
            String endTime = sdf.format(new Date());
            
            // Assert
            System.out.println("Start time: " + startTime);
            System.out.println("Persist time: " + persistTime);
            System.out.println("End time: " + endTime);
            
            // Verify persistTime is between start and end times
            long startTimeInMillis = sdf.parse(startTime).getTime();
            long persistTimeInMillis = sdf.parse(persistTime).getTime();
            long endTimeInMillis = sdf.parse(endTime).getTime();
            
            Assert.assertTrue("Persist time should be >= start time", persistTimeInMillis >= startTimeInMillis);
            Assert.assertTrue("Persist time should be <= end time", persistTimeInMillis <= endTimeInMillis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cleanup
            wController.close();
        }
    }

    // Test Get Temperature For Hour
    @Test
    public void testGetTemperatureForHour() {
        System.out.println("+++ testGetTemperatureForHour +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        int testHour = 1; // Testing first hour
        
        // Act
        double temperature = wController.getTemperatureForHour(testHour);
        
        // Assert
        Assert.assertTrue("Temperature should be within valid range", 
                        temperature >= 1 && temperature <= 30);
        
        // Cleanup
        wController.close();
    }

    // Test Get Total Hours
    @Test
    public void testGetTotalHours() {
        System.out.println("+++ testGetTotalHours +++");
        
        // Arrange
        WeatherController wController = WeatherController.getInstance();
        
        // Act
        int totalHours = wController.getTotalHours();
        
        // Assert
        Assert.assertEquals("Total hours should match constant", 
                          WeatherController.HOURS_PER_DAY, totalHours);
        
        // Cleanup
        wController.close();
    }
}
