package seleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLoacator {

	
//								Element4 (Above)
//									|
//			Element2 (Left) <---- Element (Base)  ----> Element1 (Right)
//									|
//								Element3 (Below)
//				Element5 (near)
	
//	Task:
//		1.	Launch the browser.
//		2.	Navigate to https://www.aqi.in/dashboard/canada.
//		3.	Create the base/main element.
//		4.	Go to the right side of the base element and capture its text. --> AQI-US Index
//		5.	Go to the left side of the base element and capture its text. --> Rank
//		6.	Go to the above side of the base element and capture its text. --> could be any text
//		7.	Go to the below side of the base element and capture its text. --> could be any text
//		8.	Go to the nearest element of the base element and capture its text. --> could be any text
//		9.	Go to the 2nd nearest element of the base element and capture its text. --> could be any text
//		10.	Capture all the cities below "Peterborough, Canada.".
//			Use the driver.findElements() method.
//			And start from index 4.
//		11.	Close the browser.

	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement scrollToPopulatedCities = driver.findElement(By.xpath("//p[text()='Most Polluted Cities 2025']"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(scrollToPopulatedCities).build().perform(); 
		
		WebElement baseElement = driver.findElement(By.xpath("//p[text()='Prince George']"));
		// right of element
//		String rightTextAQI = driver.findElement(RelativeLocator.with(By.cssSelector("text[fill = 'currentColor']")).toRightOf(baseElement)).getText();
		String rightTextAQI = driver.findElement(RelativeLocator.with(By.tagName("text")).toRightOf(baseElement)).getText(); // Better to select with the tagName
		System.out.println("AQI of Prince George is: " + rightTextAQI);
		
		// Left of Element
//		String leftText = driver.findElement(RelativeLocator.with(By.xpath("//P[text()='3']")).toLeftOf(baseElement)).getText();
//		String leftRankText = driver.findElement(RelativeLocator.with(By.tagName("p")).toLeftOf(baseElement)).getText(); // way good, as the table is dynamic and the index 3 could change any time if the weather gets better in this city.
		String leftRankText = driver.findElement(with(By.tagName("p")).toLeftOf(baseElement)).getText();
		System.out.println(leftRankText);
		
		// Above element
//		String aboveCity = driver.findElement(RelativeLocator.with(By.xpath("//P[text()='Hinton']")).above(baseElement)).getText();
//		System.out.println(aboveCity); // dont use xpath text method as the cities can change any second and selenium will throw NoSuchEEx try to locate it uisng tagname
		
//		String aboveCity = driver.findElement(RelativeLocator.with(By.tagName("/p")).above(baseElement)).getText();
		String aboveCity = driver.findElement(with(By.tagName("p")).above(baseElement)).getText();
		System.out.println(aboveCity);
		
		// Below element
//		String belowCity = driver.findElement(RelativeLocator.with(By.xpath("//P[text()='Quesnel']")).below(baseElement)).getText();
//		System.out.println(belowCity); // dont use xpath text method as the cities can change any second and selenium will throw NoSuchEEx try to locate it uisng tagname
		
//		String belowCity = driver.findElement(RelativeLocator.with(By.tagName("p")).below(baseElement)).getText();
		String belowCity = driver.findElement(with(By.tagName("p")).below(baseElement)).getText();
		System.out.println(belowCity);
		
		/*				Note
		 	--> In each of the above methods, the RelativeLocator.with() is repeated. And we don't want to have boiler plate code (repetitive code)
		 	--> To handle this case, we will do one static import. In this import will be importing the with static method.
		 		import static org.openqa.selenium.support.locators.RelativeLocator.with;
		 	--> Advantage: Now you don't need to call the class name RelativeLocator in order to use its static method. You can simply remove all the RelativeLocator from
		 		your code base.
		 	--> Static import is only applicable for static methods.
		 */
		
		// Nearest element
		String nearElement = driver.findElement(with(By.tagName("div")).near(baseElement)).getText();
		System.out.println(nearElement);
		
//		String nearElement2 = driver.findElement(with(By.xpath("//div[text()='Moderate']")).near(baseElement)).getText();
//		System.out.println("Second nearest element is: " + nearElement2);
		
		List<WebElement> allBelowBaseElementsText= driver.findElements(with(By.xpath("//p[@class='font-bold text-[1.5em] sm:text-[1.7em] truncate']")).below(baseElement));
		System.out.println("Number of cities below the base element: " + allBelowBaseElementsText.size());
		
		for (WebElement e : allBelowBaseElementsText) {
			String belowCites = e.getText();
			System.out.println(belowCites);
		}
	}
	

}
