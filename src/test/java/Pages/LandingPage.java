package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.steadystate.css.parser.ParseException;

//import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException;

//import bsh.ParseException;

import static generalutils.ApplicationUtils.WAS_NOT_VISIBLE;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.interactions.Actions;

public class LandingPage extends BasePage {

	// ################################ PAGE OBJECTS #####################################
	
	//1st way to use it
	@FindBy(className = "main-logo")
	public static WebElement logo_roots;

	//2nd way to use it
	public static @FindBy(className = "main-message") 
	WebElement txt_welcome;

	@FindAll(@FindBy(xpath = "//span[@class='country-name']"))
	public static List<WebElement> list_countryList;

	@FindAll(@FindBy(className = "menuItem"))
	public static List<WebElement> lst_menuItems;
	
	@FindBy(xpath = "//a[@class='subitem parent' and contains(text(),'Baby')]")
	public static WebElement list_babyMenu;
	
	@FindBy(xpath = "//div[@class='su-modal email-hopup-container open']")
	public static WebElement alert_offerPopoup;
	
	@FindBy(xpath = "//div[@class='x-close su-modal-close']")
	public static WebElement btn_cancel;

	// ################################ METHODS ##########################################

	public void verifyLogo() {
		//setSleepTime(5000);	
		logo_roots.isDisplayed();
		//waitForVisibilityOfElement(logo_roots, 20);
	}

	public void validateMessage() {
		validateElementTextContains(txt_welcome, "Welcome to Roots Canada");
	}

	public void selectCountry(String country) {
		waitAvailabilityofElement(list_countryList, 10);
		System.out.println("country to be clicked:" + country);
		boolean flag = true;
		ArrayList arrlist = new ArrayList();
		for (int i = 0; i < list_countryList.size(); i++) {
			String countryToSelect = list_countryList.get(i).getText();
			arrlist.add(countryToSelect);
			if (countryToSelect.equalsIgnoreCase(country)) {
				System.out.println("country selected" + countryToSelect);
				list_countryList.get(i).click();
				flag = false;
			}
		}
		if (flag) {
			list_countryList.get(1).getText();
			Assert.assertEquals("no such country present", country, arrlist);
		}
	}

	public void validateSizeOfMenuList(List<String> menuItem) throws InterruptedException, ParseException {
		int sizeOfMenuExpected = menuItem.size();
		int sizeOfMenuActual = lst_menuItems.size();
		Assert.assertEquals("size does not match", sizeOfMenuExpected, sizeOfMenuActual);
	}

	public void validateMenuItemsPresent(List<String> menuItem) throws InterruptedException, ParseException {
		System.out.println("menu Items to verify " + " " + menuItem);
		ArrayList arrlist = new ArrayList();
		for (int i = 0; i < lst_menuItems.size(); i++) {
			String menuItemsfromUI = lst_menuItems.get(i).getText();
			arrlist.add(menuItemsfromUI);
		}
		assertTrue("Menu Items are not present", menuItem.equals(arrlist));
	}

	public void hoversOnMenuItem(String menuItem) {
		Actions actions = new Actions(driver);
		boolean flag = true;
		for (int i = 0; i < lst_menuItems.size(); i++) {
			String menuItemsfromUI = lst_menuItems.get(i).getText();
			if (menuItemsfromUI.equalsIgnoreCase(menuItem)) {
				actions.moveToElement(lst_menuItems.get(i)).perform();
				flag = false;
			}
		}
		assertTrue("menu item not present", flag=true );
	}
	
	public void hoversandClilckItem(String menuItem) {
		boolean flag = true;
		for (int i = 0; i < lst_menuItems.size(); i++) {
			String menuItemsfromUI = lst_menuItems.get(i).getText();
			if (menuItemsfromUI.equalsIgnoreCase(menuItem)) {
				hoverOnAndClickOnWebElement(lst_menuItems.get(i), list_babyMenu);
				flag = false;
			}
		}
		assertTrue("menu item not present", flag=true );
	}
	
	public void cancelPopup() {
		validateElementVisible(alert_offerPopoup, "offerPopup");
		clickWithJavaScriptOnWebElement(btn_cancel);
	}
}
