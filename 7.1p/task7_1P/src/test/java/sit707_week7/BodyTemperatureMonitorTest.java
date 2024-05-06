package sit707_week7;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BodyTemperatureMonitorTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "s220459698";
		Assert.assertNotNull("Student ID", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Dilum Bal";
		Assert.assertNotNull("Student name is ", studentName);
	}
	
	@Test
	public void testReadTemperatureNegative() {
	  TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	  Mockito.when(sensor.readTemperatureValue()).thenReturn(-10.0); // Stub to return negative value

	  BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, null, null);
	  double temp = monitor.readTemperature();

	  // Assert that the temperature is negative
	  Assert.assertTrue(temp < 0);
	}

	// Similar tests for testReadTemperatureZero, testReadTemperatureNormal, and testReadTemperatureAbnormallyHigh with appropriate stubbed temperature values

	@Test
	public void testReadTemperatureZero() {
		TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    Mockito.when(sensor.readTemperatureValue()).thenReturn(0.0); // Stub to return zero value

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, null, null);
	    double temp = monitor.readTemperature();

	    // Assert that the temperature is zero
	    Assert.assertEquals(0.0, temp, 0.001);
	}
	
	@Test
	public void testReadTemperatureNormal() {
		TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    Mockito.when(sensor.readTemperatureValue()).thenReturn(36.5); // Stub to return normal value

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, null, null);
	    double temp = monitor.readTemperature();

	    // Assert that the temperature is within normal range
	    Assert.assertTrue(temp >= 35 && temp <= 37);
	}

	@Test
	public void testReadTemperatureAbnormallyHigh() {
		TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    Mockito.when(sensor.readTemperatureValue()).thenReturn(40.0); // Stub to return high value

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, null, null);
	    double temp = monitor.readTemperature();

	    // Assert that the temperature is abnormally high
	    Assert.assertTrue(temp > 37);
	}
	
	// To achive Code coverage
	
	  @Test
	  public void testReportTemperatureReadingToCloud() {
	    TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    CloudService cloudService = Mockito.mock(CloudService.class);
	    NotificationSender notificationSender = Mockito.mock(NotificationSender.class);

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, cloudService, notificationSender);

	    // Simulate temperature reading
	    Mockito.when(sensor.readTemperatureValue()).thenReturn(36.5);

	    TemperatureReading reading = new TemperatureReading(); // Create a temperature reading object
	    monitor.reportTemperatureReadingToCloud(reading);

	    // Verify that cloudService.sendTemperatureToCloud is called once
	    Mockito.verify(cloudService, Mockito.times(1)).sendTemperatureToCloud(reading);
	  }
	  
	  @Test
	  public void testInquireBodyStatusNormalNotification() {
	    TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    CloudService cloudService = Mockito.mock(CloudService.class);
	    NotificationSender notificationSender = Mockito.mock(NotificationSender.class);

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, cloudService, notificationSender);

	    // Stub cloudService to return NORMAL status
	    Mockito.when(cloudService.queryCustomerBodyStatus(monitor.getFixedCustomer())).thenReturn("NORMAL");

	    monitor.inquireBodyStatus();

	    // Verify that notificationSender.sendEmailNotification(Customer) is called with a specific message
	    Mockito.verify(notificationSender, Mockito.times(1)).sendEmailNotification(monitor.getFixedCustomer(), "Thumbs Up!");
	  }


	  @Test
	  public void testInquireBodyStatusAbnormalNotification() {
	    TemperatureSensor sensor = Mockito.mock(TemperatureSensor.class);
	    CloudService cloudService = Mockito.mock(CloudService.class);
	    NotificationSender notificationSender = Mockito.mock(NotificationSender.class);

	    BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(sensor, cloudService, notificationSender);

	    // Stub cloudService to return ABNORMAL status
	    Mockito.when(cloudService.queryCustomerBodyStatus(monitor.getFixedCustomer())).thenReturn("ABNORMAL");

	    monitor.inquireBodyStatus();

	    // Verify notification to Family Doctor
	    Mockito.verify(notificationSender, Mockito.times(1)).sendEmailNotification(monitor.getFamilyDoctor(), "Emergency!");

	  }

	

	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testReportTemperatureReadingToCloud() {
//		// Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
//		
//		Assert.assertTrue("Not tested", false);
//	}
	
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusNormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusAbnormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
}
