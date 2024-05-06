package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		driver.navigate().to(
				"file:///Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/Git%20Repo/SIT707---Dilum---s220459698/8.1P/8.1P-resources/pages/login.html");
		sleep(5);
		
		// Find username element
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("dilum");
		
		// Find password element
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("dilum_pass");
		
		// Find DoB element
	    WebElement dob = driver.findElement(By.id("dob")); 
	    dob.clear();
	    dob.sendKeys("11/11/2000");
		
		// Find Submit button, and click on button.
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertEquals(title, "success");
		
		driver.close();
	}
	
	  @Test
	  public void testLoginFailInvalidPassword() {
			System.setProperty(
					"webdriver.chrome.driver", 
					"/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");
			
			WebDriver driver = new ChromeDriver();		
			System.out.println("Driver info: " + driver);
			
			driver.navigate().to(
					"file:///Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/Git%20Repo/SIT707---Dilum---s220459698/8.1P/8.1P-resources/pages/login.html");
			sleep(5);

	    // Find username element
	    WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    username.sendKeys("dilum");

	    // Find password element
	    WebElement password = driver.findElement(By.id("passwd"));
	    password.clear();
	    password.sendKeys("wrong_password"); // Invalid password

	    // Find DoB element
	    WebElement dob = driver.findElement(By.id("dob")); 
	    dob.clear();
	    dob.sendKeys("11/11/2000");

	    // Find Submit button, and click on button.
	    WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	    submitButton.submit();

	    sleep(5);

	    WebElement errorMessage = driver.findElement(By.id("error-message"));
	    Assert.assertTrue(errorMessage.isDisplayed());
	    String title = driver.getTitle();
		System.out.println("Title: " + title);
		
	    Assert.assertEquals(title, "fail");

	    driver.close();
	  }
	
	
}
