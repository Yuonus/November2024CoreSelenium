package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseduoElementHandle {

	static WebDriver driver;
	public static void main(String[] args) {

//		Business Logic
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register.
//		3.	Verify if the first name input field is a mandatory text field or not. (to verify this, you will need to inspect the asterisk signs.).
//		4.	Close the browser.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"),  '::before' ).getPropertyValue('content'); ";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String mandatoryText = js.executeScript(script).toString();
		System.out.println(mandatoryText);

		// Verification
//		if(mandatoryText.contains("*")) {
//			System.out.println("first name is a mandatory text field.");
//		}else {
//			System.out.println("first name is not a mandatory field.");
//		}
		
		// We can also do the verification using the ternary operators
		System.out.println(mandatoryText.contains("*") ? "first name is a mandatory text field." : "first name is not a mandatory field.");
		driver.close();
	}
 
}
