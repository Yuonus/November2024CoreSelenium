package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
//		Automation steps:
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//		3.	Capture the page title using the Javascript executor.
//		4.	Capture the page URL using the Javascript executor.
//		5.	Create utilities for both title & URL.

		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// JavaScriptExecutor is an Interface.  RemoteWebDriver class provides implementation to this interface.
		// JavaScriptExecutor has executeScript() method, this method has one parameter, 1: String script 
		// Script will be executed on the browser -- page
		
		
//		Rough Code Approach
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		String pageTitle = (String) js.executeScript("return document.title");
//		// You can use .toString() to convert the JavaScript string into normal string.
//		String pageTitle = js.executeScript("return document.title").toString();
//		System.out.println("Page title is: " + pageTitle);
//		
//		String pageURL = js.executeScript("return document.URL").toString();
//		System.out.println("The page URL is: " + pageURL);
		
		// Using Utility Approach
		String pTitle = getTitleByJs();
		System.out.println(pTitle);
		
		String pURL = getUrlByJs();
		System.out.println(pURL);
	}
	
	// Utilities
	public static String getTitleByJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}
	
	public static String getUrlByJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.URL").toString();
	}

}
