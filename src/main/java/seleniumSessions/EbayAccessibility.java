package seleniumSessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EbayAccessibility {
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
			.sendKeys("Mackbook pro")
			.sendKeys(Keys.ENTER)
			.build()
			.perform();
		
		driver.close();
		
	}

//	right click
//	context menu
//	actions click
//	actions send keys		--- overlapping elements
//	sendkeys with pause
//	double click
//	tabing
//	enter action
//	accessibitiy 
	
}
