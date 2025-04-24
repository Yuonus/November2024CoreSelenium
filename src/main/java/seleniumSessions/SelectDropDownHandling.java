package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandling {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Dropdowns:
//		<select>   --- child <option>
//		 Select Class = methods
		
		
		//  Single Select
//		Task
//		1.	Launch the browser.
//		2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial.
//		3.	Create the By locator for the Select tag.
//		4.	Select Afghanistan from the drop-down using selectByIndex().
//		5.	Select United States from the drop-down using selectByVisibleText().
//		6.	Select India from the drop-down using selectByValue().
//		7.	Put a one-second wait between each selection.
//		8.	Deselect India.
//		9.	Close the driver.
//		10.	Develop a generic utility method for select class single selection. And move it to the ElementUtil
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		Thread.sleep(3000);
		
		By country = By.cssSelector("#Form_getForm_Country");
		WebElement countryEle = driver.findElement(country);
		
		// Rough Code
//		Select select = new Select(countryEle);
//		select.selectByIndex(1);
//		Thread.sleep(1000);
//		select.selectByIndex(16);
//		Thread.sleep(1000);
//		select.selectByVisibleText("United States");
//		Thread.sleep(1000);
////		selectByContainsVisibleText(...) ---> portion of the text   ---> 4.27
//		select.selectByContainsVisibleText("Afg");
//		Thread.sleep(1000);
//		select.selectByValue("India");
//		Thread.sleep(1000);
//		
////		select.deselectByValue("India"); // UnsupportedOperationException: You may only deselect options of a multi-select.
//		driver.close();

		// Utility Approach
		
		doSelectDropDownByIndex(country, 1);
		Thread.sleep(1000);
		doSelectDropDownByVisibleText(country, "India");
		Thread.sleep(1000);
		doSelectDropDownByValue(country, "Zimbabwe");
		Thread.sleep(1000);
		doSelectDropDownByContainsVisibleText(country, "Wallis and Futuna Islands");
	}
	
//	Utilities
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	
	public static void doSelectDropDownByValue(By locator, String valueAttributeValue) {
		Select select = new Select(getElement(locator));
		select.selectByValue(valueAttributeValue);
	}
	
	public static void doSelectDropDownByContainsVisibleText (By locator, String partialString) {
		Select select = new Select(getElement(locator));
		select.selectByContainsVisibleText(partialString);
	}
	
	

}
