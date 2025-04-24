package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAssignment {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
//		Assignment
//		1.	Open the browser.
//		2.	Navigate to https://mail.rediff.com/cgi-bin/login.cgi
//		3.	Click on the "Sign in" button without inserting any text into the text fields.
//		4.	Switch the driver focus to the alert.
//		5.	Capture the text of the alert.
//		6.	Accept the alert.
//		7.	Insert a username, leave the password input field empty, and click on "Sign in.".
//		8.	Accept the alert.
//		9.	Insert a username and password input field, and click on "Sign in.".
//		10.	Close the browser.

		
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(2000);
		WebElement signIn = driver.findElement(By.xpath("//input[@title='Sign in']"));
		signIn.click();
		Alert alrt = driver.switchTo().alert();
		String text = alrt.getText();
		System.out.println("The text of the alert is: " + text);
		alrt.accept();
		
		WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("Sabawoon");
		signIn.click();
		
		Alert altr = driver.switchTo().alert();
		altr.accept();
		Thread.sleep(2000);
		userName.clear();
		Thread.sleep(2000);
		userName.sendKeys("S_Tech");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Love123$");
		signIn.click();
		driver.close();
	}

}
