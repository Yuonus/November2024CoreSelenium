package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopups {

	public static void main(String[] args) throws InterruptedException {
		
//		Automation Steps
//		1.	Launch the browser.
//		2.	Navigate to https://the-internet.herokuapp.com/basic_auth
//		3.	Pass the userName and password.
//		4.	Capture the page URL and print it to the console.
//		5.	Capture the page title and print it to the console.
//		6.	Verify if your credentials are correct or not.
//		7.	Close the driver.
		
		WebDriver driver = new ChromeDriver();
		Thread.sleep(4000);
		
		// Hard coded 
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String userName = "admin";
		String password = "admin";
		
		driver.get("https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		

		
	}

}
