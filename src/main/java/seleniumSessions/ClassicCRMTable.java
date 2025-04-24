package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassicCRMTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {



//	1.	Navigate to https://ui.cogmento.com/
// 		After logging in, click on the "CONTACTS" menu.
//	2.	Use your credentials to log in.
//	3.	Click on the "Login" button. Add some wait time, because it takes some time for this app to load.
//	4.	Click on "CONTACTS.".
//	5.	Select the check box for "Abaseen winner Yuonus."
//	6.	Find out Abaseen's Address


		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sabawoonautomation@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(5000);

		// TO Hover the mouse
		By moveToMenue = By.xpath("//div[@id= 'main-nav']");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(moveToMenue)).build().perform();

		driver.findElement(By.xpath("//span[text() = 'Contacts']")).click();

		// I have to change the focus back to the table to be visible
		By focusToName = By.xpath("//button[text() = 'Show Filters']");
		WebElement nameList = driver.findElement(focusToName);
		act.moveToElement(nameList).build().perform();
		
		Thread.sleep(3000);
		
						// Rough Code Approach
		
		// Since this check box is overlapped by another element (menu popup) and selenium cannot interact with it and it throws
//		ElementClickInterceptedException, to avoid such exception we will be using actions class click.
//		act.click(driver.findElement(By.xpath("//a[text() = 'Abaseen Winner Yuonus']/parent::td/preceding-sibling::td/div[@class='"
//				+ "ui fitted read-only checkbox']/child::input[@name='id']"))).build().perform();	
//				
////		(//a[text() = 'Abaseen Winner Yuonus']/parent::td//following-sibling::td)[1] --> AYuonus Address fetching XPath
//		String emplAddress = driver.findElement(By.xpath("(//a[text() = 'Abaseen Winner Yuonus']/parent::td//"
//				+ "following-sibling::td)[1]")).getText();
//		System.out.println("Employee Address: " + emplAddress);
//		
//		// Employee rule Xpath = (//a[text() = 'Abaseen Winner Yuonus']/parent::td//following-sibling::td)[2]
//		
//		String empRole = driver.findElement(By.xpath("(//a[text() = 'Abaseen Winner Yuonus']/parent::td//"
//				+ "following-sibling::td)[2]")).getText();
//		
//		System.out.println("Employee position in the company: " + empRole);



					// Utility Approach
		selectUser("Samantha Locker Joshua");
		selectUser("Kevin Lee");
		
		String empAddress = getUserAddress("Samantha Locker Joshua");
		String emplAddress2 = getUserAddress("Abaseen Winner Yuonus");
		String emplAddress3 = getUserAddress("John Sahara");
		
		System.out.println("Samantha address is: " + empAddress);
		System.out.println("Abaseen address is: " + empAddress);
		System.out.println("John address is: " + empAddress);

	}

	
	
				// Utilities
	public static void selectUser(String userName) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(By.xpath("//a[text() = '"+userName+"']/parent::td/preceding-sibling::td/div[@class='"
				+ "ui fitted read-only checkbox']/child::input[@name='id']"))).build().perform();
	}
	
	public static String getUserAddress(String userName) {
		return 
				driver.findElement(By.xpath("(//a[text() = '"+userName+"']/parent::td//"
				+ "following-sibling::td)[1]")).getText();
	}

}
