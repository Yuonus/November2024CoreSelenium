package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Test Case
//		1.	Launch the web browser and launch “https://demoqa.com/buttons”
//		2.	Find the required element, i.e., the button in our sample, and double-click on the element.
//		3.	Close the browser to end the program.
		
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		Thread.sleep(3000);
		
		By dblClickItem = By.id("doubleClickBtn");
		WebElement doubleClickBtn = driver.findElement(dblClickItem);
		
		// Rough Code
//		Actions act = new Actions(driver);
//		act.doubleClick(doubleClickBtn).perform();
//		driver.close();
		
		
		// Utility
		
		doDoubleClick(dblClickItem);
	}
	
	// Utilities
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDoubleClick(By locator) {
		Actions act = new Actions(driver);
		act.doubleClick(getElement(locator)).build().perform();
	}
}
