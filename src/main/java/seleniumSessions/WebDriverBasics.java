package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		/*	Manual steps
		 * 1: Launch/open browser
		 * 2: Open the URL
		 * 3: Fetch the page title
		 * 4: Verify the page title
		 * 5: Fetch the page URL
		 * 6: Verify this page URL
		 * 7: Get/Fetch the source of the page
		 * 8: Verify a few words in this page source
		 * 5: Close the browser
		 * 
		 * Automate ?
		 */
		
		// Automation steps
//		ChromeDriver driver = new ChromeDriver();
//		FirefoxDriver driver = new FirefoxDriver();
//		EdgeDriver driver = new EdgeDriver();
		
		
		// chrome, firefox, edge
		
		String browser = "     chrome     ";
		
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;	
		case "safari":
			driver = new SafariDriver();
			break;	

		default:
			System.out.println("Please pass the right browser ...");
			break;
		}
		
		
		driver.get("https://www.google.com");
		String actualPageTitle = driver.getTitle();
		System.out.println("The page title is: " + actualPageTitle);
		
		// Verification points / check points / Actual Result vs Expected Result
		// Automation steps + Verification points  == automation testing
		if(actualPageTitle.equals("Google")) {
			System.out.println("The page title is correct --- Test Passed.");
		} else {
			System.out.println("The page title is incorrect --- Test Failed");
		}
		
		//https://www.google.com/
		String pageURL = driver.getCurrentUrl();
		System.out.println("The page current URL is: " + pageURL);
		
		if(pageURL.contains("google")) {
			System.out.println("The page URL contains the searched word --- Test Passed.");
		}else {
			System.out.println("The page URL is not having the searched word -- Test failed.");
		}
	
		String pageSource = driver.getPageSource();
		System.out.println("The page source is: " + pageSource);
		
		if(pageSource.contains("Copyright The Closure Library Authors.")) {
			System.out.println("The page source contain the entered sentence --- Test passed.");
		}else {
			System.out.println("TEST FAILED.");
		}
	
		
		driver.close();
	}

}
