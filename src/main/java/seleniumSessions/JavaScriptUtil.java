package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	public JavaScriptUtil (WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}
	
	public String getTitleByJs() {
		return js.executeScript("return document.title").toString();
	}

	public String getUrlByJs() {
		return js.executeScript("return document.URL").toString();
	}
	
	public void generateJsAlert(String mesg) {
		js.executeScript("alert('"+mesg+"')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();;
	}
	
	// After this "js.executeScript("alert ('"+mesg+"')");" the page/app will be frozen. So, to prevent freezing the page
	// We will add the below code to accept the alert. 
	// Note: if you want to dismiss or cancel the alert you can create a separate utility for cancellation

	public void generateJsConfirm(String mesg) {
		js.executeScript("confirm('"+mesg+"')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	public void generateJsPrompt(String mesg, String value) {
		js.executeScript("prompt('"+mesg+"')");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Alert alrt = driver.switchTo().alert();
		alrt.sendKeys(value);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alrt.accept();
	}
	
	
	public void goBackWithJs() {
		js.executeScript("history.go(-1)");
	}
	
	public void goForwardWithJs() {
		js.executeScript("history.go(1)");
	}
	
	public void refreshWithJs() {
		js.executeScript("history.go(0)");
	}
	
	
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText").toString();
	}
	
	// )" --> coming from javascript script and it is optional
	public void getPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void getPageDown(String customHeight) {
		js.executeScript("window.scrollTo(0, '"+customHeight+"');");
	}
	
	public void getToMiddlePageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2 );");
	}
	
	public void getPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	public void getPageDownWithByTo() {
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}
	
	public void getPageUpWithByTo() {
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
	}

	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * Example: "document.body.style.zoom='200%';
	 * @param zoomPercentage
	 */
	public void zoomChromeEdgeSafari (String zoomPercentage) {
		String zoom = "document.body.style.zoom='"+zoomPercentage+"%'";
		js.executeScript(zoom);
	}
	
	
	/**
	 * Example: document.body.style.MozTransform = 'scale(0.5)';
	 * @param zoomPercentage
	 */
	public void zoomFirefox (String zoomPercentage) {
		String zoom = "document.body.style.MozTransform='scale("+zoomPercentage+")'";
		js.executeScript(zoom);
	}
	
	
	public void drawBorderAroundElement(String borderLineSize, String borderLineColor, WebElement element) {
		js.executeScript("arguments[0].style.border = '"+borderLineSize+"px solid "+borderLineColor+"'", element);
	}
	
	// N done utility == this has hard coded values for color and boder size
	public void drawBorder(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void flash(WebElement element) {
		String bgColor = element.getCssValue("backgroundColor");
		for(int i = 0; i<30; i++) {
			changeColor("rgb(200,0,0)", element); // The color we are passing to flash/high light the element
			changeColor(bgColor, element); // Element original color
		}
	}
	
	private void changeColor(String color, WebElement element) {
//		JavascriptExecutor js = (JavascriptExecutor)driver;// We can remove this line as we have removed from each and every
//		utility methods above as we have supplied it to the starting constructor 
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void sendKeysUsingWIthId(String id, String value) {
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
						// document.getElementById("input-email").value = 'sabawoon@gmail.com'
	}
}
