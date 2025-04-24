package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	static WebDriver driver;

	public static void main(String[] args) {

		// Automation Steps
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login
//		3.	Send these keys into the "E-Mail Address" input field. "Sabawoon@stech.com," as long as there is a half-second pause between each letter being passed to the input field.
//		4.	Send these keys into the "Password" input field. "SabawoonAutomation119$," as long as there is a half-second pause between each letter being passed to the password input field.
//		5.	Click on "Login."
//		6.	Close the driver.
//		7.	Develop a utility for it.

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement userName = driver.findElement(By.id("input-email"));
		WebElement pwd = driver.findElement(By.id("input-password"));

		Actions act = new Actions(driver);
		
//Rough Code Approach
//		String value = "Sabawoon@stech.com";
//		char val[] = value.toCharArray();
//		for (char c : val) {
//			act.sendKeys(userName, String.valueOf(c)).pause(500).build().perform();
//
//		}
//
//		act.click(driver.findElement(By.xpath("//input[@type='submit']"))).perform();
//		driver.close();

		
		// Using Utility Approach
		By emailID = By.id("input-email");
		doSendKeysWithPause(emailID, "Yuonus@stech.com");
	}

	// Utilities
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for (char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();

		}
	}
}
