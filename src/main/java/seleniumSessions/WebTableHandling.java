package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

	
		
//		Task:
//			1.	Navigate to https://selectorshub.com/xpath-practice-page/
//			2.	Scroll down to "Users Table."
//			3.	Click on the check box for "Joe Root" or any other username.
//			4.	What is the user role of "Joe Root"? Locate and print it to the console.
//			5.	What are all the other properties for "Joe Root"? locate and print them to console
//			6.	Close the driver.

		//a[text()= 'Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//a[text()='Joe.Root']/parent::td/preceding-sibling::td/child::input[@type='checkbox'] ---Using the child key word instead
		// instead of one forward slash for direct child.
		//a[text()= 'John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']
		//a[text()= 'Kevin.Mathews']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//a[text()='Joe.Root']/parent::td/following-sibling::td
		
		
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		
		// Test  --> see if the XPath is working fine or not.
//		driver.findElement(By.xpath("//a[text()= 'Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		
		selectUser("Joe.Root");
		selectUser("John.Smith");
		selectUser("Kevin.Mathews");
//		
//		getUserInfo("Joe.Root");
//		getUserInfo("Kevin.Mathews");
//		
		List<String> joeDetails = getUserInformation("Joe.Root");
		List<String> jasmineDetails = getUserInformation("Jasmine.Morgan");
		
		System.out.println(joeDetails);
		System.out.println("----------------------------");
		System.out.println(jasmineDetails);
		
		// Verification
		if(joeDetails.contains("Joe Root")) {
			System.out.println("TEST PASSED.");
		}else {
			System.out.println("Test FAILED.");
		}
		
		if (jasmineDetails.contains("Jasmine Morgan")) {
			System.out.println("Test passed for Jasmine");
		}else {
			System.out.println("Test failed.");
		}
//		

		// HW: Clicking all the checkboxes
//		By selectingTableRows = By.xpath("//input[contains(@id,'ohrmList_chkSelectRecord_')]");
//
//		List<WebElement> tableRows = driver.findElements(selectingTableRows);
//		for (WebElement e : tableRows) {
//			e.click();
//		}
//				
//
	}
	
	
	// Utilities
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()= '"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
		.click();
	}
	
	
	// If you don't return what you have captured, you wouldn't able to perform verification.
	public static void getUserInfo(String userName) {
		List<WebElement> colValueList1 = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		for(WebElement e : colValueList1) {
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	public static List<String> getUserInformation(String userName) {
		List<WebElement> colValueList = driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		List<String> colValues = new ArrayList<String>();
		for(WebElement e : colValueList) {
			String text = e.getText();
			colValues.add(text);
		}
		return colValues;
	}

}
