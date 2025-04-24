package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframesP {

	static WebDriver driver;
	public static void main (String[] args) throws InterruptedException {
		
//		1.	Open the browser.
//		2.	Navigate to https://selectorshub.com/iframe-scenario/.
//		3.	Send some keys to the "First Crush" input field.
//		4.	Send some keys to the "Current Crush Name" input field.
//		5.	Send some keys to the "Destiny" input field.
//		6.	Work with different switching back scenarios.
//		7.	Grab the text "Memory Test" from the main page.
//		8.	Validate if the test passes or not.
//		9.	Close the browser.

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		Thread.sleep(1500);
		
		// First frame --- F1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("Loving selenium at S_Tech");
		
		// Second Frame --- F2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("My current crush is teaching java");
		
		// Third Frame --- F3
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("The Goal is be paid $150000 by the end of 2025");
		
//		           Use Cases
		
		// First Use Case		Not Valid
		// Frame 3 -- Frame 1 == Invalid Use case
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.id("inp_val")).sendKeys("Loving selenium at S_Tech with Sabawoon Yuonus");
		
		
//		F3 -> F2		--> Not Valid
//		driver.switchTo().frame("pact2");
//		driver.findElement(By.cssSelector("input#jex")).sendKeys("Automation with Selenium v2.0");
		
		
		// 2nd Use Case   F3 --> F2 --> F1		Not Valid
//		driver.switchTo().frame("pact2");
//		driver.switchTo().frame("pact1");
//		driver.findElement(By.id("inp_val")).sendKeys("Loving selenium at S_Tech with Sabawoon Yuonus");
		
//		Lesson taken: We cannot switch back in iframes using "driver.switchTo(). frame();" Method. This method only moves 
//		forward, meaning it is a unidirectional method.
		
		// Third use case: F3 - F1		Not Valid
//		driver.switchTo().parentFrame();
//		driver.findElement(By.id("inp_val")).sendKeys("Loving selenium at S_Tech with Sabawoon Yuonus");
		
		
		// Fourth Use Case F3--F2	Valid
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).clear(); // This line of code will clear the previous inputted line that was "My current crush is teaching java"
		driver.findElement(By.id("jex")).sendKeys("My current crush is teaching java at S_Tech");
		
		// Fifth Use Case  F2 -- F1		Valid
		driver.switchTo().parentFrame();
		driver.findElement(By.id("inp_val")).clear();
		driver.findElement(By.id("inp_val")).sendKeys("Loving selenium at S_Tech with Sabawoon Yuonus");
		
		
		// Sixth Use Case   F1 -- Main page
//		driver.switchTo().parentFrame();
		
		// F3 -> Main Page:  We can directly switch from F3 - main page using following method
		driver.switchTo().defaultContent(); 
		String mainPageText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(mainPageText);
		
		if(mainPageText.equals("Memory Test")) {
			System.out.println("The test passed");
		}else {
			System.out.println("The test failed");
		}
		
		driver.close();
		
		
		
	}
}
