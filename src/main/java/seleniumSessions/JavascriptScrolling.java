package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptScrolling {

//	Business Task:
//		1.	Launch the browser.
//		2.	Navigate to https://classic.freecrm.com/.
//		3.	Scroll down all the way to the end of the page.
//		4.	Scroll up all the way to the top of the page.
//		5.	Scroll down to 1500 pixels.
//		6.	Scroll up to 200 pixels.
//		7.	Scroll up all the way to the top of the page.
//		8.	Scroll to the middle of the page.
//		9.	Scroll up all the way to the top of the page.
//		10.	Scroll down to the 75% of the page.
//		     75% = ¾
//		window.scrollTo(0, document.body.scrollHeight*3/4);
//		11.	Create the utility and move it to JavaScriptUtil
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1500);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, 1500)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0, -200)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight*3/4)");
		
		// ****** Utility Approach *******//
//		scrollPageDown();
//		Thread.sleep(1500);
//		scrollPageUp();
//		Thread.sleep(1500);
//		scrollPageDown("2000");
//		Thread.sleep(1500);
//		scrollPageDown("-1000");
//		Thread.sleep(1500);
	}
	
	
		// ************************  Utilities  *************************//
	public static void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	public static void scrollPageDown(String customHeight) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, '"+customHeight+"');");
	}
	
	public static void getToMiddlePageDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2 );");
	}
	
	public static void getPageDownWithByTo() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}
	
	public static void getPageUpWithByTo() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
	}

}
