package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcepts {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		
	/* 				Actions class
		1: It comes from Selenium Package
		2: In simple language means
			User actions
		3: User actions
			a: Mouse actions
			b: Keyboard actions
		4: Use Actions?
			object
			access to all its methods
	 */
		
		
		
//		Task:
//			1.	Launch the browser.
//			2.	Navigate to http://mrbool.com/search/?textsearch=how-to-create-menu-with-submenu-using-css-html
//			3.	Hover the mouse over the "CONTENT."
//			4.	Wait for two seconds to give the time for Selenium to interact with child menu items.
//			5.	Click on "COURSES."
//			6.	Close the driver.
		
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?textsearch=how-to-create-menu-with-submenu-using-css-html");
		
		
		// Rough Code Approach
//		a.menulink
		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.cssSelector("a.menulink"))).build().perform();
		
//		By parentMenu = By.cssSelector("a.menulink");
//		WebElement parentMenuElements = driver.findElement(parentMenu);
//		
//		act.moveToElement(parentMenuElements).build().perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click();
//		
//		driver.close();
		
//		act.a1.a2.a3.an.build():
//		act.a1.build();				--> Not Valid
//		act.a1.build().perform();	--> Valid
//		act.a1.perform();			--> Valid
//		act.a1;						--> Not Valid
		
		// Using the Utility code
		By parentMenu = By.cssSelector("a.menulink");
		By childMenu = By.linkText("COURSES");
		
		parentChildMenu(parentMenu, childMenu);
		driver.close();
		
	}
	
	// Utilities
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void parentChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(2000);
		driver.findElement(childMenuLocator).click();
	}
	
				

}
