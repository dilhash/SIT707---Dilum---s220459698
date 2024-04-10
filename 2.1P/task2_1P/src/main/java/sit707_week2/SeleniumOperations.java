package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty(
				"webdriver.chrome.driver", 
				"/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(10);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstnameelement = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstnameelement);
		// Send first name
		firstnameelement.sendKeys("Dilum");
		
		// Find last input field which is lastname
		WebElement lastnameelement = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastnameelement);
		// Send last name
		lastnameelement.sendKeys("Balaarachchi");
		
		WebElement emailElement = driver.findElement(By.id("email"));
		System.out.println("Found element: " + emailElement);
		emailElement.sendKeys("hashi.dilumi@gmail.com");
		
		WebElement passwordElement= driver.findElement(By.id("password"));
		System.out.println("Found element: " + passwordElement);
		passwordElement.sendKeys("P@ssw0rd12345"); 
		
		
		WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPasswordField);
		// Populate the "Confirm password" field with the desired value
		confirmPasswordField.sendKeys("ssw0rd12345");
		
		WebElement togglePasswordButton = driver.findElement(By.cssSelector("[data-testid='create-account-show-password-icon']"));
		// Click the toggle password visibility button to change the visibility of the password
		togglePasswordButton.click();
	
		
		// Find the "Create account" button by its data-testid attribute
		WebElement createAccountButton = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
		System.out.println("Found element: " + createAccountButton);
		// Click the "Create account" button to submit the form
		createAccountButton.click();

		
		
		
		// Sleep a while
		sleep(120);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
