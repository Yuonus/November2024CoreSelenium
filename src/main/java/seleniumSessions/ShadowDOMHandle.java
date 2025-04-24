package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

//		Automation Script:
//			1.	launch the browser.
//			2.	Navigate to "https://selectorshub.com/iframe-in-shadow-dom/." 
//			3.	Enter your favorite pizza name in the "Enter pizza name" input field.
//			    Test_data: chicken pizza
//			4.	Close the browser.

		// Hierarchy:  Browser -- page -- Shadow DOM -- Shadow DOM -- element
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/ ");
		Thread.sleep(3000);
		
		String pizza_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement search = (WebElement) js.executeScript(pizza_script);
		search.sendKeys("Chicken Pizza");
		driver.close();
	}
}
