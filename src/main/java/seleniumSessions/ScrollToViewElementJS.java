package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollToViewElementJS {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Business Task:
//			1.	Launch the browser.
//			2.	Navigate to https://classic.freecrm.com/.
//			3.	Scroll down to "Calls & Voice.".
//				First, you will need to create a web element for it.
//			4.	Close the browser.
//			5.	Create a utility for it and move it to the JavaScriptUtil class.

		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(3000);
		
		WebElement callingElement = driver.findElement(By.xpath("//h3[normalize-space()='Calls & Voice']"));
		scrollIntoView(callingElement);
		
//		driver.close();

	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/*				js.executeScript("arguments[0].scrollIntoView(true);", element);
	 	1: scrollIntoView(true) scrolls the element to the top of the viewport.
		2: scrollIntoView(false) scrolls the element to the bottom of the viewport.

	 */

}
