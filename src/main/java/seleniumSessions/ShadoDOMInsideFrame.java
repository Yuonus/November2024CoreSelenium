package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadoDOMInsideFrame {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

//		Automation Script
//		1.	launch the browser.
//		2.	Navigate to " https://selectorshub.com/shadow-dom-in-iframe/." 
//		3.	Enter your favorite tea name in the "Do you love tea" input field.
//		    Test_data: green tea
//		4.	Close the browser.
		
		// Hierarchy:  Browser -- page -- iFrame -- Shadow DOM -- element
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		Thread.sleep(3000);
		
		// switching to iframe
		driver.switchTo().frame("pact");
		
		// Handling Shadow DOM  -- writing the script
		String tea_script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement) js.executeScript(tea_script);
		tea.sendKeys("Green tea");
		driver.close();	
		
	}
}
