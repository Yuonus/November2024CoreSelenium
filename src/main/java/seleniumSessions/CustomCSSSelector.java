package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
//		driver.get("https://app.hubspot.com/login");
		driver.get("https://app.hubspot.com/login/legacy");
		
//		CSS Selector = Cascade Style sheet
		/*
		 	1: ID
		 	2: Class
		 	3: Attributes
		 	4: Substring
		 	5: Combining Attributes
		 */
		
//		ID
//		A) wild card #
		
//		TASK:
//			Using a CSS selector, create the CSS expression of the first name input field on the registration page.
//		Syntaxes:
//		CSS = tagName [attributeName = 'attrValue']
//		tagName+#+idValue  - ---> input#input-firstname
//		#idValue			----> #input-firstname
		
//		Solutions
//		input[id= 'input-firstname']
//		input#input-firstname
//		#input-firstname
		
		
//					 Class
//		1: Special Character = .
		
//		TASK:
//			Using a CSS selector, create the CSS expression of the first name input field on the registration page using the class attribute.
//		Syntaxes/formulas
//		tagName[attrName = 'attrValue']
//		tagName+.+classValue
//		.+classValue
		
//		input[class = 'form-control']
//		input.form-control
//		.form-control
		
		
//								Multiple classes
//		Formula
//		.C1.C2.C3.Cn
		
//		Task: Using a CSS selector, create the CSS expression of the search input field on the registration page using the class attribute.
//		.form-control.input-lg 	--> 2 classes
		
//		.form-control.private-form__control.login-email	--> 3 classes
		
//		uiButton private-button private-button--primary private-button--default m-bottom-4 login-submit disabled private-button--disabled private-button--non-link
//		.uiButton.private-button.private-button--primary.private-button--default.m-bottom-4.login-submit.disabled.private-button--disabled.private-button--non-link  --> 9 classes
//		
		
//		Class and ID Combination
//		Syntaxes:
//		#id.class
//		.class#id
//		
//		Sequence does not matter.
		
//		TASK:
//		Using a CSS selector, create the CSS expression of the first name input field on the registration page using the class and id attributes.
		
//		.form-control#input-firstname
//		#input-firstname.form-control
		
//		Task
//		Using a CSS selector, create the CSS expression of the email input field on the login page of HubSpot app using the class and id attributes.
//		.uiButton.private-button.private-button--primary.private-button--default.m-bottom-4.login-submit.disabled.private-button--disabled.private-button--non-link#loginBtn
		
		
//							Attributes
//		tagName [attrName = 'attrValue']			--> 1 Attribute
		
//		input[name='email']
//		input[placeholder='Password']
		
		
		
//									Multiple Attributes/properties
//		Formula: tagName[Attr1 = 'attr1Value'][Attri2 = 'Attri2Value'][Attri3 = 'Attri3Value']
//				input[type='text'][name='email'][placeholder='E-Mail Address'][class='form-control']
		
//		input[aria-describedby='undefined-help undefined-description'][type='password']
		
//								One Interview Question
					/*
					 	1: Navigate to: https://app.hubspot.com/login
					 	2: Locate the "Email address" input field using the className locator.
					 	3: Send some keys. enter your email
					 	4: Will the Selenium send the keys you have entered? If Yes, how? If No, how?
					 	Out of these 4 variations which one is correct?
					 */
		
//		1:
//		driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("Sabawoon@stech.com");   --> Invalid
//		InvalidSelectorException: Compound class names not permitted
		
//		2:
//		driver.findElement(By.className("login-email")).sendKeys("Sabawoon@stech.com");   --> Valid
		
//		3:
//		driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("Yuonus@gmail.com");  ---> Valid
		
//		4:
//		driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("Abaseen@gmail.com");
		
		
//								text();  --> CSS does not support text() and it is one of the major draw backs of the CSS Selector in selenium
		
		
		
							// Substring
		/*
		 			"E-Mail Address"	--> Address,   ---> ress		=---> E-Ma
		 			"Sabawoon Yuonus"	--> Sabawoon,	--> Yuonus
		 */
		
//		contains
//		starts-with
//		ends-with --> deprecated
		/*
	 		1) Matching a substring (contains: *):
	 		2) Matching a Prefix (starts with: ^)
	 		3) Matching a suffix (Ends with: $):
		 */
		
		
//		Task:
//			a.	Go to https://naveenautomationlabs.com/opencart/index.php?route=account/login
//			b.	Inspect the "E-Mail Address"
		
		
//		1) Matching a substring (contains: *):    ---> Syntax tagName[attribute*='substring']
//		input[placeholder*='E-Mail']
//				input[placeholder*='Address']
//						input[placeholder*='E-Mail Address']
		
		
//		2) Matching a Prefix (starts with: ^)    --> Formula   tagName[attribute^='Prefix of the string']
//		Task:
//			a.	Go to https://naveenautomationlabs.com/opencart/index.php?route=account/login
//			b.	Inspect the "E-Mail Address".
		
//		input[placeholder^='E-Mai']
//		input[placeholder^='E-Ma']
//		input[placeholder^='E-M']
//		input[placeholder^='E-']
//		input[placeholder^='E']
		
//		3) Matching a suffix (Ends with: $):   --> Formula   tagName[attribute$='suffix of the string']
//		Task:
//		a.	Go to https://naveenautomationlabs.com/opencart/index.php?route=account/login
//		b.	Inspect the "E-Mail Address".
		
//		input[placeholder$='ress']
//		input[placeholder$='Address']
		
		
		
//		 Parent to child (Parent to immediate Children/ direct child)
//				--> >
//		Syntax:
//			tagName[attribute='attributeValue'] > childTagName
			
		
//		Task:
//			a.	Go to https://orangehrm.com/en/30-day-free-trial
//			b.	Inspect the "Country" dropdown.
//			c.	Construct the CSS parent-to-child expression for it.
		
		// This is how it will look in XPath
		//select[@id='Form_getForm_Country']//option
		//select[@id='Form_getForm_Country']/option
//		
//		select[id='Form_getForm_Country'] > option
//		#Form_getForm_Country > option
		
		
		
//		Parent to child (indirect children)    ----> space only
//		number of spaces does not matter
//		preferrably one space is recommended
//		Syntax:
//			tagName[attribute = 'AttrValue'] space childTagName
		
		
//		Task:
//		a.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/register
//		b.	Inspect the left-hand side page. Everything under Register Account, which is presented under.
//		c.	Construct its CSS Selector and capture all its children.
//		Capture all following indirect children:
//			Input
//			div
//			form
//			label 
		
		
//		
//		div[id='content'] input
//		div[id='content'] div
//		div[id='content'] form
//		div[id='content'] label
		
//		
//		Child-to-parent in CSS
//		..> css does not support Child-to-parent
//		..> child to ancestor is not allowed
//		.. > preceding-sibling is not allowed - --> backward traversing not allowed
		
		
//		Sibling Concepts in CSS
//		1: Immediate sibling ---> +
//		2: Indirect Sibling ----> ~  ---> tilde
		
//		Formula
//		tagName[attribute = 'attributeValue'] + siblingTagName
		
		
//		Task:  Direct sibling  == only returns immediate/direct siblings
//		a.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//		b.	Inspect label "E-Mail Address."
//		c.	Construct its CSS Selector.
		
//		label[for='input-email'] + input
		
		
//		Task 2:
//			Indirect Sibling  == both immediate and indirect siblings
//			a.	Navigate to https://naveenautomationlabs.com/opencart/index.php?route=account/login 
//			b.	Inspect label "Password."
//		label[for='input-password'] ~ a
		
		
		
//		Comma in CSS Selector
		// if you want to specify all the important elements in a page and store them in one locator use comma in CSS.
		
//		#idValue, #idValue, #idValue
		
		
//		Task:
//		•	Navigate to https://app.hubspot.com/login/legacy
//		•	Pretend that "Email address," "Password," "Log in," and "Remember me" are important elements and store them in one selector 
//		(rather than creating four By locators for it).
//		•	Verify if these elements are present on the page or not.
		
		
		
//		#username,#password,#loginBtn,#checkbox-content-4
//		tagName #idValue, tagName[attribute = 'attributeValue'], tagName[attribute='attrValue'] 
//		input#username,input[id='password'],button[type='submit'],i18n-string[data-key='login.form.remember']
		
		
//		int loginPageElements = driver.findElements(By.cssSelector("#username,#password,#loginBtn")).size();
//		System.out.println("The important elments on login page are: " + loginPageElements);
//		
		
		int loginPageElements = driver.findElements(By.cssSelector("input#username,input[id='password'],button[type='submit'],i18n-string[data-key='login.form.remember']")).size();
		System.out.println("The important elments on login page are: " + loginPageElements);
		
//		if (loginPageElements == 4) {
//			System.out.println("Verification passed --- Test Passed");
//		}else {
//			System.out.println("Test failed");
//		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
