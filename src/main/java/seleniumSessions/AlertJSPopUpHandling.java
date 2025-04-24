package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertJSPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		
//		Automation Steps
//		1.	Open the browser.
//		2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts
//		3.	Click on "Click for JS Alert."
//		4.	Switch the driver focus to the alert.
//		5.	Capture the text of the alert.
//		6.	Before accepting the alert wait for 2 seconds.
//		7.	Accept the alert.
//		8.	Close the browser.
		
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		
//		Alert alrt = driver.switchTo().alert();
//		String text = alrt.getText();
//		System.out.println(text);
//		Thread.sleep(2000);
//		alrt.accept();
//		driver.close();
		
		
//		Task:
//		1.	Open the browser.
//		2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts
//		3.	Click on "Click for JS Confirm."
//		4.	Switch the driver focus to the alert.
//		5.	Capture the text of the alert.
//		6.	Accept the alert and then cancel the alert.
//		7.	Close the browser.
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Alert alrt = driver.switchTo().alert();
//		String text = alrt.getText();
//		System.out.println("The Confirm text is: " + text);
//		Thread.sleep(2000);
////		alrt.accept();
//		alrt.dismiss();
//		driver.close();
		

//		Task:
//			1.	Open the browser.
//			2.	Navigate to https://the-internet.herokuapp.com/javascript_alerts 
//			3.	Click on "Click for JS Prompt."
//			4.	Switch the driver focus to the alert.
//			5.	Capture the text of the alert.
//			6.	Send some keys in the pop-up input field. "S_Tech is a pleasant place to learn software automation."
//			7.	Either accept or cancel the pop-up.
//			8.	Close the browser.

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alrt = driver.switchTo().alert();
		String text = alrt.getText();
		System.out.println("The prompt text is:" + text);
		alrt.sendKeys("S_Tech is a pleasant place to learn software automation");
		Thread.sleep(8000);
		alrt.accept();
		driver.close();
	}

}
