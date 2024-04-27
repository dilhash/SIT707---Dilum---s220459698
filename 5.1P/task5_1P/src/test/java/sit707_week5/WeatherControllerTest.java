package sit707_week5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static int totalHours;

	@BeforeClass
	public static void initController() {
		wController = WeatherController.getInstance();
		totalHours = wController.getTotalHours();
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "s220459698";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dilum Balaarachchi";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		double minTemperature = 1000;
		for (int i = 0; i < totalHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		double maxTemperature = -1;
		for (int i = 0; i < totalHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}

		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		double sumTemp = 0;
		for (int i = 0; i < totalHours; i++) {
			double temperatureVal = wController.getTemperatureForHour(i + 1);
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / totalHours;

		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}

	@AfterClass
	public static void closeController() {
		wController.close(); // Close the controller after all tests
	}
}
