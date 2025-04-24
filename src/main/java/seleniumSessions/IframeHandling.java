package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeHandling {

	public static void main(String[] args) throws InterruptedException {
		
//		Business Case
//		1.	Open the browser.
//		2.	Navigate to https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/
//		3.	Scroll down to the "Vehicle registration" form.
//		4.	Fill out the registration form.Do not submit it. Also upload a file.
//		5.	Wait for 2 seconds to let the table be loaded.
//		6.	Switch the driver to iframe.
//		7.	Capture this text. "Vehicle Registration Form". Since this text is out of the iframe, we will have to switch back to the main frame.
//		8.	Also capture the text of disabled "Today’s Date.".
//		9.	Close the browser.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		
		driver.findElement(By.xpath("//img[@loading='lazy' and @title = 'Vehicle-Registration-Forms-and-Examples']")).click();
		
		
//		driver.switchTo().frame(0);
		driver.switchTo().frame("frame-one748593425");
		driver.findElement(By.cssSelector("input#RESULT_TextField-1")).sendKeys("S_Tech school");

		
		driver.switchTo().defaultContent();
		String text = driver.findElement(By.xpath("//h3[text()='Vehicle Registration Form']")).getText();
		System.out.println(text);
	}

}
