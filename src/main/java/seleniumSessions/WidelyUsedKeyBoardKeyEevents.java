package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WidelyUsedKeyBoardKeyEevents {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 	Enter
		 	selecting all
		 	copying
		 	pasting
		 */

//		Automation steps
//		1.	First, navigate to "https://demoqa.com/text-box"
//		1.	Secondly, enter the full name: "Sabawoon Yuonus.".
//		2.	Thirdly, enter the Email: "sabawoon@stech.com"
//		3.	After that, enter the Current Address: "5001 Seminary Rd., Alexandria, VA."
//		4.	Fifthly, select all the Current Address text box and copy the Current Address.
//		5.	After that, paste the copied address in the Permanent Address text box.
//		6.	Finally, validate that the text in the Current Address and Permanent Address is the same.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		Thread.sleep(3000);
		
		
		// Locators
		By uName = By.cssSelector("input#userName");
		WebElement userName = driver.findElement(uName);
		
		By email = By.cssSelector("input#userEmail");
		WebElement emailAdd = driver.findElement(email);
		
		By cAdd = By.xpath("//textarea[@id='currentAddress']");
		WebElement currentAddress = driver.findElement(cAdd);
		
		By pAdd = By.xpath("//textarea[@id='permanentAddress']");
		WebElement permanentAdd = driver.findElement(pAdd);
		
		Actions act = new Actions(driver);
		act.sendKeys(userName, "Sabawoon Yuonus").build().perform();
		act.sendKeys(emailAdd, "sabawoon@stech.com").perform();
		act.sendKeys(currentAddress, "5001 Seminary Rd., Alexandria, VA").perform();
		
		currentAddress.sendKeys(Keys.CONTROL + "a");
		currentAddress.sendKeys(Keys.CONTROL + "c");
		
		currentAddress.sendKeys(Keys.TAB);
//		act.sendKeys(Keys.TAB).perform();
		permanentAdd.sendKeys(Keys.CONTROL + "v");
		
		if(currentAddress.getText().equals(permanentAdd.getText())){
			System.out.println("Both texts are matching --  TEST PASSED.");
			
		}else {
			System.out.println("Both texts are not matching --- Test failed.");
		}
		
//		Assignment
		/*
		 	Assignment
		 	In the continuation of bullet number 6, click on Submit button
		 	capture all the texts that appears after clicking submit button
		 */
		
	}

}
