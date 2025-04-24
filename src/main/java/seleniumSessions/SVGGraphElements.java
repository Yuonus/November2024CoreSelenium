package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGGraphElements {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

//		Business case
//		1.	Launch the browser.
//		2.	Navigate to https://petdiseasealerts.org/forecast-map.
//		3.	Inspect the entire Graph/map.
//		4.	Find how many states are there in US.
//		5.	Move to each and every state on the map (use moveToElement()).
//		6.	Wait for half second to explicitly see the hovering on each and every state.
//		7.	And then print the name of each and every state into the console.
//		8.	Click on one of the states, say Virginia.
//		9.	Close the browser.


//		Hierarchy:  Browser --> iframe ---> SVG
		
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		Thread.sleep(2000);
		// To locate the iframe:  following locating strategies could be used. --- for practice purpose and a refresher for student, different variations were considered
		//iframe[contains(@id,'map-instance')]			-- Xpath using contains method
		//iframe[starts-with(@id, 'map-instance')]		-- Xpath using starts-with method
//		iframe[id*='map-instance']						-- CSS using contains with *
//		iframe[id^='map-in']							-- CSS using starts with ^
		
		WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		driver.switchTo().frame(frame);
		
		List<WebElement> statesOfUSA = driver.findElements(By.xpath("//*[local-name()='svg' and @id = 'map-svg']//*[name() = 'g']//*[name()='g' and @ class = 'region']"));
		int usaStatesCount = statesOfUSA.size();
		System.out.println("There are : " + usaStatesCount + " states in the USA.");
		// hovering the mouse over each and every states
		Actions act = new Actions(driver);
		
		for(WebElement e : statesOfUSA) {
			act.moveToElement(e).perform();
			Thread.sleep(200);
			String text = e.getDomAttribute("id");
			System.out.println(text);
			if(text.contains("virginia")) {
				e.click();
				break;
			}
		}
	
		driver.close();
	}
}
