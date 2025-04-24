package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
	
		
//		findElment();  ---> Find single web element
//		findElments(); ---> Find multiple web elements

		/*		Test scenario
		 * 1: Launch the browser
		 * 2: Launch the URL: https://naveenautomationlabs.com/opencart/index.php?route=account/register
		 * 3: Verify how many text fields are there in the registration page?
		 */
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println("The title of the page is: " + driver.getTitle());
		
		List <WebElement> regisPageTotalInputFieldsCount = driver.findElements(By.className("form-control"));
		System.out.println("Number of text fields in registration page is: " + regisPageTotalInputFieldsCount.size());
		
		
		
	}

}
