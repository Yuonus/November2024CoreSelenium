package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabKeyConcept {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register.
//		3.	Fill the registration form, as there should be a half-second wait between each input field.
//		Like fill the first Name input field, wait for half a second, and then fill the last name and respective text fields.
//		4.	Conditions:
//				Don’t use By locators / web elements
//				You can only use one web element/By locator.
//		5.	Close the driver.
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(4000);
		
		WebElement first_Name = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		act.sendKeys(first_Name, "Sabawoon")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Yuonus")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("sabawoon@stech.com")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("9999999999")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Automation1234")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Automation1234")
			.build()
			.perform();
		
	}

}
