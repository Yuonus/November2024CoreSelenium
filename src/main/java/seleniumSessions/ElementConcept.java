package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
//		Test Scenarios:
//		1.	Launch the browser
//		2.	Launch the URL https://naveenautomationlabs.com/opencart/index.php?route=account/login
//		3.	Fetch the page title
//		4.	Enter the email id 
//		5.  Enter the password.
		
		/*	Formula
		 * 	1: Inspect the page
		 *  2: Locate/create webElement ? driver.findElement();
		 *  3: Perform some actions
		 */
		
		driver = new ChromeDriver();  // Abbreviation = CTRL + SHIFT + O
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println("The page title is: " + driver.getTitle());
		
		
		// 1st approach 
		// 50
//		driver.findElement(By.id("input-email")).sendKeys("Sabawoon@stech.com");
//		driver.findElement(By.id("input-password")).sendKeys("SeleniumIsEasy");
		
		// 2nd Approach:
//		WebElement emailID = driver.findElement(By.id("input-email"));
//		emailID.sendKeys("Sabawoon@gmail.com");
//		emailID.clear();
//
//		WebElement password = driver.findElement(By.id("input-password"));
//		password.sendKeys("Test123");
//		password.clear();
//		
//		emailID.sendKeys("Javed@stech.com");
//		password.sendKeys("1234556");
		
		// 3rd Approach: By Locator
//		By eID = By.id("input-email");
//		By pWD = By.id("input-password");
//
//		WebElement emailID = driver.findElement(eID);
//		WebElement password = driver.findElement(pWD);
//		
//		emailID.sendKeys("Sabawoon@stech.com");
//		password.sendKeys("SeleniumIseasy");
		
		// 4th Approach: By locator + Generic method for element
//		By eID = By.id("input-email");
//		By pWD = By.id("input-password");
//		
//		getElement(eID).sendKeys("Sabawoon@stech.com");
//		getElement(pWD).sendKeys("SeleniumIseasy");
		
		// 5th Approach: By locator + Generic method for element + Action
//		By eID = By.id("input-email");
//		By pWD = By.id("input-password");
//		
//		doSendKeys(eID, "Sabawoon@stech.com");
//		doSendKeys(pWD, "SeleniumIsEasy");
		
		// 6th Approach: By locator + Generic method for element and Action + in another util class
//		By eID = By.id("input-email");
//		By pWD = By.id("input-password");
//		
//		ElementUtils eleUtils = new ElementUtils(driver);
//		eleUtils.doSendKeys(eID, "Sabawoon@stech.com");
//		eleUtils.doSendKeys(pWD, "SeleniumIsEasy");
		
		// 7th approach: BrowserUtils + ElementUtils
		
		// 8th: By locator -- String Locator
		
		String email_id = "input-email";
		String password = "input-password";
		
		ElementUtils eleUtils = new ElementUtils(driver);
		eleUtils.doSendKeys("id", email_id, "sabawoon@hotmail.com");
		eleUtils.doSendKeys("id", password, "Selenium123");
		
		
		
		
		// 9th Approach: POM + Framework
		
		
		
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
}
