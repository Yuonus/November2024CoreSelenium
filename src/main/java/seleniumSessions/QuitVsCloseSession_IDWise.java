package seleniumSessions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSession_IDWise {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String actualPageTitle = driver.getTitle();
		System.out.println("The page title is: " + actualPageTitle);
		

		
//		driver.quit();  // SID NULL
		
		driver.close(); // invalid session id
		
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String pageTitle = driver.getTitle();   //org.openqa.selenium.NoSuchSessionException: Session ID is null
		System.out.println("the page title is: " + pageTitle);

		
	
		
		
		
		
		
	}

}
