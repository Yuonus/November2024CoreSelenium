package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NajeebHW {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		List <WebElement> righttablinklist =  driver.findElements(By.xpath("//aside/div/a"));
		System.out.println("Number of links in the right tab = " + righttablinklist.size());
		for(int i=0; i<righttablinklist.size(); i++) {
			String rightTabLinkText =righttablinklist.get(i).getText();
			System.out.println(i + " ==== " + rightTabLinkText);
		}

	}

}
