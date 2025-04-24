package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDownConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
//		Task 2
//		1.	Launch the browser.
//		2.	Navigate to https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette
//		3.	Expand the "Multi Selection" dropdown. To expand the dropdown, click on it.
//		4.	Verify how many options there are in the dropdown.
//		5.	Collect/print all the values.
//		6.	Select "choice 2.". 
//		7.	Select all choices. 
//		8.	Close the driver. 
		
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		Thread.sleep(2000);
		
//		By.id("justAnInputBox")
//		input#justAnInputBox
//		#justAnInputBox.comboTreeInputBox
//		input#justAnInputBox[type='text'][placeholder='Select'].comboTreeInputBox
//		//input[@id='justAnInputBox']
		
		driver.findElement(By.cssSelector("#justAnInputBox.comboTreeInputBox")).click();
		
		List<WebElement> choicesList = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
//		System.out.println("Number of choices on Multiple jQuery dropdown is: " + choicesList.size());  -- 45 elements
		
		// If you only want to see the 15 elements
		int choiceListCount = choicesList.size() - 30;
		System.out.println("Number of choices on Multiple jQuery dropdown is: " + choiceListCount);  // return 15 elements
		
//		for(WebElement e : choicesList) {
//			String text = e.getText();
//	
//			if(text.length() !=0) {
//				System.out.println(text);
//			}
//			
//			if(text.contains("choice 2")) {
//				e.click();
//				break;
//			}
//		}
		
		for(WebElement e : choicesList) {
			
//			String text = e.getText();
//			if(text.length() !=0) {
//				e.click();
//			}
			
			try {
			e.click();  // ElementNotInteractableException: element not interactable
			}
			catch(ElementNotInteractableException except) {
				System.out.println("The choices options are over ....");
				break;
			}
		}
		
		
		// we want to see the indexes  --- indexed for loop
//		for(int i = 0; i<choicesList.size(); i++) {
//			String text = choicesList.get(i).getText();
//			if(text.length() !=0) {
//				System.out.println(i + " : " + text);
//			}
//			
//		}
//		
		
		driver.close();

	}

}
