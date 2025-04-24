package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingBorderAroundElement {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Business case:
//			1.	Launch the browser.
//			2.	Navigate to https://classic.freecrm.com/.
//			3.	Create a border around the "Calls & Voice" web element.
//				First, you will need to create a web element for it.
//			4.	Close the browser.
//			5.	Create a utility for it.

//		driver = new ChromeDriver();
//		driver.get("https://classic.freecrm.com/");
//		Rough Code
//		WebElement callingElement = driver.findElement(By.xpath("//h3[normalize-space()='Calls & Voice']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].style.border = '5px solid red'", callingElement);
		
//		Utility Approach
//		drawBorderAroundElement("9", "red", callingElement);
		
		//Assignment
//		1.	Launch the browser.
//		2.	Navigate to https://app.hubspot.com/login/legacy.
//		3.	Draw the border from the whole login form.
//		4.	Close the browser.

//		driver = new ChromeDriver();
//		driver.get("https://app.hubspot.com/login/legacy");
//		
//		WebElement loginForm = driver.findElement(By.cssSelector("form#hs-login"));
//		drawBorderAroundElement("6", "red", loginForm);
//		driver.close();
		
		
		//  **************************** Flashing/ blinking elements **********************

//		1.	Launch the browser.
//		2.	Navigate to https://app.hubspot.com/login.
//		3.	Flash the "Login form" completely.
//		4.	Close the browser.
		
//		driver = new ChromeDriver();
//		driver.get("https://app.hubspot.com/login/legacy");
//		
//		WebElement loginForm = driver.findElement(By.cssSelector("form#hs-login"));
//		flash(loginForm);
		
//		Business Task
//		1.	Launch the browser.
//		2.	Navigate to https://app.hubspot.com/login.
//		3.	Flash the "Email address" & "Password" input fields with green color.
//		4.	SendKeys to both input fields after flashing/blinking.
//		5.	Close the browser.
		
//		driver = new ChromeDriver();
//		driver.get("https://app.hubspot.com/login/legacy");
//		
//		WebElement emailID = driver.findElement(By.cssSelector("input#username"));
//		WebElement pwd = driver.findElement(By.cssSelector("input#password"));
//		
//		flash(emailID);
//		emailID.sendKeys("sabawoon@stech.com");
//		flash(pwd);
//		pwd.sendKeys("SeleniumIsEasyWithSabawoon");
		
		
		// **************** Highlighting / Changing Element background Color ******//
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://app.hubspot.com/login 
			3.	Highlight the "Email address" & "Password" input fields with beige color for Email text field and
				yellow for password text field
			4.	SendKeys to both input fields after flashing/blinking
			5.	Close the browser
		 */

//			driver = new ChromeDriver();
//			driver.get("https://app.hubspot.com/login/legacy");
//			Thread.sleep(1500);
//	
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
//			WebElement emailAdd = driver.findElement(By.cssSelector("input#username"));
//			jsExecutor.executeScript("arguments[0].style.background='black'", emailAdd);
//			emailAdd.sendKeys("syuonus@gmail.com");
//			
//			WebElement password = driver.findElement(By.cssSelector("input#password"));
//			jsExecutor.executeScript("arguments[0].style.background='yellow'", password);
//			password.sendKeys("success_Guarantedd with S_Tech");
//			driver.close();
		
		// ***** Highlighting and Drawing the border at the same time around an Element ********//
		
		/*		Business Case
			1.	Launch the browser
			2.	Navigate to https://app.hubspot.com/login 
			3.	Highlight the "Email address" & "Password" input fields. Orange color for "Email address" background 
				and turquoise color for its border & yellow color for "Password" and pink color for its border.
			4.	SendKeys to both input fields after highlighting/changing the background color
			5.	Close the browser
		 */
		
				driver = new ChromeDriver();
				driver.get("https://app.hubspot.com/login/legacy");
				Thread.sleep(1500);
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
			 
				WebElement emailAdd = driver.findElement(By.cssSelector("input#username"));
				js.executeScript("arguments[0].setAttribute('style', 'border:6px solid turquoise; background:orange')", emailAdd);
				emailAdd.sendKeys("syuonus@gmail.com");
				
				WebElement password = driver.findElement(By.cssSelector("input#password"));
				js.executeScript("arguments[0].setAttribute('style', 'border:6px solid pink; background:yellow')", password);
				password.sendKeys("success_Guarantedd with S_Tech");
	}
	

							// Utility Approaches
	/**
	 * This method draw a border around a web element
	 * @param borderLineSize
	 * @param borderLineColor
	 * @param element
	 */
	public static void drawBorderAroundElement(String borderLineSize, String borderLineColor, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '"+borderLineSize+"px solid "+borderLineColor+"'", element);
	}
	
	
	public static void flash(WebElement element) {
		String bgColor = element.getCssValue("backgroundColor");
		for(int i = 0; i<50; i++) {
			changeColor("rgb(0,2000,0)", element); // The color we are passing to flash/high light the element
			changeColor(bgColor, element); // Element original color
		}
	}
	
	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
