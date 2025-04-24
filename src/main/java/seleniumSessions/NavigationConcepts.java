package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcepts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
//		String pageTitle = driver.getTitle();
//		System.out.println("The page title is: " + pageTitle);
		System.out.println("The page title is: " + driver.getTitle());
		
		driver.navigate().to("https://naveenautomationlabs.com/opencart/");
		System.out.println("The page title is: " + driver.getTitle());
		
		driver.navigate().back();
		System.out.println("The page title is: " + driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("The page title is: " + driver.getTitle());
		
		driver.navigate().back();
		System.out.println("The page title is: " + driver.getTitle());
		driver.navigate().refresh();
		
		
//		Test Scenarios:
//			1.	Launch the browser
//			2.	Launch the URL https://naveenautomationlabs.com/opencart/index.php?route=account/login
//			3.	Fetch the page title
//			4.	Enter the email id and password.

		
	}

}
