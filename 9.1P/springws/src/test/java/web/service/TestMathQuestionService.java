package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import web.MyServer;

public class TestMathQuestionService {
    
	private static Thread applicationThread;
	private WebDriver driver;
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @Before
    public void setUp() {
    	
    	//starting the application
    	applicationThread = new Thread(() -> {
            MyServer.main(new String[]{});
        });
        applicationThread.start();
        
        System.setProperty(
                "webdriver.chrome.driver", 
                "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        
        
     // Stop your application after all tests have been executed
        if (applicationThread != null) {
            applicationThread.interrupt();
            try {
                applicationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() {
        System.out.println("Driver info: " + driver);
        driver.navigate().to("http://localhost:8080/");
        sleep(10);
        // Your test steps here
    }
}
