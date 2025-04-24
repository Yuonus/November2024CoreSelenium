package seleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		/*
		 	1: Usage? -- It is applied to a specific element 
		 	2: It can be used with both web elements + non-web elements
		 	3: It is a Dynamic wait
		 		WebDriverWait
		 		FluentWait
		 	4: Explicit wait is a concept of dynamic wait for specific web element  & non-web element on the basis of some conditions; this means there is no class, interface
		 	   or method for it.
		 	   
		Wait Hierarchy
		wait(I) until();  <--- FluentWait (class) until(){}; + other methods  <--- WebDriverWait (class)
		 */
//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Wait 5 seconds for the "E-Mail Address" element to be loaded completely. And send some keys
//			Test_data: sabawoon@stech.com
//		4.	Send some keys to the "Password" input field.
//			Test_data: S_Automation$$$
//		5.	Click on the "Login" button. 
	
//		6.	Create a utility for explicit wait, so you don’t need to repeat the wait code when needed to 
//			apply the wait for other elements.
//		7.	Using the utility, wait for the "About Us" link for 4 seconds to be loaded, and then click on it.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// By locators
		By emailID = By.id("input-email45");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit']");
		By aboutUsLink = By.linkText("About Us");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement emailID_Ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
//		emailID_Ele.sendKeys("sabawoon@stech.com");
		waitForPresenceOfElement(emailID, 5).sendKeys("sabawoon@stech.com");
		
		
		// E1 --- 5 SECONDS  --
		// E1  -- 2 seconds
		// E1 -- 3 Remaining seconds  == ignored/cancelled
		
//		In Q: implicit wait vs. explicit wait exception-wise
		// implicit wait == NoSuchElementException
		// explicit wait =  TimeOutException + NoSuchElementException
		
		driver.findElement(password).sendKeys("S_Automation$$$");
		driver.findElement(loginBtn).click();
		
//		waitForPresenceOfElement(aboutUsLink, 4).click();
		waitForVisbilityOfElement(aboutUsLink, 4).click();
	}
	
	// Utilities
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForVisbilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void doClickWithWait(By locator, int timeOut) {
		waitForVisbilityOfElement(locator, timeOut).click();
	}
	
	public static void doSendKeysWithWait(By locator, String value, int timeOut) {
		waitForVisbilityOfElement(locator, timeOut).sendKeys(value);
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

}
