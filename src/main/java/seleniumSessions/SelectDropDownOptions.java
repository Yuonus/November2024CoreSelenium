package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
//		Task
//		1.	Launch the browser.
//		2.	Navigate to (enter the URL) https://orangehrm.com/en/30-day-free-trial
//		3.	Create the By locator for the Select tag.
//		4.	Find out how many options or <option> tags there are.
//		5.	Also, print each and every option to the console.
//		6.	Select a specific value from the drop-down without using the Select class’s available methods. Like Afghanistan 
//			or the United States.
//		7.	Close the driver.
		
		driver = new ChromeDriver();
		driver.get("https://orangehrm.com/en/30-day-free-trial");
		Thread.sleep(2000);
		
		By country = By.cssSelector("#Form_getForm_Country");
		WebElement countryEle = driver.findElement(country);
		
		// Rough Code Approach
//		Select select = new Select(countryEle);
//		// getOptions() --- count of options
////		System.out.println(select.getOptions().size());
//		
//		List<WebElement> countryList = select.getOptions();
//		System.out.println("Total number of options tag in select dropdown are: " + countryList.size());
//		
//		for(WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.equals("Afghanistan")) {
//				e.click();
//				break;
//			}
//		}
//		
//		// Print me the indexes ---> index for loop
////		for(int i=0; i<countryList.size(); i++) {
////			String text = countryList.get(i).getText();
////			System.out.println(i + " : " + text);
////		}
//		
//		driver.close();
		
//		Utilites
//		selectDropDownOption(country, "India");
		
//		int optionCount = getDropDownOptionsCount(country);
//		System.out.println("Total number of options tag are: " + optionCount);
		
		// If you dont want to see the country in the console
//		int optionCount = getDropDownOptionsCount(country)-1;
//		System.out.println("Total number of options tag are: "+ optionCount);
		
		List<String> countryList = getDropDownOption(country);
		System.out.println(countryList);
		
		if(countryList.contains("Afghanistan")) {
			System.out.println("Test Passed");
			
		}else {
			System.out.println("Test Failed");
		}
		
	}
	
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void selectDropDownOption(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("The total number of options tag in select drop-down are: " + optionsList.size());
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			
			if(text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}
	
	
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public static List<String> getDropDownOption(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for(WebElement e : optionList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	
}
