package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreationOfJsAlert_Confirm_Prompt {

	static WebDriver driver;
	public static void main(String[] args) {
		
//		Business Case
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Generate an alert window using JavascriptExecutor.
//		4.	Supply this given message to your JavaScript alert. "Hello S_Tech"
//		5.	Create a utility for it as well.

		
//		driver = new ChromeDriver();
		driver = new FirefoxDriver(); // for prompt alert
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("alert('Selenium is really interesting with Sabawoon Yuonus.')");

//		Utility approach
//		generateJsAlert("Hello S_Tech.");

//		Business Case: Confirm
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Generate a confirm window using JavascriptExecutor.
//		4.	Supply this given message to your JavaScript alert. "Are you sure you want to give up on your dreams?".
//		5.	Accept or dismiss the alert.
//		6.	Create a utility for it as well.

//		Rough Code Approach:
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("confirm('Are you sure you want to give up on your dreams?')");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
////		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().accept();
			
//		Utility Approach
//		generateJsConfirm("Are you sure you want to give up on your dreams?");
		
//		Business case: Prompt
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//		3.	Generate a prompt window using JavascriptExecutor.
//		4.	Supply this given message to your JavaScript alert. "Enter your goal.".
//		5.	The keys to pass: "I want to be the strongest SDET after 6 months.".
//		6.	Accept or dismiss the alert.
//		7.	Create a utility for it as well.
		
		// Rough Code Approach
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("prompt('Enter Your goal')");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Alert alrt = driver.switchTo().alert();
//		alrt.sendKeys("I want to be the strongest SDET after 6 monts.");
//		try {
//			Thread.sleep(3000);  // to see the text entered
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		alrt.accept();
		
//		Utility Approach
		generateJsPrompt("Enter your goal", "I want to be the strongest SDET after 6 months.");

	}
	
//	Utilities
	public static void generateJsAlert(String mesg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+mesg+"')");
		try {
			Thread.sleep(3000); //If you want to see switching to the alert
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
		driver.switchTo().alert().accept();
	}

	// After this "js.executeScript("alert ('"+mesg+"')");" the page/app will be frozen. So, to prevent freezing the page
	// We will add the below code to accept the alert. 
	// Note: if you want to dismiss or cancel the alert you can create a separate utility for cancellation

	public static void generateJsConfirm(String mesg) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("confirm('"+mesg+"')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	public static void generateJsPrompt(String mesg, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("prompt('"+mesg+"')");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Alert alrt = driver.switchTo().alert();
		alrt.sendKeys(value);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alrt.accept();
	}
	

}
