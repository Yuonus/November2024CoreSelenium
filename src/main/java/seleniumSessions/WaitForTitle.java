package seleniumSessions;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WaitForTitle {

	static WebDriver driver;
	public static void main(String[] args) {
		
//		Task:
//			1.	Launch the browser.
//			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//			3.	Click on "About us.".
//			4.	Wait 5 seconds for the title to be loaded and then capture it.
//			5.	Close the browser.
//			6.	Create a generic method for it and move it to the ElementUtil class.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By aboutUsLink = By.linkText("About Us");
		driver.findElement(aboutUsLink).click();
		
		// Rough Code Approach
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.titleContains("About"))) {
//			System.out.println("The page title is: " + driver.getTitle());
//		}else {
//			System.out.println("The page title is not present");
//		}
		
		// Utility Approach
//		String pageTitle = waitForTitleContains("Aboutdd", 5);
//		System.out.println("The page title is: " + pageTitle);
		
		// checking complete title
		String pTitle = waitForTitleIs("About Us ", 5);
		System.out.println("The page title is: " + pTitle);

		driver.close();
	}
	
	// Utility 
	public static String waitForTitleContains(String titleFractionString, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try {
		if(wait.until(ExpectedConditions.titleContains(titleFractionString))) {
			return driver.getTitle();
		}
		}
		catch(TimeoutException e) {
			System.out.println(titleFractionString + " : The page title is not present. ...");
			e.printStackTrace();
		}
		return null;
	}
	
	// Utility for checking the exact/full title. --- not passing the substring/partial/fraction of the page title
	public static String waitForTitleIs(String fullTitleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try {
		if(wait.until(ExpectedConditions.titleIs(fullTitleValue))) {
			return driver.getTitle();
		}
		}
		catch(TimeoutException e) {
			System.out.println(fullTitleValue + " : The page title is not present. ...");
			e.printStackTrace();
		}
		return null;
	}
	
	// Utility for URL
	public static String waitForURLContains(String urlFractionString, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try {
		if(wait.until(ExpectedConditions.urlContains(urlFractionString))) {
			return driver.getCurrentUrl();
		}
		}
		catch(TimeoutException e) {
			System.out.println(urlFractionString + " : The page URL is not present. ...");
			e.printStackTrace();
		}
		return null;
	}
	
	// Utility for checking the exact/full URL. --- not passing the substring/partial/fraction of the page URL
	public static String waitForURLToBe(String fullURLValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try {
		if(wait.until(ExpectedConditions.urlToBe(fullURLValue))) {
			return driver.getCurrentUrl();
		}
		}
		catch(TimeoutException e) {
			System.out.println(fullURLValue + " : The page URL is not present. ...");
			e.printStackTrace();
		}
		return null;
	}
	
}
