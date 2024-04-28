package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s220459698";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Dilum";
        Assert.assertNotNull("Student name is null", studentName);
    }
    
    @Test
    public void testAllClearWeather() {
        String advice = WeatherAndMathUtils.weatherAdvice(30, 3.0);
        Assert.assertEquals("ALL CLEAR", advice);
    }
    
    
    @Test
    public void testWarnWhenWindExceedConcerningButLessThanDangerous() {
        String advice = WeatherAndMathUtils.weatherAdvice(46.0, 3.0);
        Assert.assertEquals("WARN", advice);
    }
    
    @Test
    public void testWarnWhenPrecipitationExceedConcerningButLessThanDangerous() {
        String advice = WeatherAndMathUtils.weatherAdvice(30, 5);
        Assert.assertEquals("WARN", advice);
    }
    
    @Test
    public void testCancelWhenWindspeedExceedDangerous() {
        String advice = WeatherAndMathUtils.weatherAdvice(75, 3);
        Assert.assertEquals("CANCEL", advice);
    }
    
    @Test
    public void testCancelWhenPrecipitationExceedDangerous() {
        String advice = WeatherAndMathUtils.weatherAdvice(30, 15);
        Assert.assertEquals("CANCEL", advice);
    }
    
    @Test
    public void testCancelWindspeedAndPrecipitationBothExceedConcerning() {
        String advice = WeatherAndMathUtils.weatherAdvice(46.0, 5);
        Assert.assertEquals("CANCEL", advice);
    }
    
    @Test
    public void testNegativeWindSpeedThrowsException() {
   
        try {
        	WeatherAndMathUtils.weatherAdvice(-1, 5);
            Assert.fail("Expected IllegalArgumentException");  //if this passes there hasn't been any exception caught which means the test is failed
        } catch (IllegalArgumentException e) {
        	//Exception caught, test passed.
        }
    }

    
    @Test
    public void testNegativePrecipitationThrowsException() {

        Assert.assertThrows(IllegalArgumentException.class, () -> WeatherAndMathUtils.weatherAdvice(20, -5));
    }

}
