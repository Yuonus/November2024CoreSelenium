package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickAndSendKeys {

	static WebDriver driver;
	public static void main(String[] args) {

//		Task:
//			1.	Launch the browser.
//			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
//			3.	Send these keys into the "E-Mail Address" input field. S_Tech@gmail.com
//			4.	Send these keys into the "Password" input field. SabawoonAutomation119$
//			5.	Click on "Login."
//			6.	Close the driver.
//			7.	Develop the utilities for them as well.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.id("input-email")), "S_Tech@gmail.com").perform();
		
		act.click(driver.findElement(By.xpath("//input[@type='submit']"))).perform();
		driver.close();
		
	}
	
	// Utilities
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}
		
		public static void doActionsSendKeys(By locator, String value) {
			Actions act = new Actions(driver);
			act.sendKeys(getElement(locator), value).build().perform();
		}
		
		public static void doActionsClick(By locator) {
			Actions act = new Actions(driver);
			act.click(getElement(locator)).build().perform();
		}

}
