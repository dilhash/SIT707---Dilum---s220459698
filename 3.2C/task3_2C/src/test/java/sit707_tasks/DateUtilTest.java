package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		System.out.println("------ TestCase 1 ------ ");
		String studentId = "s220459698";
		System.out.println("Student ID:   " + studentId);
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		System.out.println("------ TestCase 2 ------ ");
		String studentName = "Dilum Balaarachchi";
		System.out.println("Student Name:   " + studentName);
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		System.out.println("------ TestCase 3 ------ ");
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
		System.out.print("testMaxJanuary31ShouldIncrementToFebruary1 > Input:" + date + " Output:");
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		System.out.println("------ TestCase 4 ------ ");
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.print("january31ShouldDecrementToJanuary30 > Input:" + date + " Output:");
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		System.out.println("------ TestCase 5 ------ ");
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.print("testJanuaryNominal > Input:" + date + " Output:");
        date.increment();
        System.out.println(date);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		System.out.println("------ TestCase 6 ------ ");
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.print("testMinJanuary1ShouldIncrementToJanuary2 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		System.out.println("------ TestCase 7 ------ ");
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.print("january31ShouldDecrementToJanuary30 > Input:" + date + " Output:");
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
	}
	
	
/*** Leap Year Testing ***/
	
	@Test
	public void testleapyearFeb28ShouldIncrementToFeb29() {
		System.out.println("------ TestCase 8 ------ ");
		
		// Value   28/2­/2024
		//expected 29/2/­2024
		DateUtil date = new DateUtil(28, 2, 2024);
        System.out.print("testMinJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
        date.increment();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
		
	}
	
	@Test
	public void testleapyearMaxFeb29ShouldIncrementToMarch1() {
		System.out.println("------ TestCase 9 ------ ");
		// Value   28/2­/2024
		//expected 1/3/­2024
		DateUtil date = new DateUtil(29, 2, 2024);
        System.out.print("testMinJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
		
	}
	@Test
	public void testleapyearMinMarch1ShouldDecrementToFeb29() {
		System.out.println("------ TestCase 10 ------ ");
		// Value   1/3/2020
		//expected 29/2/­2024
		DateUtil date = new DateUtil(1, 3, 2020);
        System.out.print("testMinJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2020, date.getYear());
		
	}
	
	public void testUnleapyearMaxFeb28ShouldIncrementToMarch1() {
		System.out.println("------ TestCase 11 ------ ");
		// Value   28/2­/2023
		//expected 1/3/­2023
		DateUtil date = new DateUtil(28, 2, 2023);
        System.out.print("testMinJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
		
	}
	
	@Test
	public void testUnleapyearMinMarch1ShouldDecrementToFeb28() {
		System.out.println("------ TestCase 12 ------ ");
		// Value   1/3/2021
		//expected 28/2/­2021
		DateUtil date = new DateUtil(1, 3, 2021);
        System.out.print("testMinJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2021, date.getYear());
		
	}

/**** Exception Testing ***/
		
	@Test
	public void testInvalidDayExceptionForDay32() {
	    // Value: 32/6/1994
	    // Expected: Invalid day: 32, expected range 1-31
	    System.out.println("------ TestCase 13 ------ ");
	    
	    try {
	        DateUtil date = new DateUtil(32, 6, 1994);
	      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
	        Assert.fail("No exception thrown for invalid day.");
	    } catch (RuntimeException e) {
	        // Capture the exception message and print it
	        System.out.println("Caught exception: " + e.getMessage());
	        // Check if the exception message contains the expected error message
	        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid day: 32, expected range 1-31"));
	    }
	}

	@Test
	public void testInvalidDayExceptionForFeb30() {
	    // Value: 30/2/2024 (May 32nd, 2024)
	    // Expected: Invalid day: 32, max day: 31
	    System.out.println("------ TestCase 14 ------ ");
	    
	    try {
	        DateUtil date = new DateUtil(30, 2, 2024);
	       // System.out.print("testInvalidDayForFeb30 > Input:" + date + " Output:");
	        Assert.fail("No exception thrown for invalid day.");
	    } catch (RuntimeException e) {
	        // Capture the exception message and print it
	        System.out.println("Caught exception: " + e.getMessage());
	        // Calculate the maximum number of days in May 2024
	        int maxDayMay2024 = DateUtil.monthDuration(5, 2024);
	        // Check if the exception message contains the expected error message
	        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid day: 30, max day: 29"));
	    }
	}

	@Test
	public void testInvalidMonthExceptionForMonth13() {
	    // Value: 01/13/1994
	    // Expected: Invalid month: 13, expected range 1-12
	    System.out.println("------ TestCase 15 ------ ");
	    
	    try {
	        DateUtil date = new DateUtil(01, 13, 1994);
	      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
	        Assert.fail("No exception thrown for invalid day.");
	    } catch (RuntimeException e) {
	        // Capture the exception message and print it
	        System.out.println("Caught exception: " + e.getMessage());
	        // Check if the exception message contains the expected error message
	        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid month: 13, expected range 1-12"));
	    }
	}
	
	@Test
	public void testInvalidYearExceptionForYear2025() {
	    // Value: 01/4/2025
	    // Expected: Invalid year: 2025, expected range 1700-2024
	    System.out.println("------ TestCase 16 ------ ");
	    
	    try {
	        DateUtil date = new DateUtil(01, 4, 2025);
	      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
	        Assert.fail("No exception thrown for invalid day.");
	    } catch (RuntimeException e) {
	        // Capture the exception message and print it
	        System.out.println("Caught exception: " + e.getMessage());
	        // Check if the exception message contains the expected error message
	        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid year: 2025, expected range 1700-2024"));
	    }
	}
	@Test
	public void testInvalidYearExceptionForYear1600() {
	    // Value: 13/11/1600
	    // Expected: Invalid year: 2025, expected range 1700-2024
	    System.out.println("------ TestCase 17 ------ ");
	    
	    try {
	        DateUtil date = new DateUtil(13, 11, 1600);
	      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
	        Assert.fail("No exception thrown for invalid day.");
	    } catch (RuntimeException e) {
	        // Capture the exception message and print it
	        System.out.println("Caught exception: " + e.getMessage());
	        // Check if the exception message contains the expected error message
	        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid year: 1600, expected range 1700-2024"));
	    }
	}
	
	
	/**** Table 2 Testing Cases ***/
	
	@Test
	public void testJune1ShouldIncrementToJune2() {
	    // Test Case ID: 1B
	    // Value: 1/6/1994
	    // Expected: 2/6/1994
	    System.out.println("------ TestCase 1B ------ ");
	    DateUtil date = new DateUtil(1, 6, 1994);
	    System.out.print("testJune1ShouldIncrementToJune2 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune2ShouldIncrementToJune3() {
	    // Test Case ID: 2B
	    // Value: 2/6/1994
	    // Expected: 3/6/1994
	    System.out.println("------ TestCase 2B ------ ");
	    DateUtil date = new DateUtil(2, 6, 1994);
	    System.out.print("testJune2ShouldIncrementToJune3 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune15ShouldIncrementToJune16() {
	    // Test Case ID: 3B
	    // Value: 15/6/1994
	    // Expected: 16/6/1994
	    System.out.println("------ TestCase 3B ------ ");
	    DateUtil date = new DateUtil(15, 6, 1994);
	    System.out.print("testJune15ShouldIncrementToJune16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJune30ShouldIncrementToJuly1() {
	    // Test Case ID: 4B
	    // Value: 30/6/1994
	    // Expected: 1/7/1994
	    System.out.println("------ TestCase 4B ------ ");
	    DateUtil date = new DateUtil(30, 6, 1994);
	    System.out.print("testJune30ShouldIncrementToJuly1 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJan15ShouldIncrementToJan16() {
	    // Test Case ID: 6B
	    // Value: 15/1/1994
	    // Expected: 16/1/1994
	    System.out.println("------ TestCase 6B ------ ");
	    DateUtil date = new DateUtil(15, 1, 1994);
	    System.out.print("testJan15ShouldIncrementToJan16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testFeb15ShouldIncrementToFeb16() {
	    // Test Case ID: 7B
	    // Value: 15/2/1994
	    // Expected: 16/2/1994
	    System.out.println("------ TestCase 7B ------ ");
	    DateUtil date = new DateUtil(15, 2, 1994);
	    System.out.print("testFeb15ShouldIncrementToFeb16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testNov15ShouldIncrementToNov16() {
	    // Test Case ID: 8B
	    // Value: 15/11/1994
	    // Expected: 16/11/1994
	    System.out.println("------ TestCase 8B ------ ");
	    DateUtil date = new DateUtil(15, 11, 1994);
	    System.out.print("testNov15ShouldIncrementToNov16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testDec15ShouldIncrementToDec16() {
	    // Test Case ID: 9B
	    // Value: 15/12/1994
	    // Expected: 16/12/1994
	    System.out.println("------ TestCase 9B ------ ");
	    DateUtil date = new DateUtil(15, 12, 1994);
	    System.out.print("testDec15ShouldIncrementToDec16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	@Test
	public void testJun15ShouldIncrementToJun16() {
	    // Test Case ID: 10B
	    // Value: 15/6/1700
	    // Expected: 16/6/1700
	    System.out.println("------ TestCase 10B ------ ");
	    DateUtil date = new DateUtil(15, 6, 1700);
	    System.out.print("testJun15ShouldIncrementToJun16 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	@Test
	public void testJun15ShouldIncrementToJun16LeapYear() {
	    // Test Case ID: 11B
	    // Value: 15/6/1701 (Leap Year)
	    // Expected: 16/6/1701
	    System.out.println("------ TestCase 11B ------ ");
	    DateUtil date = new DateUtil(15, 6, 1701);
	    System.out.print("testJun15ShouldIncrementToJun16LeapYear > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}

	@Test
	public void testJun15ShouldIncrementToJun16Year2023() {
	    // Test Case ID: 12B
	    // Value: 15/6/2023
	    // Expected: 16/6/2023
	    System.out.println("------ TestCase 12B ------ ");
	    DateUtil date = new DateUtil(15, 6, 2023);
	    System.out.print("testJun15ShouldIncrementToJun16Year2023 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	@Test
	public void testJun15ShouldIncrementToJun16LeapYear2024() {
	    // Test Case ID: 13B
	    // Value: 15/6/2024 (Leap Year)
	    // Expected: 16/6/2024
	    System.out.println("------ TestCase 13B ------ ");
	    DateUtil date = new DateUtil(15, 6, 2024);
	    System.out.print("testJun15ShouldIncrementToJun16LeapYear2024 > Input:" + date + " Output:");
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	
	/**** Credit Task ********/
	
	//Equivalence class testing 
	 @Test
	    public void testValidDayD1Icrement() {
	        // Test Case ID: D1
	        // Value: 15/6/2024
	        // Expected: 16/6/2024
	        System.out.println("------ TestCase D1 ------ ");
	        DateUtil date = new DateUtil(15, 6, 2024);
	        System.out.print("testValidDayD1 > Input:" + date + " Output:");
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(16, date.getDay());
	        Assert.assertEquals(6, date.getMonth());
	        Assert.assertEquals(2024, date.getYear());
	    }
	 
	 @Test
	    public void testValidDayD2Increment() {
	        // Test Case ID: D2
	        // Value: 28/11/2024
	        // Expected: 29/11/2024
	        System.out.println("------ TestCase D2 ------ ");
	        DateUtil date = new DateUtil(28, 11, 2024);
	        System.out.print("testValidDayD2 > Input:" + date + " Output:");
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(29, date.getDay());
	        Assert.assertEquals(11, date.getMonth());
	        Assert.assertEquals(2024, date.getYear());
	    }
	 
	 @Test
	    public void testValidDayD3Increment() {
	        // Test Case ID: D3
	        // Value: 28/2/2024
	        // Expected: 29/2/2024
	        System.out.println("------ TestCase D3 ------ ");
	        DateUtil date = new DateUtil(28, 2, 2024);
	        System.out.print("testValidDayD3 > Input:" + date + " Output:");
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(29, date.getDay());
	        Assert.assertEquals(2, date.getMonth());
	        Assert.assertEquals(2024, date.getYear());
	    }
	    @Test
	    public void testValidDayD4Increment() {
	        // Test Case ID: D4
	        // Value: 30/5/2024
	        // Expected: 31/5/2024
	        System.out.println("------ TestCase D4 ------ ");
	        DateUtil date = new DateUtil(30, 5, 2024);
	        System.out.print("testValidDayD4 > Input:" + date + " Output:");
	        date.increment();
	        System.out.println(date);
	        Assert.assertEquals(31, date.getDay());
	        Assert.assertEquals(5, date.getMonth());
	        Assert.assertEquals(2024, date.getYear());
	    }
	    @Test
	    public void testInvalidDayZeroAndBelow() {
		    // Value: 0/6/1994
		    // Expected: Invalid day: 32, expected range 1-31
		    System.out.println("------ TestCase D0 ------ ");
		    
		    try {
		        DateUtil date = new DateUtil(0, 6, 1994);
		      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
		        Assert.fail("No exception thrown for invalid day.");
		    } catch (RuntimeException e) {
		        // Capture the exception message and print it
		        System.out.println("Caught exception: " + e.getMessage());
		        // Check if the exception message contains the expected error message
		        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid day: 0, expected range 1-31"));
		    }
	    }
	    @Test
	    public void testInvalidDay32AndAbove() {
		    // Value: 32/6/1994
		    // Expected: Invalid day: 32, expected range 1-31
		    System.out.println("------ TestCase D5 ------ ");
		    
		    try {
		        DateUtil date = new DateUtil(32, 6, 1994);
		      //  System.out.print("testInvalidDayForDay32 > Input:" + date + " Output:");
		        Assert.fail("No exception thrown for invalid day.");
		    } catch (RuntimeException e) {
		        // Capture the exception message and print it
		        System.out.println("Caught exception: " + e.getMessage());
		        // Check if the exception message contains the expected error message
		        Assert.assertTrue("Invalid day error message not found.", e.getMessage().contains("Invalid day: 32, expected range 1-31"));
		    }
	    }




	
}