package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandleWithoutSelect {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Business Case:
//		1.	Launch the browser.
//		2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial
//		3.	Locate the "country" dropdown.
//		4.	Find out how many options or <option> tags there are using programmatic concepts. 
//			(Here, we are not selecting any values of the dropdown.)
//		5.  Select a specific value from the dropdown without using the Select class’s available methods. 
//			Like Afghanistan or the United States.
//		--------------------------------------------------------------------------------
//		From 6–8 is the assignment for students.
//		6.	Write a utility method for the rough code.
//		7.	Supply an option to the utility method parameter to be selected.
//		8.	After that, the option (country) is selected; don’t let the code print the rest of the countries.
//		9.	Close driver
//		10.	Don’t forget to move the utility to the ElementUtil class.

		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		Thread.sleep(2000);
		
		By country = By.cssSelector("#Form_getForm_Country > option");
//		WebElement countryEle = driver.findElement(country);
//		
//		List<WebElement> optionsList = driver.findElements(country);
//		System.out.println(optionsList.size());
//		
//		for (WebElement e : optionsList) {
//			String text = e.getText();
//			if (text.contains("Afghanistan")) {
//				e.click();
//				break;
//			}
//		}
		
		// Utility
		selectDropDownValue(country, "Afghanistan");
		driver.close();
	}
	
	
//	Utilities
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectDropDownValue(By locator, String dropDownVlaue) {
		List<WebElement> optionsList = getElements(locator);
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.contains(dropDownVlaue)) {
				e.click();
				break;
			}
		}
	}
	
	
	
	
	
}
