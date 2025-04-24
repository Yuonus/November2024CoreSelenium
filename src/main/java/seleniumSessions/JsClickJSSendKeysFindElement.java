package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsClickJSSendKeysFindElement {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
		1.	Launch the browser
		2.	Navigate to https://app.hubspot.com/login/legacy 
		3.	Click on "remember me" using Javascript click
		4.  Close the browser.
	 */
	
//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login/legacy");
//			Thread.sleep(1500);
//			
//			WebElement rememberMe = driver.findElement(By.id("remember"));
//			clickElementByJS(rememberMe);
			
//			
//			Business Task
//			1.	Launch the browser.
//			2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login.
//			3.	Using a JavaScript executor, fill the "E-Mail Address" & "Password" input fields with invalid texts.
//			4.	Capture the page title using a Javascript executor.
//			5.	Capture the page URL using the Javascript executor.
//			6.	Throw a JavaScript alert that should ask the user to enter valid credentials.
//			7.	Close the browser.

//			driver = new ChromeDriver();
//			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//			
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("document.getElementById('input-email').value='sabawoon@stech.com'");
//			js.executeScript("document.getElementById('input-password').value='AutomationIsEasyWithYuonus'");
//			
//			String pageTitle = js.executeScript("return document.title").toString();
//			System.out.println("Page title is: " + pageTitle);
//			
//			String pageURL = js.executeScript("return document.URL").toString();
//			System.out.println("Page URL is: " + pageURL);
//			
//			WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
//			js.executeScript("arguments[0].click();", login);
//			
//			js.executeScript("alert ('Enter Correct Login Credentials to Continue')");
//			driver.close();
			
//			Assignment
//			1.	Launch the browser.
//			2.	Navigate to https://login.yahoo.com/.
//			3.	Uncheck "Stay signed in" element using the JS click method.
//			4.	Close the browser.
		
			driver = new ChromeDriver();
			driver.get("https://login.yahoo.com/");
			Thread.sleep(2000); // To observe that the check box is selected and then get unselected
			
			WebElement checkBox = driver.findElement(By.cssSelector("input#persistent"));
			
//			checkBox.click(); //Normal click will not click on this element --> ElementNotInteractableException
//			Actions act = new Actions(driver);
//			act.click(checkBox); // Actions class will also not work here. --> No exception 

			// Rough code
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", checkBox);
			
			// Utility
			clickElementByJS(checkBox);
			driver.close();


	}

	
//	Utility
	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	
	}
}
