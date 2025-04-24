package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//			Business Task
//			1.	Launch the browser.
//			2.	Open the URL https://opensource-demo.orangehrmlive.com/web/index.php/auth/login.
//			3.	Create a new window/tab.
//			4.	Open https://www.google.com/ in a new window.
//			5.	Capture the title of the new window.
//			6.	Close the tab/window.
//			7.	Bring the driver back to the parent window, as it is lost after closing the child window.
//			8.	Verify if you are on the parent window or not.
//			9.	Close the browser.


		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		String parentWindowId = driver.getWindowHandle();
		
//		driver.switchTo().newWindow(WindowType.TAB);   // This opens new Tab (will be opened with the parent window )
		driver.switchTo().newWindow(WindowType.WINDOW);	// This opens new Window (Will be opened in an absolute new window )
		
		driver.get("https://www.google.com/");
		System.out.println("The title of the new window: " + driver.getTitle());
		driver.close();
		
		// Bringing back the driver
		driver.switchTo().window(parentWindowId);
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent window title is: " + parentWindowTitle);
		
		if(parentWindowTitle.equals("OrangeHRM")) {
			System.out.println("Test ---- PASSED.");
		}else {
			System.out.println("Test ---- FAILED.");
		}
		
		driver.close();
	}

}
