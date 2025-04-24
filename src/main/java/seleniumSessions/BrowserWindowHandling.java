package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		1.	Open the browser.
//		2.	Navigate to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login.
//		3.	Notice the social media links in the bottom left corner.
//		4.	Click on the "Twitter" icon.
//		5.	Fetch the window IDs.
//		6.	Start switching between the Windows
//		7.	Print the URL and page titles of both parent and child windows.
//		8.	Close the browser.
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
		//1: Fetching Window IDs
		Set<String> handles = driver.getWindowHandles();  // Set part of collection and is part of java.util package. Set cannot contain duplicate values 2: Set is non-order based collection
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next(); 
		System.out.println("Parent Window ID is: " +  parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child Window ID is: " + childWindowId);
		
		// 2. Switching work
		driver.switchTo().window(childWindowId);
		System.out.println("Child window URL is: " + driver.getCurrentUrl());
		System.out.println("Child window title is: " + driver.getTitle());
		driver.close();  // remember not use driver.quit() method here, As we still want to interact with parent window elements
		
		//After closing the child window the driver is lost (no where), we have to bring it back to the parent window
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL is: " + driver.getCurrentUrl());
		System.out.println("Parent window title is: " + driver.getTitle());
		driver.close(); // Now you can use driver.quit() here.
		
		
	} 
}
