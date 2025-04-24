package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
	
		// 1: Task
		// Find the total number of links on eBay page. All the links --- <a>
		
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println("Total number of links on eBay page is: " + linkList.size());
		
		// 2: Task
		// Get the text of each link
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println("Total number of links on eBay page is: " + linkList.size());
//		
//		for(int i = 0; i<linkList.size(); i++) {
//			String linksText = linkList.get(i).getText();
//			System.out.println(linksText);
//		}
		
		// 3: Ignore the links that are not having any text
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println("Total number of links on eBay page is: " + linkList.size());
//		
//		for(int i = 0; i<linkList.size(); i++) {
//			String linksText = linkList.get(i).getText();
//			if(linksText.length() !=0) {
//				System.out.println(linksText);
//			}
//			
//		}
		
		
		// 4: Determine which index is having the texts
//		List<WebElement> linkList = driver.findElements(By.tagName("a"));
//		System.out.println("Total number of links on eBay page is: " + linkList.size());
//		
//		for(int i = 0; i<linkList.size(); i++) {
//			String linksText = linkList.get(i).getText();
//			if(linksText.length() !=0) {
//				System.out.println(i + " : " + linksText);
//			}
//			
//		}
		
		//5: Get the href value of each link
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links on eBay page is: " + linkList.size());
		
		for(int i = 0; i<linkList.size(); i++) {
			String linksText = linkList.get(i).getText();
			if(linksText.length() !=0) {
				String hrefValue = linkList.get(i).getDomProperty("href");
				System.out.println(i + " : " + linksText + "======>" + hrefValue);
			}
			
		}

	}

}
