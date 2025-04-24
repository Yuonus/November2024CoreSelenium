package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		
		
//		Business Case
//		Note: Frame is deprecated
//		1.	Open the browser.
//		2.	Navigate to http://www.londonfreelance.org/courses/frames/index.html
//		3.	Capture the text "Title bar (top.html).".
//		4.	While switching to the frame, use all three approaches: index, ID & name, and web element. To interact with frame elements.
//		5.	Close the browser.
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
	
//		System.out.println(driver.findElement(By.tagName("h2")).getText());
		
//		driver.switchTo().frame(2);
//		driver.switchTo().frame("main");
		
//		System.out.println(driver.findElement(By.tagName("h2")).getText());
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		driver.close();
		
	}

}
