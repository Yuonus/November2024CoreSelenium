package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQueryDropDownHandle {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://jqueryui.com/selectmenu/
//		3.	Switch the driver attention to the iframe.
//		4.	Click on the "Select a speed" dropdown.
//		5.	Find out/verify how many items are there in the dropdown.
//		6.	Print all the items/options of the dropdown to the console.
//		7.	Click on any option of the dropdown.
//		8.	Close the driver.
		
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		
		// Change the focus of the driver to iframe
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		driver.findElement(By.cssSelector("span#speed-button")).click();
		Thread.sleep(4000);
		
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul#speed-menu > li"));
		System.out.println("The total number of options in the dropdown is: " + optionsList.size());
		
//		for(WebElement e :  optionsList) {
//			String text = e.getText();
//			System.out.println(text);
//			
//			if(text.contains("Medium")) {
//				e.click();
//				break;
//			}
//		}
		
//		1 : Slower
//		2: Slow
//		3: Medium
		
		// Indexed for loop
		for(int i =0; i<optionsList.size(); i++) {
			String text = optionsList.get(i).getText();
			System.out.println(i + " : " + text);
			
			if(text.contains("Fast")) {
				optionsList.get(i).click();
				break;
			}
		}
		
//		driver.close();
		
	}

}
