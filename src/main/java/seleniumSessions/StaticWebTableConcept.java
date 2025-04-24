package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableConcept {

	static WebDriver driver;
	public static void main (String[] args) {
		
		/*					Interview Question
			 1.	Navigate to https://www.w3schools.com/html/html_tables.asp
			 2.	Capture (give me) the column-specific values.
		 */
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[5]/td[1]
		//table[@id="customers"]/tbody/tr[6]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]
		
		String beforeXPath = "//table[@id='customers']/tbody/tr[";
		String afterXPath = "]/td[1]";
		
		for(int row = 2; row<=rowCount; row++) {
			String actXPath = beforeXPath + row + afterXPath;
//			System.out.println(actXPath);
			String compName = driver.findElement(By.xpath(actXPath)).getText();
			System.out.println(compName);
		}
		
//		(//td[text()='Alfreds Futterkiste']/parent::tr/preceding-sibling::tr/child::th)[1]
		
		
		// doing the above task using the Xpath pattern, loop them, fetch the text and print it
		//th[text()='Company']/parent::tr/following-sibling::tr/td[1] -- this xpath will only give you the values under the company column
		//th[text()='Company']/parent::tr/following-sibling::tr  -- this xpath will give you the whole table
		
		
		
//		ASSIGNMENTS
		//Also determine/find out that what is "Alfreds Futterkiste" column name?
//		String text = driver.findElement(By.xpath("//td[text()='Alfreds Futterkiste']/parent::tr/preceding-sibling::tr/th[text()='Company']")).getText();
//		System.out.println("Alfred's:" + text);
		
		
//		List<WebElement> tableData = driver.findElements(By.xpath("//th[text()='Company']"
//				+ "/parent::tr/following-sibling::tr/td"));
//		for(WebElement e : tableData) {
//			String tableAllData = e.getText();
//			System.out.println(tableAllData);
//		}
		
	
		
	}
}
