package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

//	Task:
//		1.	Launch the browser.
//		2.	Navigate to https://jqueryui.com/resources/demos/slider/default.html.
//		3.	Find the height and width of the slider element.
//		4.	Move the slider toward the  +X direction.
//		5.	Close the driver.

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement slider = driver.findElement(By.cssSelector("div#slider"));
		// to directly capture the width and height of an element
		System.out.println(slider.getSize());
		
		// To separately capture the width and height of an element
		int sliderWidth = slider.getSize().getWidth();
		int sliderHeight = slider.getSize().getHeight();
		
		System.out.println("The slider width is: " + sliderWidth);
		System.out.println("The slider height is: " + sliderHeight);
		
		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(250, 0).build().perform();
		driver.close();
	}
}
