package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {
	
	public static void main (String[] args) {
		
		
//		1: Launch the Browser
//		2: Launch the URL. "https://www.ebay.com/"
//		3: Find the Total numbers of images available in eBay homepage.
//	    4: Capture the values of "alt", and "src" attributes for each image. And print them to the console,
//		   using indexed for each loop and enhanced for loop.
		
//		Note: 
//			For the second time using the enhanced for loop to print the values of "alt" & "src", it should
//			look like this: and also add a space after each iteration
//	alt: Ring Pop Halloween Candy 20 Count - Bulk Lollipop Individually Wrapped Party Pack - Candy Lollipop Suckers w/ Assorted...
//	src: https://m.media-amazon.com/images/I/91eiAEgD4yL._AC_SY200_.jpg
		
//		5: Close the driver
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images on eBay home page is: " + imageList.size());
		
		for (WebElement e : imageList) {
			String srcValue = e.getDomProperty("src");
			String altValue = e.getDomProperty("alt");
			
			System.out.println(altValue + " ---- > " + srcValue);
			
			// If you want to print them each in a new line
//			System.out.println(altValue + "\n" + srcValue);
		}
		
		
//		for(WebElement imageList : imageLists) {
//			String alt = imageList.getAttribute("alt");
//			String src = imageList.getAttribute("src");
//				if(alt.length()!=0) {
//					System.out.println("alt: " + alt + "\n"); 
//				}
//				if(src.length() !=0) {
//					System.out.println("src: " + src);
//				}
//		}
		
	}

}
