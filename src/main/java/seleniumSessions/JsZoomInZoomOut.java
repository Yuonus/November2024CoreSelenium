package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsZoomInZoomOut {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		/*		Business Case
					1.	Launch the browser.
					2.	Navigate to https://classic.freecrm.com/.
					3.	Zoom in the page 140%.
					4.	Zoom out the page 30%.
					5.	Close the browser.
		 */
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		Thread.sleep(2000);
		
		//Rough Code Approach
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.body.style.zoom = '140%'");
//		Thread.sleep(2000);
//		js.executeScript("document.body.style.zoom = '30%'");
//		driver.close();
			
		
		// *********** Utility *****************//
		zoomChromeEdgeSafari("140");
		Thread.sleep(2000);
		zoomChromeEdgeSafari("30");
	
	}
	
	
	//************************ Utilities *******************//
	public static void zoomChromeEdgeSafari(String zoomPercentage) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String zoom = "document.body.style.zoom = '"+zoomPercentage+"%'";
		js.executeScript(zoom);
	}
	
	public static void zoomFirefox (String zoomPercentage) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String zoom = "document.object.style.MozTransform = 'scale("+zoomPercentage+")'";
		js.executeScript(zoom);
	}

}
