package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// Locate the email, password, and login: using string locator strategy
		
		String email_id = "input-email";
		String password_id = "input-password";
		String loginBtn_xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";
		String registerLink_linkText = "Register";
		
		// Create the element 
		// perform the action
		
		ElementUtils eleUtils = new ElementUtils(driver);
		eleUtils.doSendKeys("id", email_id, "sabawoon@stech.com");
		eleUtils.doSendKeys("id", password_id, "SeleniumIseasy");
//		eleUtils.doClick(loginBtn_xpath);
		eleUtils.doClick("xpath", loginBtn_xpath);
		
		String regist_LinkText = eleUtils.doElementGetText("linktext", registerLink_linkText);
		System.out.println("The REGISTER Link text is: "+regist_LinkText);
		

		
		
	}

}
