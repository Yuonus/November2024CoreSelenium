package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollToSpecificElement {

	public static void main(String[] args) throws InterruptedException {
	
//		Automation Steps
//		1.	Launch the browser.
//		2.	Navigate to https://www.ebay.com/ 
//		3.  Allow three seconds for the app to fully load. 
//		4.	Scroll to "eBay Sites" in the footer section. Wait for two seconds and hover the mouse on it.
//		5.  Refresh the Page
//		4.	Close the browser.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		Thread.sleep(5000);
		
		WebElement eBaySites = driver.findElement(By.cssSelector("a#gf-fbtn"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(eBaySites)
			.pause(2000)
			.moveToElement(eBaySites)
			.build()
			.perform();
		
		driver.navigate().refresh();
	}

}
