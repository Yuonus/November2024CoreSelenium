package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NestedShadowDOMAssignment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		1st Assignment
//		1.	Launch the browser.
//		2.	Navigate to https://books-pwakit.appspot.com/.
//		3.	Search for your favorite book.
//		4.	Hit enter.
//		5.	Close the driver.

//		driver = new ChromeDriver();
//		driver.get("https://books-pwakit.appspot.com/");
//		Thread.sleep(3000);
//		
//		String search_Book = "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")";
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement bookSearch = (WebElement) js.executeScript(search_Book);
//		bookSearch.sendKeys("Atomic Habits");
//		bookSearch.sendKeys(Keys.ENTER);
//		driver.close();
	
		// *************** 2nd Assignment ******************//
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to "chrome://settings/appearance/"
			3.	Activate "Show home button"
			4.	Hit enter
			5.	Close the driver
		 */
		
		driver = new ChromeDriver();
		driver.get("chrome://settings/appearance/");
		Thread.sleep(3000);
		
		String showHomeButton_Script = "return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\")"
				+ ".shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(21) > settings-appearance-page\")"
				+ ".shadowRoot.querySelector(\"#pages > div > settings-toggle-button:nth-child(6)\").shadowRoot.querySelector(\"#control\").shadowRoot.querySelector(\"#knob\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// HTML Element to Selenium WebElement
		WebElement buttonClick = (WebElement) js.executeScript(showHomeButton_Script);
		Actions act = new Actions(driver);
		act.click(buttonClick);
		buttonClick.click();
		driver.quit();
		
	}
}
