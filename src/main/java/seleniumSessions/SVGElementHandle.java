package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementHandle {

	static WebDriver driver;
	public static void main(String[] args) {

//		Business case:
//			1.	Launch the browsers.
//			2.	Navigate to https://www.flipkart.com/.
//			3.	Type "MacBooks" in the search field.
//			4.	Click on the "search SVG" icon.

		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		WebElement searchField = driver.findElement(By.xpath("//input[@name= 'q']"));
		searchField.sendKeys("MacBooks");
		
		driver.findElement(By.xpath("//*[local-name() = 'svg']//parent::button")).click();
		
		driver.close();
	}

}
