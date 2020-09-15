package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import Pages.BasePage;
import Pages.Hooks;
import cucumber.api.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LandingSteps extends BasePage{

	WebDriver driver = Hooks.driver;
	
	@Given("launches the application in \"([^\"]*)\"$")
	public void launch_browser(String browser) throws Exception {
		System.out.println("Step to launch the Application in browser");
		getDriver(browser);
		//openSTMwithBowser(browser);
	}
	
	@Given("launches the application$")
	public void launch_browser() throws Exception {
		System.out.println("Step to launch the Application in browser");
		openSTM();
	}
	
	@Then("^user verifies visiblitity of logo$")
	public void visiblitity_of_logo(){
		landingPage.verifyLogo();
	} 
	
	@Then("^user verifies welcome message present on landing page$")
	public void validate_welcomeMessage() {
		landingPage.validateMessage();
	}
	
	@And("^user clicks on \"([^\"]*)\" button$")
	public void selectCountry(String button) {
		landingPage.selectCountry(button);
	}
	
	@Then("^user verifies if all menuItems are present$")
	public void selectMenuItem(List<List<String>> answersList) throws Throwable { 
		landingPage.validateSizeOfMenuList(answersList.get(0));
		landingPage.validateMenuItemsPresent(answersList.get(0));
	}
		
	@Then("^user hovers on \"([^\"]*)\" menuItem$")
	public void hoversOnMenuItem(String menuItem) {
		landingPage.hoversOnMenuItem(menuItem);
	}
	
	@Then("^user hovers and click on \"([^\"]*)\" menuItem$")
	public void hoversandClilckItem(String menuItem) {
		landingPage.hoversandClilckItem(menuItem);
	}
	
	@And("^user close alert popup$")
	public void cancelPopup() {
		landingPage.cancelPopup();
	}
	
	@Then("^user closes the browser$")
	public void closeBrowser() {
		landingPage.close();
	}
}
