package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {

//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://jqueryui.com/resources/demos/droppable/default.html
//		3.	Drag the source element "Drag me to my target" into the target element "Drop here.".
//		4.	Close the driver.

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		By sourceEle = By.cssSelector("div#draggable");
		WebElement sourceElement = driver.findElement(sourceEle);
		By targetEle = By.cssSelector("div#droppable");
		WebElement targetElement = driver.findElement(targetEle);

		// Solutions, 2 Approaches ---> 1: Approach

		Actions act = new Actions(driver);
//		act
//			.clickAndHold(sourceElement)
//				.moveToElement(targetElement)
//					.release()
//						.build()
//							.perform();

		act.dragAndDrop(sourceElement, targetElement).perform();
		System.out.println("Drag and Drop was successful and the page title is: " + driver.getTitle());

		driver.close();
	}


}
