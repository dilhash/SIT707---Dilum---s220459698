package web.service;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import web.MyServer;

public class TestMathQuestionService {
    
	private static Thread applicationThread;
	private static WebDriver driver;
	
	private static void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    @BeforeClass
    public static void setUp() {
    	// Starting the application
    	applicationThread = new Thread(() -> {
            MyServer.main(new String[]{});
        });
        applicationThread.start();
        
        System.setProperty(
                "webdriver.chrome.driver", 
                "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void shutDown() {
        if (driver != null) {
            driver.quit();
        }
        
        // Stop your application after all tests have been executed
        if (applicationThread != null) {
            applicationThread.interrupt();
            try {
                applicationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    /*** start of Happy path Testing ***/
    @Test
    public void testLoadHomePage() {
    	System.out.println("++++++Test Case 1 - Application Web URL Loads correclty ++++++");
        driver.navigate().to("http://localhost:8080/");
        sleep(5);
        
     // Assert the content on the home page
        
        // Assert the presence of the welcome message
        WebElement welcomeMessageElement = driver.findElement(By.tagName("h2"));
        Assert.assertEquals("Welcome", welcomeMessageElement.getText());
        
        
        // Assert the presence of the login link
        WebElement loginLinkElement = driver.findElement(By.xpath("//a[@href='/login']"));
        Assert.assertEquals("Login", loginLinkElement.getText());
        
        loginLinkElement.click();
        
        // Assert that the URL navigated to is the login page
        Assert.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
        sleep(5);

    }
    
    @Test
    public void testLoginSuccessforValidUsernameandValidPassword() {
        System.out.println("++++++Test Case 2 - Successfull Login ++++++");
        driver.navigate().to("http://localhost:8080/login");
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
     		
     		 Assert.assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
     		
     	}
    
    @Test
    public void testValidInputsValidResultForQ1() {
    	System.out.println("++++++Test Case 3 - Successful Results of Q1 ++++++");
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "15";
        
        // Navigate to q1 page
        driver.navigate().to("http://localhost:8080/q1");
        
        // Enter values in text boxes
        WebElement firstNumberInput = driver.findElement(By.id("number1"));
        WebElement secondNumberInput = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
       
        firstNumberInput.sendKeys(firstNumber);
        secondNumberInput.sendKeys(secondNumber);
        resultInput.sendKeys(result);
        sleep(10);
        submitButton.click();
 
        Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
    }
    
    @Test
    public void testValidInputsValidResultForQ2() {
    	System.out.println("++++++Test Case 4 - Successful Results of Q2 ++++++");
        
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "5";
        
        // Navigate to q1 page
        driver.navigate().to("http://localhost:8080/q2");
        
        // Enter values in text boxes
        WebElement firstNumberInput = driver.findElement(By.id("number1"));
        WebElement secondNumberInput = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
       
        firstNumberInput.sendKeys(firstNumber);
        secondNumberInput.sendKeys(secondNumber);
        resultInput.sendKeys(result);
        sleep(10);
        submitButton.click();
        
        Assert.assertEquals("http://localhost:8080/q3", driver.getCurrentUrl());
    }
    
    @Test
    public void testValidInputsValidResultForQ3() {
    	System.out.println("++++++Test Case 5 - Successful Results of Q3 ++++++");
    
        
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "50";
        
        // Navigate to q1 page
        driver.navigate().to("http://localhost:8080/q3");
        
        // Enter values in text boxes
        WebElement firstNumberInput = driver.findElement(By.id("number1"));
        WebElement secondNumberInput = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
       
        firstNumberInput.sendKeys(firstNumber);
        secondNumberInput.sendKeys(secondNumber);
        resultInput.sendKeys(result);
        sleep(10);
        submitButton.click();
      
        Assert.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
        // Wait for the message element to be present on the page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'All questions Answered! Thank you for the participation')]")));
        sleep(5);
        Assert.assertEquals("All questions Answered! Thank you for the participation", messageElement.getText());
    
    }
    /*** end of Happy path Testing ***/
    
    /*** Login page failure testing***/ 
    @Test
    public void testLoginFailureforValidUsernameandInvalidPassword() {
    	System.out.println("++++++Test Case 6 - Failure - Login - Valid Username - Invalid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        sleep(5);

     // Find username element
     		WebElement ele = driver.findElement(By.id("username"));
     		ele.clear();
     		ele.sendKeys("dilum");
     		
     		// Find password element
     		ele = driver.findElement(By.id("passwd"));
     		ele.clear();
     		ele.sendKeys("wrong_pass");
     		
     		// Find DoB element
     	    WebElement dob = driver.findElement(By.id("dob")); 
     	    dob.clear();
     	    dob.sendKeys("11/11/2000");
     		
     		// Find Submit button, and click on button.
     		ele = driver.findElement(By.cssSelector("[type=submit]"));
     		ele.submit();
     		
     		WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect credentials.')]")));
            sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		sleep(5);
    }
    
    @Test
    public void testLoginFailureforInValidUsernameandValidPassword() {
    	System.out.println("++++++Test Case 7 - Failure - Login - InValid Username - Valid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        sleep(5);

     // Find username element
     		WebElement ele = driver.findElement(By.id("username"));
     		ele.clear();
     		ele.sendKeys("John");
     		
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
     		
     		WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect credentials.')]")));
            sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		sleep(5);
    }
    
    @Test
    public void testLoginFailureforInValidUsernameandInvalidPassword() {
    	System.out.println("++++++Test Case 8 - Failure - Login - InValid Username - Invalid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        sleep(5);

     // Find username element
     		WebElement ele = driver.findElement(By.id("username"));
     		ele.clear();
     		ele.sendKeys("John");
     		
     		// Find password element
     		ele = driver.findElement(By.id("passwd"));
     		ele.clear();
     		ele.sendKeys("John_pass");
     		
     		// Find DoB element
     	    WebElement dob = driver.findElement(By.id("dob")); 
     	    dob.clear();
     	    dob.sendKeys("11/11/2000");
     		
     		// Find Submit button, and click on button.
     		ele = driver.findElement(By.cssSelector("[type=submit]"));
     		ele.submit();
     		
     		WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect credentials.')]")));
            sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		sleep(5);
    }
    
    /*** Q1 page failure testing***/ 
    //public void tesValidNumbersandIncorrectResultForQ1{}
    //public void testInValidNumber12andInValidResultForQ1{}
    //public void testInValidNumber1ForQ1{}
    //public void testInValidNumber2ForQ1{}
    //public void testInValidResultForQ1{}
    //public void testInValidNumber12tForQ1{}
    //public void testInValidNumber1andInvalidResulttForQ1{}
    //public void testInValidNumber2andInvalidResulttForQ1{}
    
}
