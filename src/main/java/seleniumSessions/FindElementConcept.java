package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// Wrong attribute value --> org.openqa.selenium.NoSuchElementException 
		
//		driver.findElement(By.id("input-email")).sendKeys("sabawoon@stech.com");
		
		// 2. Can we directly supply numeric values to the .sendkeys method?
		// No
		
//		int trafficLightCitation = 100;
//		String totalCitation = String.valueOf(trafficLightCitation);
//		
//		driver.findElement(By.id("input-email")).sendKeys(totalCitation);
		
		// 3. null  to ---> .sendKeys();
		
		driver.findElement(By.id("input-email")).sendKeys(null); // java.lang.IllegalArgumentException: Keys to send should be a not null CharSequence
		
		
		
	}

}
