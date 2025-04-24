package seleniumSessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	public static void main(String[] args) throws InterruptedException {
//		Automation steps
//		1.	Launch the browser.
//		2.	Navigate to https:https://www.ebay.com/
//		3.	Scroll down the page slightly.
//		4.	Scroll up the page slightly. 
//		a.	You can add a one-second pause between scrolling up and down.
//		5.	Comment out 3 & 4. Completely scroll down to the page.
//		6.	Completely scroll up the page.
//		7.	Close the browser.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1500);
//		act.sendKeys(Keys.PAGE_UP).perform();
		
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
//		driver.close();

	}

}
