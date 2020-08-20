package Pages;

//import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
//import generalutils.ExcelUtils;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
import generalutils.log;

public class BasePage {

	String userName = "storefront";
	String password = "root5";
	String url = "dev.roots.com/";
	String targetUrl = "https://" + (userName) + ":" + (password) + "@" + (url);
	public static WebDriver driver;
	public static LandingPage landingPage;
	public static SignUpPage signUpPage;
	public static ApiAutomationPage apiAutomationPage;
	public static Hook hooks;
	protected WebDriverWait wait;
	static String projectPath = System.getProperty("user.dir");
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	//String reportConfigPath="/Users/ektkripl/Desktop/new Project/CucumberJava/extent-config.xml";

	public WebDriver getDriver() {
		try {
			System.getProperty("webdriver.chrome.driver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(targetUrl);
		}

		finally {
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			hooks = PageFactory.initElements(driver, Hook.class);
			landingPage = PageFactory.initElements(driver, LandingPage.class);
			signUpPage = PageFactory.initElements(driver, SignUpPage.class);
			apiAutomationPage = PageFactory.initElements(driver, ApiAutomationPage.class);
			

		}
		return driver;
	}
	
	public static void grabScreenshotForReport(WebDriver driver, Scenario scenario) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	/** get current page url */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/** load page for specified URL */
	public void openApplication(String URL) {
		driver.get(URL);
	}

	/** get current window handle */
	public String getWindow() {
		log.info("getting window handle");
		return driver.getWindowHandle();
	}

	/** get list of open windows */
	public Set<String> getWindows() {
		return driver.getWindowHandles();
	}

	/** switch to specified frame */
	public void switchFrame(WebElement targetFrame) {
		log.info("switching to the frame with id = " + targetFrame);
		driver.switchTo().frame(targetFrame);
	}

	/** switch to window based on handle */
	public void switchWindow(String windowHandle) {
		log.info("switching to the new window");
		driver.switchTo().window(windowHandle);
	}

	/** switch to first frame */
	public void switchDefault() {
		log.info("switching to default page content frame");
		driver.switchTo().defaultContent();
	}

	/** browser back navigation action */
	public void back() {
		log.info("browser back");
		driver.navigate().back();
	}

	/** browser forward navigation action */
	public void forward() {
		log.info("browser forward");
		driver.navigate().forward();
	}

	/** browser page refresh action */
	public void refresh() {
		log.info("browser refresh");
		driver.navigate().refresh();
	}

	/** browser close */
	public void close() {
		log.info("closing Browser");
		driver.quit();
	}

	public void checkPageIsReady(int loopCount) {
		log.info("checking webpage is ready");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}
		for (int i = 0; i < loopCount; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	// TODO: remove it later
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void validatePageTitleEquals(String text) {
		Assert.assertTrue("Text Not Found : " + text, driver.getTitle().equalsIgnoreCase(text));
	}

	public void setTimeout(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public String getText(WebElement element) {
		String textFromWebElement = element.getText();
		log.info("----Getting text from a webelement: " + textFromWebElement);
		return textFromWebElement;
	}

	public String getValue(WebElement element) {
		log.info("getting attribute value from a webelement");
		waitElementLocated(element, 60);
		return element.getAttribute("value");
	}

	public String getDropDownValue(WebElement element) {
		log.info("getting selected option from a drop down");
		waitElementLocated(element, 60);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public WebElement clear(WebElement element) {
		log.info("clearing field");
		waitElementLocated(element, 60);
		element.clear();
		return element;
	}

	public void enterText(WebElement element, String val) {
		log.info("----Clearing, then sending keys: " + val);
		// scrollToElement(element);
		element.clear();
		// waitElementLocated(element,60);
		element.sendKeys(val);
	}

	/**
	 * Workaround in case the WebElement is visible and enabled, but still not
	 * clickable due to z-index is higher of a WebElement then the layer's which
	 * contains the button.
	 *
	 * @param webElement
	 * @return
	 */
	public boolean isClickableByClicking(WebElement webElement) {
		try {
			click(webElement);
			log.info("----WebElement is clickable and clicked.");
			return true;
		} catch (Exception e) {
			log.error("----Exception after trying to click on WebElement.");
			return false;
		}
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 *
	 * @param webElement
	 * @return
	 */

	public boolean isClickableByExpectedConditions(WebElement webElement) {
		return isClickableByExpectedConditions(webElement, 60);
	}

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 *
	 * @param webElement
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean isClickableByExpectedConditions(WebElement webElement, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			log.info("----WebElement is clickable.");
			return true;
		} catch (TimeoutException e) {
			log.error("----Timeout exception after waiting for " + timeOutInSeconds + " seconds.");
			return false;
		} catch (Exception e) {
			log.error("----Exception after waiting for " + timeOutInSeconds + " seconds.");
			return false;
		}
	}

	public void sendKeyBoardKeys(WebElement element, String val) {
		log.info("----Sending keys: " + val);
		waitElementLocated(element, 60);
		element.sendKeys(val);
	}

	public void sendEnter(WebElement element) {
		log.info("----Sending ENTER key.");
		element.sendKeys(Keys.ENTER);
	}

	public void sendTab(WebElement element) {
		log.info("----Sending TAB key.");
		element.sendKeys(Keys.TAB);
	}

	public void sendKeysToInputField(WebElement element, CharSequence... keystosend) throws InterruptedException {
		waitElementLocated(element, 60);
		element.sendKeys(keystosend);
	}

	public void click(WebElement webElement) throws InterruptedException {
		log.info("----Clicking on a webElement");
		waitElementLocated(webElement, 60);
		webElement.click();
	}

	// This function can be used to highlight object..... Can be used for demo
	// purposes.
	public void highlight(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int iCnt = 0; iCnt < 3; iCnt++) {
			js.executeScript("arguments[0].style.border='4px groove green'", element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element);
		}
	}

	public void click(WebElement element, int waitseconds) {
		log.info("clicking on a element with wait");
		waitElementLocated(element, waitseconds);
		element.click();
	}

	public void selectDropdownByText(WebElement element, String val) {
		log.info("selecting drop down by text");
		Select select = new Select(element);
		select.selectByVisibleText(val);
	}

	public void selectDropdownByValue(WebElement element, String val) throws InterruptedException {
		log.info("selecting drop down by value with custom wait");
		Select select = new Select(element);
		int number_of_options = select.getOptions().size();
		int i = 1;

		while (number_of_options <= 1 && i < 60) {
			Thread.sleep(500);
			i++;
			number_of_options = select.getOptions().size();
		}
		select.selectByValue(val);
	}

	public static int getDropdownCount(WebElement element) {
		log.info("get drop down count");
		Select select = new Select(element);
		List<WebElement> l = select.getOptions();
		return l.size();
	}

	public WebElement getPageBody() {
		return driver.findElement(By.xpath("/html/body"));
	}

	public void performActionsClick(WebElement parentElement, WebElement childElement) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(parentElement).build().perform();
		setSleepTime(1000);
		click(childElement);
	}

	public void moveActionsElement(WebElement parentElement) {
		Actions action = new Actions(driver);
		action.moveToElement(parentElement).build().perform();
	}

	public WebElement getElementByXpath(String xpath, int currentSize) {
		return driver.findElement(By.xpath(xpath + "[" + (currentSize + 1) + "]"));
	}

	public void assertFail(String message) {
		Assert.fail(message);
	}

	public boolean waitElementLocated(WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean waitAllElementsLocated(List<WebElement> elements, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void waitElementLocated(By locator, int timeOutInSeconds) {
		WebElement myDynamicElement = (new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public void waitPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public Boolean waitTextPresentInElement(WebElement element, String val, int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait.until(ExpectedConditions.textToBePresentInElement(element, val));

	}

	/**
	 * Tells whether a certain element is currently visible on the page with a quick
	 * default timeout of 10 seconds.
	 *
	 * @param locator the element to look for
	 * @return true if the element is currently visible on the page
	 *
	 *         Note: this method also equals to isDisplayed by meaning
	 */

	public boolean isVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return isVisible(locator, wait);
	}

	/**
	 * Tells whether a certain element is currently visible on the page with a
	 * parameter to override the default time out of 10 seconds.
	 *
	 * @param locator       the element to look for
	 * @param timedurations the wait time for specific element
	 * @return true if the element is currently visible on the page
	 *
	 *         Note: this method also equals to isDisplayed by meaning
	 */

	public boolean isVisible(By locator, WebDriverWait wait) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * Tells whether e certain element is currently invisible on the page
	 *
	 * @param locator the element to look for
	 * @return true if the element is currently invisible on the page
	 */
	public boolean isInvisible(By locator) {
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * Looks for an element generally being present on the page, regardless of being
	 * actually visible or not.
	 *
	 * @param locator the element to look for
	 * @return true if the element is present on the output page
	 */
	public boolean isPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean waitVisibilityofElement(String Val) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(Val)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method will check for the size of the List, if size is equal to 0 then method
	 * will rechecks the size after every 1 second until size is greater than 0 or
	 * timeout is achieved
	 * 
	 * @param elements : element whose availability is checked
	 * @param timeOut  : set timeout in milliseconds
	 */
	public boolean waitAvailabilityofElement(List<WebElement> elements, int timeOut) {
		int waitTime = timeOut;
		while (elements.size() == 0 && waitTime != 0) {
			setSleepTime(1000);
			waitTime = waitTime - 1000;
		}
		if (elements.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAttributePresent(WebElement element, String attribute) {
		String value = element.getAttribute(attribute);
		if (value != null) {
			return true;
		}
		return false;
	}

	/**
	 * Test whether element is clickable
	 *
	 * @param element, UI element
	 *
	 */
	public Boolean isClickable(By element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Looks for an element being enabled or not.
	 *
	 * @param locator the element to look for
	 * @return true if the element is enabled on the output page
	 */
	public boolean isEnabled(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return element.isEnabled() ? true : false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Clicks an element with JavaScript Workaround method in case if 'Element is
	 * not currently visible' error is encountered via Selenium's WebElement#click()
	 *
	 * @param By elementToClick, element to click
	 * @return the page object of the caller
	 */

	public void clickElementWithJavaScript(By elementToClick, boolean expectVisible) {
		WebElement element = expectVisible ? wait.until(ExpectedConditions.visibilityOfElementLocated(elementToClick))
				: wait.until(ExpectedConditions.presenceOfElementLocated(elementToClick));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}

	public void clickElementWithJavaScript(WebElement element) {
		// wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", element);
	}

	/**
	 * Delete all cookies for the current session
	 */
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	/**
	 * Waits a while so slow ui elements can build up before doing the next page
	 * operation.
	 *
	 * @param millis milliseconds to wait
	 */
	public void setSleepTime(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			return;
		}
	}

	/**
	 * Click on a element with simple java script
	 *
	 * @param by selector for element to click
	 * @return same page for chaining
	 */
	public void clickWithJavaScript(By by) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickWithJavaScript(WebElement element) {
		waitElementLocated(element, 90);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public WebElement convertStringToXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> convertStringToXpathList(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	// Below are the reusable methods to perform different assertions on web
	// page that can be used while scripting

	public void validatePageTextContains(String text) {
		Assert.assertTrue("Text Not Found : " + text, getPageBody().getText().contains(text));
	}

	public void validateElementTextContains(WebElement element, String text) {
		String getText = getText(element).replaceAll("(\\r|\\n)", "");
		boolean isTextFound = getText.contains(text.replaceAll("(\\r|\\n)", ""));
		String assertMessage = "Text Not Found : " + text + ", instead " + getText + " was found.";
		Assert.assertTrue(assertMessage, isTextFound);
	}

	public void validateElementTextEquals(WebElement element, String text) {
		Assert.assertTrue("Text Not Found : " + text, getText(element).equalsIgnoreCase(text));
	}

	public void validateElementValueEquals(WebElement element, String text) {
		Assert.assertTrue("Text Not Found : " + text, getValue(element).equalsIgnoreCase(text));
	}

	public void validateDropDownTextEquals(WebElement element, String text) {
		Assert.assertTrue("Text Not Found : " + text, getDropDownValue(element).equalsIgnoreCase(text));
	}

	public void validateElementVisible(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Visible : " + Fieldname, element.isDisplayed());
	}

	public void validateElementEnabled(WebElement element, String Fieldname) {
		Assert.assertTrue("Field Not Enabled : " + Fieldname, element.isEnabled());
	}

	public void validateElementExists(List<WebElement> elements, String Fieldname) {
		Assert.assertTrue("Field Does Not Exist : " + Fieldname, elements.size() > 0);
	}

	public void validateStringsEqual(String expected, String actual, String message) {
		Assert.assertEquals(message, expected, actual);
	}

	public void validateElementDoesNotExist(List<WebElement> elements, String Fieldname) {
		Assert.assertFalse("Field Exist : " + Fieldname, elements.size() > 0);
	}

	public void validateUrlContains(String text) {
		Assert.assertTrue("Url Not contains : " + text, getCurrentUrl().contains(text));
	}

	public void validateElementValueNotNull(WebElement element, String text) {
		Assert.assertNotNull("Value is Null : " + text, getText(element));
	}

	// ----------//

	/**
	 * Retrieve all error codes/messages from the error box
	 * 
	 * @param errorMessagesElement , error messages element
	 * 
	 * @return map of errors
	 */
	public Map<String, String> getErrorMessages(List<WebElement> errorMessagesElement) {
		Map<String, String> errors = new HashMap<String, String>();
		if (!errorMessagesElement.isEmpty()) {
			List<WebElement> messages = wait.until(ExpectedConditions.visibilityOfAllElements(errorMessagesElement));
			for (WebElement message : messages) {
				errors.put(message.getAttribute("data-qa"), message.getText());
			}
		}
		return errors;
	}

	public void scrollToWebElement(WebElement webElement) {
		log.info("----Scrolling to element " + webElement);
		scrollToWebElement(webElement, -150);
	}

	public void scrollToWebElement(WebElement webElement, int scrollPx) {
		log.info("----Scrolling to webElement " + webElement);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
		jse.executeScript("window.scrollBy(0," + scrollPx + ")", "");
	}

	public String getTextOfWebElement(WebElement webElement) {
		String webElementsText = webElement.getText();
		log.info("Getting text from a webElement, text is: " + webElementsText);
		return webElementsText;
	}

	public String getValueOfWebElement(WebElement webElement) {
		waitForVisibilityOfElement(webElement);
		String webElementsAttributeValue = webElement.getAttribute("value");
		log.info("Getting value attribute's content from webElement, value is: " + webElementsAttributeValue);
		return webElementsAttributeValue;
	}

	public boolean clickOnWebElement(WebElement webElement) {
		try {
			log.info("----Trying to click on webElement.");
			webElement.click();
			log.info("----Clicking on webElement was successful.");
			return true;
		} catch (ElementNotVisibleException ex) {
			log.info("----Couldn't click on webElement " + webElement);
			return false;
		}
	}

	public void clickWithJavaScriptOnWebElement(WebElement element) {
		log.info("----Clicking element with JavaScript.");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public boolean hoverOnAndClickOnWebElement(WebElement parentElement, WebElement childElement) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(parentElement).build().perform();
			setSleepTimeInSeconds(1);
			return clickOnWebElement(childElement);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			log.error("Error in...");
			return false;
		}
	}

	public boolean waitForVisibilityOfElement(WebElement element) {
		return waitForVisibilityOfElement(element, 60);
	}

	// visibilityOf - An expectation for checking that an element, known to be
	// present on the DOM of a page, is visible. Visibility means that the element
	// is not only displayed but also has a height and width that is greater than 0.
	public boolean waitForVisibilityOfElement(WebElement webElement, int timeOutInSeconds) {
		log.info("----Waiting for visible webElement for " + timeOutInSeconds + " seconds.");
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (NoSuchElementException ex) {
			log.error("----Error while waiting for visible webElement in " + this.getClass()
					+ ".waitForVisibilityOfElement, NoSuchElementException.");
			ex.printStackTrace();
			return false;
		} catch (TimeoutException e) {
			log.error("----Error while waiting for visible webElement in " + this.getClass()
					+ ".waitForVisibilityOfElement, TimeoutException.");
			return false;
		}
	}

	public boolean waitForInvisibilityOfElement(WebElement webElement) {
		return waitForInvisibilityOfElement(webElement, 0);
	}

	public boolean waitForInvisibilityOfElement(WebElement webElement, int timeOutInSeconds) {
		log.info("----Waiting for invisibility of a webElement.");
		if (timeOutInSeconds > 0) {
			setSleepTimeInSeconds(timeOutInSeconds);
		}
		boolean isInvisible = false;
		try {
			isInvisible = !webElement.isDisplayed();
			log.info("----WebElement is invisible, but present in the html DOM.");
		} catch (NoSuchElementException e) {
			isInvisible = true;
			log.info(
					"----Error while waiting for invisibility of a webElement, NoSuchElementException is caught. WebElement is not present in the html DOM.");
		} catch (StaleElementReferenceException e) {
			isInvisible = true;
			log.info(
					"----Error while waiting for invisibility of a webElement, StaleElementReferenceException is caught.");
		} catch (TimeoutException e) {
			isInvisible = true;
			log.info("----Error while waiting for invisibility of a webElement, TimeoutException is caught.");
		} catch (Exception e) {
			isInvisible = false;
			log.error("----Error while waiting for invisibility of a webElement, " + e.getCause() + " is caught.");
		} finally {
			return isInvisible;
		}
	}

	public static void setSleepTimeInSeconds(int seconds) {
		try {
			log.info("----Waiting for " + seconds + " seconds.");
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			log.error("----Error while waiting for " + seconds + " seconds.");
		}
	}

	public static void getRowCount() {

		try {

			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number Of Rows is :" + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static String getCellDataString(int rowNum, int colNum, String path) {
		try {
			//projectPath = System.getProperty("user.dir");
			// String filePath = projectPath + "/excel/"+path;
			workBook = new XSSFWorkbook(projectPath + "/excel/" + path);
			// System.out.println("workbook path" + filePath);
			sheet = workBook.getSheet("signUp");
			String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			return celldata;

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			String message = "error";
			return message;
		}
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			//projectPath = System.getProperty("user.dir");
			workBook = new XSSFWorkbook(projectPath + "/excel/canadaRoots_data.xlsx");
			sheet = workBook.getSheet("signUp");
			double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);

		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}
	
//	public void checkApiStatus(String url) throws Throwable {
//        System.out.println("Add URL :"+url);
//		given().
//		when().
//			get(url).
//		then().
//			assertThat().
//			statusCode(200);
//	}

}
