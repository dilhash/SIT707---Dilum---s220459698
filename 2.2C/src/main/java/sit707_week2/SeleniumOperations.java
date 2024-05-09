package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		
		captureScreenshot(driver);
		
		// Sleep a while
		sleep(120);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void officework_locatorAPI(String url) {
		
		  // Set ChromeDriver path (assuming it's in your system PATH)
        System.setProperty("webdriver.chrome.driver", "/Users/dilumbal/Downloads/chromedriver-mac-arm64/chromedriver");

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Your test code goes here
        // For example:
        try {
            driver.get(url);

            // Identify elements using relative locators
            WebElement emailField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.id("password")));
            System.out.println("Found email field element.");
            WebElement phoneNumberField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(emailField));
            System.out.println("Found phoneNumberField field element.");
            WebElement lastNameField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(phoneNumberField));
            System.out.println("Found last name field element.");
            WebElement firstNameField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastNameField));
            System.out.println("Found first name field element.");
           
            
           // WebElement firstNameField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(emailField));
            //System.out.println("Found first name field element.");
            //WebElement lastNameField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(firstNameField));
            //System.out.println("Found last name field element.");
            
            WebElement passwordField = driver.findElement(By.id("password"));
            System.out.println("Found password field element.");
            WebElement confirmpasswordField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(passwordField));
            System.out.println("Found confirm password field element.");
            //WebElement phoneNumberField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(passwordField));
            //System.out.println("Found phone number field element.");
            WebElement createAccountButton = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
            System.out.println("Found create account button element.");

            // Fill values in target elements
            firstNameField.sendKeys("John"); // Clearing the first name field
            System.out.println("Entered First name: Dilum");
            lastNameField.sendKeys("Doe");
            System.out.println("Entered last name: Balaarachchi");
            phoneNumberField.sendKeys("1234567890");
            System.out.println("Entered phone number: 1234567890");
            emailField.sendKeys("jon.doe@gmail.com");
            System.out.println("Entered email: hashi.dilumi@gmail.com");
            passwordField.sendKeys("P@ssw0rd12345");
            System.out.println("Entered password: P@ssw0rd1234");
            confirmpasswordField.sendKeys("P@ssw0rd12345");
            System.out.println("Entered password: P@ssw0rd124");

            // Click the "Create account" button
            createAccountButton.click();
            System.out.println("Clicked create account button.");
            

    		captureScreenshot(driver);
    		
            sleep (10);//so the browser won't close right away

            //Close the browser
            driver.close();
            System.out.println("Closed Chrome browser.");
          } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
          } finally {
            driver.quit();
          }
        
        
	}
	
	
	public static void facebook_signup_page(String url) {

		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty(
				"webdriver.chrome.driver", 
				"/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
	//	sleep(10);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		
		// Find and fill first name field
        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        System.out.println("Found element: " + firstNameElement);
        firstNameElement.sendKeys("Dilum");

        // Find and fill surname field
        WebElement surnameElement = driver.findElement(By.name("lastname"));
        System.out.println("Found element: " + surnameElement);
        surnameElement.sendKeys("Balaarachchi");

        // Find and fill email or phone field
        WebElement emailElement = driver.findElement(By.name("reg_email__"));
        System.out.println("Found element: " + emailElement);
        emailElement.sendKeys("hashi.dilumi@example.com");
        
        
        WebElement reEnterEmailElement = driver.findElement(By.name("reg_email_confirmation__"));
        System.out.println("Found element: " + reEnterEmailElement);
        reEnterEmailElement.sendKeys("hashi.dilumi@example.com");
        

        // Find and fill password field
        WebElement passwordElement = driver.findElement(By.name("reg_passwd__"));
        System.out.println("Found element: " + passwordElement);
        passwordElement.sendKeys("password123");

        // Select birthday
        WebElement dayElement = driver.findElement(By.id("day"));
        dayElement.sendKeys("11");

        WebElement monthElement = driver.findElement(By.id("month"));
        monthElement.sendKeys("Apr");

        WebElement yearElement = driver.findElement(By.id("year"));
        yearElement.sendKeys("1994");

        System.out.println("Found element: " + dayElement + " " +monthElement + " " + yearElement);
        
        // Select gender
        WebElement genderElement = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        genderElement.click(); // Assuming Female is represented by value 1

        // Find and click Sign Up button
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();
        
    	
		captureScreenshot(driver);
			
		
		// Sleep a while
		sleep(60);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void captureScreenshot(WebDriver driver) {
        // Get the current timestamp
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String timestamp = formatter.format(date);

        // Define the directory path to save the screenshot
        String directoryPath = "src/main/img/";

        try {
            // Capture screenshot
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create the directory if it doesn't exist
            Path path = Paths.get(directoryPath);
            Files.createDirectories(path);

            // Save the screenshot with timestamp as filename
            String screenshotPath = directoryPath + "screenshot_" + timestamp + ".png";
            Files.move(screenshotFile.toPath(), Paths.get(screenshotPath));

            System.out.println("Screenshot captured and saved at: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }	
}
