package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	static WebDriver driver;
	public static void main(String[] args) {
	
	
	
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println("The page title is: " + driver.getTitle());
		
		// Locators: there are 8 locators in Selenium wd, that helps to locate a web element
		// Create / locate an element
		// locate the element + perform the action
		
		/*		1: ID
		 * ==> is an attribute / property
		 * ==> it is always unique
		 * ==> it is not mandatory that every element should have ID
		 */
	
//		driver.findElement(By.id("input-email")).sendKeys("sabawoon@stech.com");
//		driver.findElement(By.id("input-password")).sendKeys("SeleniumIsEasy");
		
		
		/*		2: name Locator
		 * ==> is an attribute / property
		 * ==> The value of the name attribute could be duplicated. sometime it could be unique
		 */
		
//		driver.findElement(By.name("email")).sendKeys("sabawoon@123stech.com");
//		driver.findElement(By.name("password")).sendKeys("SeleniumIsEasy");
		
		
		/*		3: className Locator
		 * ==> is an attribute / property
		 * ==> The value of the class name could be duplicated most of the time
		 * ==> Is a CSS file that holds the STYLES for a web element
		 *  In Selenium --- DOM --- preference ---> Top to bottom & left to right
		 */
		
//		driver.findElement(By.className("form-control")).sendKeys("Yuonus@stech.com");

		
		/*		4: Xpath
		 * ==> X = XML, Path = address
		 * ==> it is not an attribute/property
		 * ==> it determines the location of a web element
		 * 
		 */
		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("sabawoon@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Test123$%");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		// By locator methods
		
//		By eID = By.xpath("//*[@id=\"input-email\"]");
//		By pWD = By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		doSendKeys(eID, "Sabawoon@Yahoo.com");
//		doSendKeys(pWD, "Seleniumiseasy");
//		doClick(loginBtn);
		
		
		/*		5: Css Selector
		 * ==> it is not an attribute/property
		 * ==> To grab the CSS value of an element, right-click on the element and click on "Copy" and click on "Copy selector".  
		 * ==> css = Cascading style sheet
		 */
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("sabawoon@hotmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test13");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		
//		By eID = By.cssSelector("#input-email");
//		By pWD = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(eID, "sabawoon@stech.com");
//		doSendKeys(pWD, "test123");
//		doClick(loginBtn);
		
		/*		6: linkText
		 * ==> is not an attribute
		 * ==> it is only applicable for links
		 * ==> all the links in DOM are shown with <a>
		 */
		
//		driver.findElement(By.linkText("Register")).click();
		
//		By registerLink = By.linkText("Register");
//		doClick(registerLink);
//		
		
		/*		7: partialLinkText
		 * ==> is not an attribute
		 * ==> it is only applicable for links
		 * ==> It is simply part of the link text
		 * ==> it is used in case if a link is having a lengthy text
		 */
		
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
//		By forgottenPWDLink = By.partialLinkText("Forgotten");
//		doClick(forgottenPWDLink);
		
		/*		8: tagName Locator
		 *  ---> it is not an attribute
		 *  ---> It is useful when the tag doesn’t have any attributes but only  has text.
		 *  ---> is used to find the elements matching specific tag name
		 */
		
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
//		By header1 = By.tagName("h2");
//		String headerText = doElementGetText(header1);
//		System.out.println("The header text is: " + headerText);
		
		// 8 LOCATORS   ---> By class
		// ID
		// NAME
		// className
		// Xpath
		// Css selector
		// linkText
		// partialLinkText
		// tagName
		
//		driver.findElement(By.className("img-responsive")).click();
		
		
	}
	
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
