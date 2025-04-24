package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDisabledElements {

//	Test Case
//	https://elementalselenium.com/tips/40-disabled-element
//	Open a browser
//	Visit the page
//	Grab all drop down list elements
//	Assert that the first element in the list is not enabled
//	Assert that the second element in the list is enabled
//	Close the browser

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dropdown");

		WebElement dropDownList = driver.findElement(By.cssSelector("select#dropdown"));
		dropDownList.click();

		Select select = new Select(dropDownList);
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (e.isEnabled()) {
				System.out.println("Test passed");
			} else {
				System.out.println("Test failed");
			}
		 }
//		--> For the first option it will print Test Failed. And this is accepted behavior because it is not enabled that is Y it is printing Failed.
	
//		Int Question: How can you print the options list without using any for loop?
		System.out.println("----------------------------------------------------------------------");
		WebElement firstOption = optionsList.get(0);
		WebElement secondtOption = optionsList.get(1);
		WebElement thirdOption = optionsList.get(2);
		
		System.out.println("First option of the dropdown is: " + firstOption.getText());
		System.out.println("Second option of the dropdown is: " + secondtOption.getText());
		System.out.println("Third option of the dropdown is: " + thirdOption.getText());
		
	}
}


