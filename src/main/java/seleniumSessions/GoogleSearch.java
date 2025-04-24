package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*			Business Case / Test Scenario
 		Automate this task both Rough code Approach and Utility code Approach
 	1: Open Google.com
 	2: Enter some value in Search field. U can put any Search Key -> "Selenium Automation"
 	3: Use Thread.sleep() method: To give google server some times to generate the suggestions
 	4: Find the number of suggestions popped up.
 	5: Capture the text of each suggestion and print it to console.
 	6: Click on a specific result/suggestion. (for instance: testing jobs)
 	7: Close the browser.
 	8: --> Don't forget to move the utility in to the "ElementUtil" class
 */
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		// Rough Approach
//		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
//		Thread.sleep(2000);
//		
//		List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
//		System.out.println("The number of google suggesion list: "+ suggList.size());
//		
//		for(WebElement e : suggList) {
//			String text= e.getText();
//			
//			if(text.contains("testing jobs")) {
//				e.click();
//				break;
//			}
//			
//		}
		
		
		// Utility part
		By searchField = By.name("q");
		By suggestions = By.xpath("//div[@class='wM6W7d']/span");
//		search(searchField, suggestions, "Selenium Automation", "testing jobs");
//		search(searchField, suggestions, "Global warming", "causes");
		search(searchField, suggestions, "IT Companies", "in virginia");
		
	
	
	}
	
	public static void search(By searchField, By suggestions, String searchKey, String suggNameToClick) throws InterruptedException {
		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(2000);
		
		List<WebElement> suggList = driver.findElements(suggestions);
		System.out.println("The number of google suggesion list: "+ suggList.size());
		
		for(WebElement e : suggList) {
			String text= e.getText();
			
			if(text.contains(suggNameToClick)) {
				e.click();
				break;
			}
			
		}
	}

}
