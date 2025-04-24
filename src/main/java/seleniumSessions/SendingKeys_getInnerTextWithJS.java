package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendingKeys_getInnerTextWithJS {

	static WebDriver driver;
	public static void main(String[] args) {
 
//		Business Task:
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Send some key at email input field. sabawoon@stech.com
//		4.	Send some keys at password input field. Automation123$.
//		5.	Close the browser.

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('input-email').value='sabawoon@stech.com'");
//		js.executeScript("document.getElementById('input-password').value='Automation@123$'");
//		driver.close();
		
//		Business Task: Inner text of a webpage
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Capture the text of whole page elements.
//		4.	And verify a few key words.
//		5.	Create the utility.

//		Rough Code Approach
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String pageText = js.executeScript("return document.documentElement.innerText").toString();
//		System.out.println(pageText);
//		if(pageText.contains("Desktops")) {
//			System.out.println("Test Passed");
//		}else {
//			System.out.println("Test failed.");
//		}
		
//		Utility Approach
		String allPageText = getPageInnerText();
		System.out.println(allPageText);
		if(allPageText.contains("Gift Certificates")) {
			System.out.println("Test passed.");
		}else {
			System.out.println("Test Failed.");
		}
	}
	
	public static String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.documentElement.innerText").toString();
	}
}
