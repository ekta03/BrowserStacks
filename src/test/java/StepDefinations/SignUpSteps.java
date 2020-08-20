package StepDefinations;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class SignUpSteps extends BasePage {

	public List<HashMap<String, String>> datamap;
	// WebDriver driver = Hooks.driver;

	@Then("^user scrolls to \"([^\"]*)\" button$")
	public void scrollToButton(String button) {
		signUpPage.scrollToSelectedButton(button);
	}

	@Then("^user enters valid details \"([^\"]*)\" and \"([^\"]*)\" dataset from datasheet \"([^\"]*)\"$")
	public void enterDetailsToSignUp(int arg1, int arg2, String path) {
		signUpPage.enterDetailsToSignUp(arg1, arg2, path);
	}

	@Then("^user clicks on \"([^\"]*)\" button on signUp page$")
	public void selectButton(String button) {
		signUpPage.selectButton(button);
	}

	@Given("^Connected to the mysql server and sys database$")
	public void establicConnection() throws SQLException, Throwable {
		signUpPage.establihConnection();
	}
	
	@Then("^user sign up with userID \"([^\"]*)\"$")
	public void signUpWithDeatils(int id) throws ClassNotFoundException, SQLException {
		signUpPage.signUpWithDetails(id);
	}
	
	@Then("^user selects province for \"([^\"]*)\" from list$")
	public void selectProvinceFromList(int id) throws ClassNotFoundException, SQLException {
		signUpPage.selectProvinceFromList(id);
	}

}
