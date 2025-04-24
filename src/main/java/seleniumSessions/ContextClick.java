package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	static WebDriver driver;
	public static void main(String[] args) {
		
		// Context click = Right Click / This is also called Context Menu
		
//		Task:
//		1.	Launch the browser.
//		2.	Navigate to https://swisnl.github.io/jQuery-contextMenu/demo.html
//		3.	Do a right click on the "right click me" web element.
//		4.	Collect all its options.
//		5.	How many options are there after right-clicking?
//		6.	Print the text of all the options into the console.
//		7.	Click on "Copy.".
//		8.	close the driver.
		
		//span[text()='right click me']
//		li.context-menu-icon

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		By rightClickEle = By.xpath("//span[text()='right click me']");
		WebElement contextClickElement = driver.findElement(rightClickEle);
		
		By contextMenuOptions = By.cssSelector("li.context-menu-icon");
		List<WebElement> contextMenuOptionsList = driver.findElements(contextMenuOptions);
		
		Actions act = new Actions(driver);
		act.contextClick(contextClickElement).build().perform();
		
		System.out.println("The total number of options available on context menu are: " + contextMenuOptionsList.size());
		
		for(WebElement e : contextMenuOptionsList) {
			String text = e.getText();
			System.out.println(text);
			
			if(text.contains("Copy")) {
				e.click();
				break;
			}
		}
		
		driver.close();
		

	}

}
