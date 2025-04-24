package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NullValuesWithSendKeys {

//	Business case
//	1.	Launch the browser.
//	2.	Navigate to http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html
//	3.	Pass "null" values to the "First name" input field. 
//	4.	Close the browser.

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		// Normal sendKeys () --> IllegalArgumentException: Keys to send should be a not null CharSequence
		WebElement firstName = driver.findElement(By.name("fname"));
//		firstName.sendKeys(null);
		
		// Sending keys with Actions class .sendKeys () method: --> IllegalArgumentException: Keys to send should be a not null CharSequence
		Actions act = new Actions(driver);
		act.sendKeys(firstName, null);
		driver.close();
	}

}
