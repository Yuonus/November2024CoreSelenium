package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLoginTest {
	
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		WebDriver driver = brUtils.launchBrowser("Chrome");
		brUtils.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brUtils.getPageTitle();
		brUtils.pageURL();
		
		
		ElementUtils eleUtils = new ElementUtils(driver);
		
		By eID = By.id("input-email");
		By pWd = By.id("input-password");
		
		eleUtils.doSendKeys(eID, "Sabawoon@stech.com");
		eleUtils.doSendKeys(pWd, "SeleniumIsEasy@Stech");
		
		brUtils.closePage();
		
		
		
		
		
	}

}
