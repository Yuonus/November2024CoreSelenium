package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWithIntervalTime {

	static WebDriver driver;
	public static void main(String[] args) {

//	Business case
//	1.	Launch the browser.
//	2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//	3.	Wait 10 seconds for the "E-Mail Address" element to be loaded completely. And send some keys. Give an interval time of 2 seconds for each attempt.
//		Test_data: Sabawoon@stech.com
//	4.	Repeat step #3 with the default polling time and observe the output.
//	5.	To observe the output of default polling and custom polling time through fluent wait, make the value of the "E-Mail Address" element locator wrong.
//	6.	Create a utility for it and move it to the ElementUtil class.
//	7.	Close the browser.

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// By locators
		By emailID = By.id("input-email119");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");
		By aboutUsLink = By.linkText("About Us");
		
		// Rough Code Approach
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10/0.5  -- 20 attempts			--- each attempts will take 500 milli seconds
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9), Duration.ofSeconds(2));   // 10/2  -- 5 attempts  --> seconds 2 seconds 
//		
//		WebElement emailID_Ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));
//		emailID_Ele.sendKeys("Sabawoon@stech.com");

		// Utility Approach
		waitForPresenceOfElement(emailID, 10, 2);
	}
	
	
	// Creating the utilities
	public static WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	// We can also create one for visibility 
	public static WebElement waitForVisibilityOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
