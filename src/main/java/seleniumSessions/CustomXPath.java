package seleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath{


		static WebDriver driver;
		public static void main(String[] args){
			
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
			
//			Xpath = Address of th element in HTML DOM
//			 1. Absolute xpath = /html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a			
			
//			Test Scenario:
//				•	Navigate to https://naveenautomationlabs.com/opencart/ 
//				•	Locate or find iPhone using absolute Xpath.
//				•	Grab the value of title attribute

//			driver.get("https://naveenautomationlabs.com/opencart/");
//			WebElement iphone = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/a/img"));
//			System.out.println("The value of title attribute is: " + iphone.getDomProperty("title"));
//			
			
//			 2. Relative Xpath =  using only one attribute
			
//			Relative Xpath formula
//			//tagName[@attribute='value']
//				input[@type='text']
//				 input[@placeholder='E-Mail Address']
			
//			Ex: Finding the input search field on Amazon using Relative XPath looks like this.
			//input[@id='twotabsearchtextbox']
			
//			Ex 2: Find the email input field on Your Cart application using Relative Xpath.
			
			//input[@type = 'text']							-- Correct
			//input[@placeholder = 'E-Mail Address']		-- Incorrect

			// XPath different Variations
//			XPath using Logical Operators: OR & AND
			
//			Using and
			
//			XPath=//tagname[@attribute1='value1' and @attribute2='value2']  Or if more attributes:
//			XPath=//tagname[@attribute1='value1' and @attribute2='value2' and @attribute3='value3']
			
//			Using different attributes, locate the search input field of Your Store application.
//			---> //input[@type='text' and @class='form-control input-lg']													2 attributes
//			---> //input[@name=search and @class='form-control input-lg' and @placeholder='Search']							3 attributes
//			---> //input[@type='text' and @class='form-control input-lg' and @placeholder='Search' and     @name='search']. 4 Attributes

			
//		Using or
//			In the case of OR, any one of the conditions should be true or both.
			
//			Ex 1: Locate the first name input field on the registration page.
			//input[@type='email' or @name = 'sabawoon']	---> 1 of 1

		 //input[@type='text' or @type='email'] --> Here both conditions are true.
//			1st condition --> //input[@type='text'] will return 1 of 3
//			2nd condition --> //input[@type='email'] will return 1 of 1
//			Both together will return 1 of 4.
			//input[@type='text' or @type='email' or @type='password'] – 1 of 6

//			XPath Queries
			
//			1:
			//input[@id] ---> 2 matches
			//input[@id] ---> Registration page = 6 matches
			
//			2:
			//input --> 1 of 14
			//div   --> 1 of 53
			
//			3:
			//a 	--> 1 of 81
			
//			List<WebElement> regisPageTotalLinks = driver.findElements(By.xpath("//a"));
//			System.out.println("Total number of links on registration page: ---> " + regisPageTotalLinks.size());
			
//			4:
			//input[@type='text']
			
//			5:
			//input[@id and @type]	---> 1 of 6
			//input[@id or @type]	---> 1 of 14
			
			//6:
			//*			---> 1 of 316
			
//			7:
			//*[button]		---> 1 of 7
			
			
			
//			XPath using text()
			
//			Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//			Capture the text of "Returning Customer".
//			Print the captured text.

			String returnHeader = driver.findElement(By.tagName("h2")).getText();
			System.out.println(returnHeader);  // returns new customer
			
			String returningCustomerHeaderText = driver.findElement(By.xpath("//h2[text()= 'Returning Customer']")).getText();
			System.out.println(returningCustomerHeaderText);
			
//			Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//			Capture the text of "Recurring payments" link
//			Print the captured text.
			System.out.println(driver.findElement(By.xpath("//a[text()='Recurring payments']")).getText());
			
//			Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//			Capture the text of " By creating an account you … paragraph" 
//			Print the captured text.
			String paragraphText = driver.findElement(By.xpath("//p[text()=\"By creating an account you will be able to shop faster, be up to date on an order's status,"
					+ " and keep track of the orders you have previously made.\"]")).getText();
			System.out.println(paragraphText);
				
//						text () combination with attribute:
//			Syntaxes:
				// tagname[text() ='Text of the Web Element' and @attribute='value']
				// tagname[text() ='Text of the Web Element' and @attribute1='value1' and @attribute2='value2']

//			Example: Inspect "My Account," and form it in Xpath using the text() and attribute combination.
			//a[text()='My Account' and @class='list-group-item']
			
			
			
//			XPath using Contains()
//			Contains() Types
//				contains() with Attributes
//				contains() with text()

			
//					Contains() with Attributes
//			The syntax for using the Contains() method in XPath is"
			
//			//tagname[contains(@attribute, 'AttValue')]
//			//tagname[contains(@attribute1, 'AttValue1') and @attribute2 = 'AttValue2']
			
//			Ex:
			//input[contains(@placeholder, 'E-Mail')]
			//input[contains(@placeholder, 'Address')]
			
			//input[contains(@placeholder, 'Address') and @type= 'text']
			//input[contains(@placeholder, 'Address') and @type= 'text' and @class='form-control']
				
//			We can also use the repeated contains() function at the third element
			
//			//tagname[contains(@attribute1, 'AttValue1') and (@attribute2 = 'Value2') and contains(@attribute3, 'AttValue3')]
//			//tagname[contains(@attribute1, 'AttValue1') and contains(@attribute2, 'AttValue2')]
//
//			Ex:
			//input[contains(@id,'email') and (@type = 'text') and contains(@name,'email')]
			//input[contains(@id,'email') and contains(@type,'text') and contains (@class,'form-control')]
			
			
			
						//contains() with text()
//			syntax:	//tagname[contains(text(),'value')]
			
//			Task:
//			Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//			Inspect the "Returning Customer" header and return it.
//			Inspect the "Returning Customer" header’s paragraph
			//h2[contains(text(), 'Returning')]
			
			String returninCustHeaderText = driver.findElement(By.xpath("//h2[contains(text(), 'Returning')]")).getText();
			System.out.println(returninCustHeaderText);
			
			
//			Task 2:
//				Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//				Inspect the "Returning Customer" header’s paragraph and return its text.

			    //p[contains(text(), 'orders you have')]
			System.out.println(driver.findElement(By.xpath("//p[contains(text(), 'orders you have')]")).getText());
			
			
			
							//	contains() with text() and contains with attributes:
//				Syntax
//				//tagname[contains(text(),'Value')and contains(@Attribute, 'Value')]		
			
//			Ex:
			//a[contains(text(),'Register') and contains(@class,'list-group-item')]
			//a[contains(text(),'Forgotten Password') and contains(@class,'list-group-item')]
			
//			Task:
//				Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//				Inspect the "Register" and grab its text.

			System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Register') and contains(@class,'list-group-item')]")).getText());
			
			
			
				// Contains() can be used with Dynamic Elements:
			
////		<input id = firstname_123>
////				<input id = firstname_123> 	--> Refresh the page
////				<input id = firstname_124>	--> Refresh the page
////				<input id = firstname_125>	--> Refresh the page
////				<input id = firstname_126>	--> Refresh the page
//			driver.findElement(By.id("firstname_123")).sendKeys("S_Tech"); --> Invalid

//		//input[contains(@id,'firstname_')]		--> Valid
			
			
			
				// XPath using starts-with()
//			Syntax for using Starts-With() method:
				 //tagname[starts-with(text(), 'value')]
				//tagname[starts-with(text(), 'value') and @attribute, 'Value']
				//tagname[starts-with(@attribute, 'value')]
//			ex:
			//p[starts-with(text(), 'By creating an account ')]
			
//			Task :
//				Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//				Inspect the "Returning Customer" header’s paragraph and return its text.

			System.out.println(driver.findElement(By.xpath("//p[starts-with(text(), 'By creating an account ')]")).getText());
			
			
					// XPath using ends-with()
//			XPath using ends-with() has been deprecated.

			//tag[contains(attribute, 'value') and ends-with(attribute,
			
			
			
			
			
			driver.close();
			
					
			
		}	
	

}

	
	


