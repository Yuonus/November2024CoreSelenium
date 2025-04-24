package seleniumSessions;

public class OpenCartTest {
	
	
	public static void main(String[] args) {
		
		/*		Test Script
	 	1. Launch the browser
	 	2. Navigate to "https://naveenautomationlabs.com/opencart/index.php?route=account/login"
	 	3. Get the Title of the page.
	 		3.1 -> Verify if the page title matches the actual page title or not.
	 	4. Get the URL of the page.
	 		4.1 --> Verify if the URL is correct or not.
	 	5. Close the browser.
	    */
		
		BrowserUtils brUtils = new BrowserUtils();
//		brUtils.driver.get("https://www.google.com");
		
		brUtils.launchBrowser("firefox");
		brUtils.launchURL("https://naveenautomationlabs.com/opencart/");
		
		String pageTitle  = brUtils.getPageTitle();
		if(pageTitle.equals("Your Store")) {
			System.out.println("The page title is correct --- Test passed");
		}else {
			System.out.println("Page title is incorrect --- test failed.");
		}
		
		
		String pageUrl = brUtils.pageURL();
		if(pageUrl.contains("opencart")) {
			System.out.println("Test passed.");
		}else {
			System.out.println("Test failed.");
		}
		
		brUtils.closePage();
//		brUtils.quitPage();
		
	
	}

}
