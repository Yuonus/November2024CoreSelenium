package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsSignature {

//	Task:
//		1.	Launch the browser.
//		2.	Navigate to https://signature-generator.com/draw-signature/.
//		3.	Automate a signature using your Selenium skills.
//		4.	Close the browser.

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");
		
		WebElement canvas = driver.findElement(By.id("signature-pad"));
		
		Actions act = new Actions(driver);
				Action signature = act.click(canvas)
				.moveToElement(canvas, 40, 20)
				.clickAndHold(canvas)
				.moveToElement(canvas, -200, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -60)
				.moveByOffset(8, 8)
				.release()
				.build();
			signature.perform();
		
		
		
	}
}
