package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDownHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://html.com/attributes/select-multiple/
//		3.	Scroll down to the multi-select drop-down.
//		4.	Locate the drop-down.
//		5.	First of all, verify if it is a multi-select drop-down or not.
//		6.	Select more than one option from the dropdown.
//		7.	Get all the selected options, print their size, and also print their texts into the console.
//		8.	Use deselect() methods to deselect the dropdown options.
//		    Before deselecting, add some wait time to see the deselection clearly.
//				•	Deselect all
//				•	Deselect one value
		
		driver = new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
		//select[@multiple and @size='6']
		By multipleSelector = By.xpath("//select[@multiple and @size='6']");
		WebElement multiSelectionDropDown = driver.findElement(multipleSelector);
		
		Select select = new Select(multiSelectionDropDown);
		// Verification for multi select ---> isMultiple
		if(select.isMultiple()) {
			System.out.println("Yes, It is a multi-selection dropdown.  --- Test Passed.");
			select.selectByVisibleText("American flamingo");
			select.selectByContainsVisibleText("Chilean");
			select.selectByValue("Lesser");
			select.selectByIndex(4);
		}
		
		Thread.sleep(3000);
		
		// Get all the options and print their size
		// getAllSelectedOptions(); 
		
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		System.out.println("Out of total numbers of options, only " + allSelectedOptions.size() + " are selected.");
		for(WebElement e : allSelectedOptions) {
			String text = e.getText();
			System.out.println(text);
		}
		
		
		// Deleselection part
		
//		select.deselectByVisibleText("American flamingo");
//		select.deSelectByContainsVisibleText("Chilean");
//		select.deselectByValue("Lesser");
//		select.deselectByIndex(4);
		
		select.deselectAll();
	}

}
