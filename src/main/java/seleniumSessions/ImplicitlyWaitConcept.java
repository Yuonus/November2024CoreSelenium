package seleniumSessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		// Implicitly wait
		// It is dynamic wait
		// It is also called a -- Global wait
		// Apply/use?  ---> Applied after the driver initializations
		// IMW: Only applicable for web elements
		// Restrictions: Cannot be applied to non-web elements. (Alerts, URL, pageTitle..)
		// Selenium Dev Team Recommendations: Ignore using the implicitly wait in real time projects.
		//  wait time is applied to each and every element after the driver initializations
		
		WebDriver driver = new ChromeDriver();
		
//		Syntaxes:
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Deprecated Selenium 3.xxx
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Selenium 4.xxx
//		Nullification  --> driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		// login page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("sabawoon@stech.com");
		// E1  ---> 10 Secs   -- 2 seconds -- 8 seconds   -- ignored/cancelled
		// E1  ---> 10 Secs   -- 10 secs  ---> NoSuchElementException
		
		driver.findElement(By.id("input-password")).sendKeys("Selenium@stech");
		
		//E2
		//E3
		//E4
		//E5
		//E50
		
		

	}

}
