package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println("The page title is: " + driver.getTitle());
		
		// getAttribute();   ----> deprecated. no longer used 
		
		By email_id = By.id("input-email");
		By password = By.id("input-password");
		By registLink = By.linkText("Register");
		
//		String placeHolder = driver.findElement(email_id).getAttribute("placeholder");
//		System.out.println(placeHolder);
//		
//		String pwdPlaceHolder = driver.findElement(password).getAttribute("placeholder");
//		System.out.println(pwdPlaceHolder);
//		
//		System.out.println(driver.findElement(registLink).getAttribute("href"));
		
	// Selenium 4.27 (included) and on ward --- getDomProperty(), and getDomAttribute();
		
//		System.out.println(driver.findElement(email_id).getDomProperty("placeholder"));
//		System.out.println(driver.findElement(password).getDomAttribute("placeholder"));
//		System.out.println(driver.findElement(registLink).getDomProperty("href"));
		
		// Utility 
		
		String emailID_placeholder = doGetElementDomProperty(email_id, "placeholder");
		System.out.println(emailID_placeholder);
		System.out.println(doGetElementDomProperty(password, "placeholder"));
		System.out.println(doGetElementDomProperty(registLink, "href"));
		
		
	}
	
	public static String doGetElementDomProperty(By locator, String attributeName) {
		return getElement(locator).getDomProperty(attributeName);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
