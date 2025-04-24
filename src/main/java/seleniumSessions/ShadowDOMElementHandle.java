package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMElementHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

//		Logic to automate
//		1.	launch the browser.
//		2.	Navigate to "chrome://settings/"
//		3.	SendKeys in the "Search setting" input field.
//		    Test_data: Notification
//		4.	Close the browser.

		driver = new ChromeDriver();
		driver.get("chrome://settings/");
		Thread.sleep(3000);
		
		// Using normal .sendKeys()
//		driver.findElement(By.id("searchInput")).sendKeys("Notification"); // with normal .sendKeys method  it will throw NSEE (NoSuchElementException)
		// Using Actions class sendKeys() method
//		Actions act = new Actions(driver);
//		WebElement chromeSearchBar = driver.findElement(By.id("searchInput"));
//		act.sendKeys(chromeSearchBar, "Notification");  //With Actions class .sendKeys() -- NoSuchElementException: no such element: Unable to locate element
		// The reason it cannot be located is because the sear bar is a shadow dom element
		
		// Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String search_script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#toolbar\").shadowRoot."
				+ "querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")";
		// The above query returns an HTML element
		
		
		// HTML element converted into WebElement by explicit type cast
		WebElement search = (WebElement)js.executeScript(search_script);
		search.sendKeys("Notification");
		
		driver.close();  
		
	}

}
