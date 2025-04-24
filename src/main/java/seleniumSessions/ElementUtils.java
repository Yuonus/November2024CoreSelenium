package seleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver; // null

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {

		By by = null;

		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "class":
			by = By.className(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "cssselector":
			by = By.cssSelector(locatorValue);
			break;
		case "linktext":
			by = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(locatorValue);
			break;
		case "tag":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Wrong locator Type is passed.... " + locatorType);
			throw new AutomationException("Wrong Locator Type");

		}

		return by;

	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetElementDomProperty(By locator, String attributeName) {
		return getElement(locator).getDomProperty(attributeName);
	}

	public String doElementGetText(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).getText();
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType, locatorValue).sendKeys(value);

	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));

	}

//				FindElements() Utilities 
	// WAF: Capture specific attribute value from the list
	/**
	 * This method will help to capture the attribute value of any attribute from
	 * DOM.
	 * 
	 * @param locator
	 * @param attrName
	 * @return List<String>
	 */
	public List<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>(); // pc = 0
		for (WebElement e : eleList) {
			String attrValue = e.getDomProperty(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}

//		WAF: Capture the text all page links and return List<String>

	/**
	 * This function capture the text of all links in a page and return List<String>
	 * 
	 * @param locator
	 * @return List<String>
	 */
	public List<String> getElementsLinkText(By locator) {

		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>(); // pc = 0
		for (WebElement e : eleList) {
			String text = e.getText();

			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;

	}

	/**
	 * This function/method returns the number of available web elements in a page.
	 * 
	 * @param locator
	 * @return int
	 */
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	/**
	 * This function returns list of web elements
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void search(By searchField, By suggestions, String searchKey, String suggNameToClick)
			throws InterruptedException {
		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(2000);

		List<WebElement> suggList = driver.findElements(suggestions);
		System.out.println("The number of google suggesion list: " + suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();

			if (text.contains(suggNameToClick)) {
				e.click();
				break;
			}

		}
	}

//	================================= Single Select Drop-down Utilities ====================================================

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public void doSelectDropDownByValue(By locator, String valueAttributeValue) {
		Select select = new Select(getElement(locator));
		select.selectByValue(valueAttributeValue);
	}

	public void doSelectDropDownByContainsVisibleText(By locator, String partialString) {
		Select select = new Select(getElement(locator));
		select.selectByContainsVisibleText(partialString);
	}

	public void selectDropDownOption(By locator, String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("The total number of options tag in select drop-down are: " + optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}

		}
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public List<String> getDropDownOption(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void selectDropDownValue(By locator, String dropDownVlaue) {
		List<WebElement> optionsList = getElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.contains(dropDownVlaue)) {
				e.click();
				break;
			}
		}
	}

	// ******************************************* Actions Utils ***************************************************
	public void parentChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(2000);
		doClick(childMenuLocator);
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

	public void doSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for (char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
	}

	public void doDoubleClick(By locator) {
		Actions act = new Actions(driver);
		act.doubleClick(getElement(locator)).build().perform();
	}

	// ************************************** Wait Utils *****************************************************
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForVisbilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForVisbilityOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void doClickWithWait(By locator, int timeOut) {
		waitForVisbilityOfElement(locator, timeOut).click();
	}

	public void doSendKeysWithWait(By locator, String value, int timeOut) {
		waitForVisbilityOfElement(locator, timeOut).sendKeys(value);
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	// ************************* Waiting for non-web elements --> Page Title -- Page Current URL**********************
	public String waitForTitleContains(String titleFractionString, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleContains(titleFractionString))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(titleFractionString + " : The page title is not present. ...");
			e.printStackTrace();
		}
		return null;
	}

	// Utility for checking the exact title. --- not passing the substring/partial/fraction of the page title
	public String waitForTitleIs(String fullTitleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.titleIs(fullTitleValue))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println(fullTitleValue + " : The page title is not present. ...");
			e.printStackTrace();
		}
		return null;
	}

	// Utility for URL
	public String waitForURLContains(String urlFractionString, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFractionString))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println(urlFractionString + " : The page URL is not present. ...");
			e.printStackTrace();
		}
		return null;
	}

	// Utility for checking the exact/full URL. --- not passing the substring/partial/fraction of the page URL
	public String waitForURLToBe(String fullURLValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(fullURLValue))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println(fullURLValue + " : The page URL is not present. ...");
			e.printStackTrace();
		}
		return null;
	}
	
	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptJSAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}

	public void dismissJSAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();
	}

	public String getJsAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}

	public void enterValueOnJsAlert(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);
	}
	
	
	// ***************** Iframes With Wait Utilities *****************************
	
	public void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public void waitForFrameByIDOrName(String IDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
	}
	
	public void waitForFrameByElement(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	
	public boolean checkNewWindowExist(int timeOut, int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))) {
				return true;
			}
		}catch (TimeoutException e) {
			System.out.println("Number of windows are not the same ...");
		}
		return false;
	}
	
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			} catch (TimeoutException e) {
				System.out.println("Element is not clickable/enabled ...");
			}
		}

	
	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))	
				.withMessage("-- Timeout is done ... Element is not found ...") 
				.ignoring(NoSuchElementException.class); 
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

}
