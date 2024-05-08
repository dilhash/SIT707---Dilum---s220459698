package sit707_week2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BunningsLoginServiceTest {

    @Test
    public void testInvalidUsernameValidPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.get("https://www.bunnings.com.au/login");

        // Enter invalid username
        WebElement usernameElement = driver.findElement(By.id("okta-signin-username"));
        usernameElement.sendKeys("invalid_username");

        // Enter valid password
        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
        passwordElement.sendKeys("P@ssw0rd");

        // Click sign in button
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Wait for error message
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("okta-form-infobox-error")));

        // Assert that error message contains the expected text
        String expectedErrorMessage = "Your email address or password is incorrect.";
        Assert.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
        driver.close();
    }

    @Test
    public void testValidUsernameInvalidPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.get("https://www.bunnings.com.au/login");

        // Enter valid username
        WebElement usernameElement = driver.findElement(By.id("okta-signin-username"));
        usernameElement.sendKeys("s220459698@deakin.edu.au");

        // Enter invalid password
        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
        passwordElement.sendKeys("invalid_password");

        // Click sign in button
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Wait for error message
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("okta-form-infobox-error")));

        // Assert that error message contains the expected text
        String expectedErrorMessage = "Your email address or password is incorrect.";
        Assert.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
        driver.close();
    }

    @Test
    public void testInvalidUsernameInvalidPassword() {
        System.setProperty("webdriver.chrome.driver", "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.get("https://www.bunnings.com.au/login");

        // Enter invalid username
        WebElement usernameElement = driver.findElement(By.id("okta-signin-username"));
        usernameElement.sendKeys("invalid_username");

        // Enter invalid password
        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
        passwordElement.sendKeys("invalid_password");

        // Click sign in button
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Wait for error message
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("okta-form-infobox-error")));

        // Assert that error message contains the expected text
        String expectedErrorMessage = "Your email address or password is incorrect.";
        Assert.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
        driver.close();
    }

    @Test
    public void testValidUsernameValidPassword() {
        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/dilumbal/Library/CloudStorage/OneDrive-Personal/Deakin/SIT707/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.get("https://www.bunnings.com.au/login");

        // Find email element
        WebElement emailElement = driver.findElement(By.id("okta-signin-username"));
        emailElement.clear();
        emailElement.sendKeys("s220459698@deakin.edu.au");

        // Find password element
        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
        passwordElement.clear();
        passwordElement.sendKeys("P@ssw0rd");

        // Find Sign in button, and click on button.
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();

        // Wait until the current URL changes to https://www.bunnings.com.au
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.bunnings.com.au"));

        // Check if login was successful
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Assert.assertEquals("https://www.bunnings.com.au", currentUrl);

        driver.close();
    }
}
