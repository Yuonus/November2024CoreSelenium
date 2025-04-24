package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFunction {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		/*			Test Scenario
		Using the utility methods, automate the following test scenario.
		1: Launch the Browser 
		2: Launch the URL / Navigate to "Your Store" app. "https://naveenautomationlabs.com/opencart/" 
		3: Find the Total numbers of links available in "Your Store" application page. 
		4: Find the total numbers of images available in "Your Store" application page.
		5: Capture the text of each Link and print it to the console.
		6: Verify the links text.
		7: Capture the value of the "href" attribute.
		8: Close the driver.
	    */
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
//		System.out.println(getElements(links).size());
//		System.out.println(getElements(images).size());
		
		int linksCount = getElementsCount(links);
		int imageCount = getElementsCount(images);
		
		System.out.println("Total number of links: " + linksCount);
		System.out.println("Total number of images: "+ imageCount);
		
		List<String> actualLinksTextList = getElementsLinkText(links);
		System.out.println(actualLinksTextList);
		
		if(actualLinksTextList.contains("Components")) {
			System.out.println("Components is the text of one of the links --- Passed.");
		}else {
			System.out.println("Failed");
		}
		
		if(actualLinksTextList.contains("MacBook")) {
			System.out.println("MacBook is the text of one of the links --- Passed.");
		} else {
			System.out.println("Failed");
		}
		
		System.out.println("=========================================================================================================");
		
		List<String> hrefList = getElementAttributeList(links, "href");
//		System.out.println(hrefList);
		for(String e : hrefList) {
			System.out.println(hrefList);
		}
		
		driver.close();

	}
	
	// WAF: Capture specific attribute value from the list
	/**
	 * This method will help to capture the attribute value of any attribute from DOM.
	 * @param locator
	 * @param attrName
	 * @return 
	 * @return List<String>
	 */
	public static List<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>(); // pc = 0
		for(WebElement e : eleList) {
			String attrValue = e.getDomProperty(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}
	
	
//	WAF: Capture the text all page links and return List<String>
	
	/**
	 * This function capture the text of all links in a page and return List<String>
	 * @param locator
	 * @return List<String>
	 */
	public static List<String> getElementsLinkText(By locator) {
		
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>(); // pc = 0
		for(WebElement e : eleList) {
			String text = e.getText();
			
			if(text.length() !=0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
		
	}
	
	
	/**
	 * This function/method returns the number of available web elements in a page.
	 * @param locator
	 * @return int
	 */
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	
	/**
	 *  This function returns list of web elements
	 * @param locator
	 * @return List<WebElement>
	 */
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	

}
