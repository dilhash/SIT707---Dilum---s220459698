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
        //sleep(5);
        
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
        //sleep(5);

    }
    
    @Test
    public void testLoginSuccessforValidUsernameandValidPassword() {
        System.out.println("++++++Test Case 2 - Successfull Login ++++++");
        driver.navigate().to("http://localhost:8080/login");
        //sleep(5);

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
     		
     		//sleep(5);
     		
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
        //sleep(10);
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
        //sleep(10);
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
        //sleep(10);
        submitButton.click();
      
        Assert.assertEquals("http://localhost:8080/login", driver.getCurrentUrl());
        // Wait for the message element to be present on the page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'All questions Answered! Thank you for the participation')]")));
        //sleep(5);
        Assert.assertEquals("All questions Answered! Thank you for the participation", messageElement.getText());
    
    }
    /*** end of Happy path Testing ***/
    
    /*** Login page failure testing***/ 
    @Test
    public void testLoginFailureforValidUsernameandInvalidPassword() {
    	System.out.println("++++++Test Case 6 - Failure - Login - Valid Username - Invalid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        //sleep(5);

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
            //sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		//sleep(5);
    }
    
    @Test
    public void testLoginFailureforInValidUsernameandValidPassword() {
    	System.out.println("++++++Test Case 7 - Failure - Login - InValid Username - Valid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        //sleep(5);

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
            //sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		//sleep(5);
    }
    
    @Test
    public void testLoginFailureforInValidUsernameandInvalidPassword() {
    	System.out.println("++++++Test Case 8 - Failure - Login - InValid Username - Invalid Password ++++++");
        driver.navigate().to("http://localhost:8080/login");
        //sleep(5);

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
            //sleep(5);
            Assert.assertEquals("Incorrect credentials.", messageElement.getText());
        
     		//sleep(5);
    }
    
    /*** Q1 page failure testing***/ 
    @Test
    public void testValidNumbersandIncorrectResultForQ1(){
    	System.out.println("++++++Test Case 9 - Incorrect Results of Q1 ++++++");
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "115";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong answer, try again.", messageElement.getText());
    
 		//sleep(5);
    	
    }
    @Test
    public void testInValidNumber12andInValidResultForQ1(){
    	System.out.println("++++++Test Case 10 - QA1 -  Invalid Number 1  - Invalid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "two";
        String secondNumber = "three";
        String result = "five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1ForQ1(){
    	System.out.println("++++++Test Case 11 - QA1 -  Invalid Number 1  - Valid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "ten";
        String secondNumber = "10";
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
	}
    @Test
    public void testInValidNumber2ForQ1(){
    	System.out.println("++++++Test Case 12 - QA1 -  Invalid Number 2  - Valid number 1 - Valid Results  ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "zero";
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidResultForQ1(){
    	System.out.println("++++++Test Case 13 - QA1 -  Valid Number 1  - Valid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "10";
        String result = "Twenty Five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber12tForQ1(){
    	System.out.println("++++++Test Case 14 - QA1 -  InValid Number 1  - InValid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "Two";
        String result = "25";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1andInvalidResulttForQ1(){
    	System.out.println("++++++Test Case 15 - QA1 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "2";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    	
    
   }
    @Test
    public void testInValidNumber2andInvalidResulttForQ1(){
    	System.out.println("++++++Test Case 16 - QA1 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "90";
        String secondNumber = "Hundred";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    
    /*** Q2 page failure testing***/ 
    @Test
    public void testValidNumbersandIncorrectResultForQ2(){
    	System.out.println("++++++Test Case 17 - Incorrect Results of Q2 ++++++");
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "115";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong answer, try again.", messageElement.getText());
    
 		//sleep(5);
    	
    }
    @Test
    public void testInValidNumber12andInValidResultForQ2(){
    	System.out.println("++++++Test Case 13 - QA2 -  Invalid Number 1  - Invalid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "two";
        String secondNumber = "three";
        String result = "five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1ForQ2(){
    	System.out.println("++++++Test Case 15 - QA2 -  Invalid Number 1  - Valid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "ten";
        String secondNumber = "10";
        String result = "15";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
	}
    @Test
    public void testInValidNumber2ForQ2(){
    	System.out.println("++++++Test Case 17 - QA2 -  Invalid Number 2  - Valid number 1 - Valid Results  ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "zero";
        String result = "15";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidResultForQ2(){
    	System.out.println("++++++Test Case 18 - QA2 -  Valid Number 1  - Valid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "10";
        String result = "Twenty Five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber12tForQ2(){
    	System.out.println("++++++Test Case 19 - QA2 -  InValid Number 1  - InValid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "Two";
        String result = "25";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1andInvalidResulttForQ2(){
    	System.out.println("++++++Test Case 20 - QA2 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "2";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    	
    
   }
    @Test
    public void testInValidNumber2andInvalidResulttForQ2(){
    	System.out.println("++++++Test Case 21 - QA2 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "90";
        String secondNumber = "Hundred";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    

    
    /*** Q3 page failure testing***/ 
    @Test
    public void testValidNumbersandIncorrectResultForQ3(){
    	System.out.println("++++++Test Case 22 - Incorrect Results of Q3 ++++++");
        // Input
        String firstNumber = "10";
        String secondNumber = "5";
        String result = "115";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong answer, try again.", messageElement.getText());
    
 		//sleep(5);
    	
    }
    @Test
    public void testInValidNumber12andInValidResultForQ3(){
    	System.out.println("++++++Test Case 23 - QA3 -  Invalid Number 1  - Invalid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "two";
        String secondNumber = "three";
        String result = "five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1ForQ3(){
    	System.out.println("++++++Test Case 24 - QA3 -  Invalid Number 1  - Valid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "ten";
        String secondNumber = "10";
        String result = "15";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
	}
    @Test
    public void testInValidNumber2ForQ3(){
    	System.out.println("++++++Test Case 25 - QA3 -  Invalid Number 2  - Valid number 1 - Valid Results  ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "zero";
        String result = "15";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidResultForQ3(){
    	System.out.println("++++++Test Case 26 - QA3 -  Valid Number 1  - Valid number 2 - Invalid Results ++++++");
        // Input
        String firstNumber = "15";
        String secondNumber = "10";
        String result = "Twenty Five";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber12tForQ3(){
    	System.out.println("++++++Test Case 27 - QA3 -  InValid Number 1  - InValid number 2 - Valid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "Two";
        String result = "25";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    @Test
    public void testInValidNumber1andInvalidResulttForQ3(){
    	System.out.println("++++++Test Case 28 - QA3 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "One";
        String secondNumber = "2";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    	
    
   }
   
    @Test
    public void testInValidNumber2andInvalidResulttForQ3(){
    	System.out.println("++++++Test Case 28 - QA3 -  InValid Number 1  - Valid number 2 - InValid Results ++++++");
        // Input
        String firstNumber = "90";
        String secondNumber = "Hundred";
        String result = "three";
        
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
        //sleep(5);
        submitButton.click();
 
        //waiting for error messsage
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Wrong inputs, try again.')]")));
        //sleep(5);
        Assert.assertEquals("Wrong inputs, try again.", messageElement.getText());
    
    
 		//sleep(5);
    }
    

}
