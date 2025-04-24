package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptNavigations {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Business Task:
//			1.	Launch the browser.
//			2.	Navigate to https://naveenautomationlabs.com/opencart/.
//			3.  Click on My Account
//			4.  Click on Login
//			5.	Navigate backward.
//			6. 	Navigate forward.
//			7.	Reload the page.
//			8.  Navigate backward.
//			9.	Close the browser.
//			10.	Create utilities for each of them.
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		System.out.println("Page Title : " + driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login"));
		System.out.println("Page Title : " + driver.getTitle());
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(-1)");
		System.out.println("Page Title : " + driver.getTitle());
		Thread.sleep(2000);
		js.executeScript("history.go(1)");
		System.out.println("Page Title : " + driver.getTitle());
		js.executeScript("history.go(0)");
		js.executeScript("history.go(-1)");
		System.out.println("Page Title : " + driver.getTitle());
		driver.close();
		

	}
	
//	Utilities
	public static void goBackWithJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(-1)");
	}
	
	public static void goForwardWithJs() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(1)");
	}
	
	public static void refreshWithJs() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

}
