package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		
//		Automation Scenario
//		1.	Launch the browser.
//		2.	Navigate to https://blueimp.github.io/jQuery-File-Upload/
//		3.	Attach/upload a file.
//		4. 	Click on Start upload button
//		5.	Cancel the uploaded File. To cancel the uploaded file click on the Cancel upload button.
//		6.	Close the browser.
		
		// AutoIT
		// Robot
		// Sikuli
		// sendkeys()
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		Thread.sleep(4000);
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys("C:\\Users\\syuon\\Downloads\\IMG_4715.jpg");
		
		WebElement fileSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		fileSubmit.click();
		
		driver.findElement(By.xpath("//button[@type='reset']")).click();
		driver.close();
	}
}
