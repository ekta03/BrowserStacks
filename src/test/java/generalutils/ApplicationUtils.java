package generalutils;

//import com.eon.sales.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ApplicationUtils {

    public static final String SIMPLE_DATE_FORMAT_GERMAN = "dd.MM.yyyy";
    /**
     * Using this with scrollToWebElement will scroll to the top of the page
     * Actually this is the header menu size for large viewport
     */
    public static final int TOP_OF_SCREEN_LG = -120;
    /**
     * Using this with scrollToWebElement will scroll to the middle of the page
     */
	//public static final int MIDDLE_OF_SCREEN_LG = (Hooks.height / -2) - TOP_OF_SCREEN_LG;
	public static final String WAS_NOT_VISIBLE = " was not visible.";
	public static final String THE_EXPECTED_WAS = ", the expected was: ";
	public static final String THE_ACTUAL_WAS = ", the actual was: ";

    // TODO: only one customer - user type should be used, since private (customer) or business (customer) is assiged to both in most cases
    public static String customerType;
    public static String userTypeforOVA;
    public static String energyType;
    public static String productName;
    public static String subProductName;
	public static String couponCode;

    protected WebDriver driver;
    protected WebDriverWait wait;

	/**
	 * Waits for the loading indicator (spinning wheel) to stop showing.
	 * 
	 * @return true if loading indicator disappeared before timeout
	 */
	public boolean waitForLoading() {
		try {
			Boolean loadingIndicatorGone = wait
					.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".icon-loading")));
			return loadingIndicatorGone;
		} catch (TimeoutException e) {
			log.info("Timeout when waiting for page content to load.");
			return false;
		}
	}

	/**
	 * Waits max 5 secs for the loading indicator to appear and tells if it
	 * does.
	 * 
	 * In order to wait for loading indicator to gone we should first wait for
	 * it to be present.
	 * 
	 * Note: not advised in case if you have output: loading indicator has not
	 * appeared.
	 * 
	 * @return true if loading indicator has appeared before timeout
	 */
	public boolean loadingIndicatorAppears() {
		Long waitSeconds = 5l;
		WebDriverWait shortWait = new WebDriverWait(driver, waitSeconds);
		try {
			WebElement loadingIndicatorPresent = shortWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-loading")));
			return loadingIndicatorPresent.isDisplayed();
		} catch (TimeoutException e) {
			log.info("Loading indicator has not appear.");
			return false;
		}
	}

	/**
	 * 
	 * Wait for animation is finished. Example: when you click cancel in edit
	 * mode for password change in Meine-Daten->Login-Daten then edit component
	 * is slowly being collapsed and disappears.
	 * 
	 * Method is waiting until element of un-collapsed/expanded item will no
	 * longer be visible on the page.
	 * 
	 * @param elementToWaitForToBeDissappeared
	 *  
	 */
	public void waitForAnimationIsFinished(By elementToWaitForToBeDissappeared) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementToWaitForToBeDissappeared));
	}
	
	/**
	 * Looks for a certain element after waiting for the loading indicator to
	 * stop showing.
	 * 
	 * @param selector
	 *            selector for finding the element
	 * @return true if element is found
	 */
	public boolean elementGetsLoaded(By selector) {
		if (waitForLoading()) {
			List<WebElement> elements = driver.findElements(selector);
			return !elements.isEmpty();
		} else {
			log.error("Page loading didn't finish before timeout.");
			return false;
		}
	}
	
	

}
