package sit707_week5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertTrue;

public class WeatherControllerTest {

    private WeatherController wController;

    @Before
    public void weatherControllerSetUp() {
        System.out.println("Setting up test...");
        wController = WeatherController.getInstance();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Arrange: Prepare input data and expected results
        double temperature = 19.5;
        int hour = 10;

        // Act: Perform the action
        String persistTime = wController.persistTemperature(hour, temperature);
        String now = new SimpleDateFormat("H:m:s").format(new Date());

        // Assert: Verify the outcome
        try {
            long tolerance = 2000; // 2 seconds tolerance

            Date persistDate = new SimpleDateFormat("H:m:s").parse(persistTime);
            Date currentDate = new SimpleDateFormat("H:m:s").parse(now);

            long timeDifference = Math.abs(persistDate.getTime() - currentDate.getTime());

            assertTrue("Time difference: " + timeDifference + " ms", timeDifference <= tolerance);
            
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + e.getMessage());
            assertTrue(false);
        }
    }

    @After
    public void weatherControllerClose() {
        System.out.println("Close down test...");
        wController.close();
    }
}
