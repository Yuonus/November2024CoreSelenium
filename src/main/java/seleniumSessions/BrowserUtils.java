package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * 
 * @author syuon
 * BrowserUtils is having multiple generic methods to handle various browser actions
 */
public class BrowserUtils {
	

	private WebDriver driver;
	
	/**
	 *  This method is used to launch the browser on the basis of given browserName
	 * @param browserName
	 * @return This utility returns the browser instance
	 */
	public  WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name : " + browserName);
		switch (browserName.toLowerCase().trim()) {
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
			throw new AutomationException("Invalid Browser");
		}
		return driver;
	}
	
	/**
	 * 
	 * @param url
	 */
	
	public void launchURL(String url) {
		if(url == null) {
			System.out.println("The URL is null.");
			throw new AutomationException("URL NULL");
		}
		// https://www.google.com
		// www.https.google.com
		if(url.indexOf("http") == 0) {
			driver.get(url);
		}else {
			throw new AutomationException("HTTP is missing");
		}
	}
	
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("The page title is: " + pageTitle );
		return pageTitle;
	}
	
	public String pageURL() {
		String currentPageURL = driver.getCurrentUrl();
		System.out.println("The page URL is: "+ currentPageURL);
		return currentPageURL;
	}
	
	public boolean getPageSource(String value) {
		String pageSource = driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	
	public void closePage() {
		driver.close();
		System.out.println("Page is closed.");
	}
	
	public void quitPage() {
		driver.quit();
		System.out.println("Page is quitted");
	}
	
	
	
}
