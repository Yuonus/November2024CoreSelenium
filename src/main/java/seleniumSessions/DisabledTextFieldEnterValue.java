package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DisabledTextFieldEnterValue {

//	Business situation:
//	1.	Launch the browser.
//	2.	Navigate to https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html.
//	3.	Pass some values to the disabled "Password (disable)" input field: "S_Tech119$$."
//	4.	Close the browser.
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		// Sending keys with normal sendKeys() method. --> ElementNotInteractableException: element not interactable
		WebElement disabledPwd = driver.findElement(By.cssSelector("input#pass"));
		disabledPwd.sendKeys("S_Tech119$$");
		
		// Sending keys with the help of Actions class sendKeys method will not throw any exception.
//		Actions act = new Actions(driver);
//		act.sendKeys(disabledPwd, "S_Tech119$$");
//		
		driver.close();
	}

}
