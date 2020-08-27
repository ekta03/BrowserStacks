package Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import static generalutils.ApplicationUtils.WAS_NOT_VISIBLE;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.interactions.Actions;
import java.lang.ClassNotFoundException;

public class SignUpPage extends BasePage {

	Connection con;
	Statement stmt;
	ResultSet rs;

	// ################################ PAGE OBJECTS
	// #####################################

	@FindBy(xpath = "//button[@class='btn-submit btn' and @type='submit']")
	public static WebElement btn_signUpNow;

	@FindBy(xpath = "//input[@type='text' and @id='inputfieldID']")
	public static WebElement input_enterEmail;

	@FindBy(xpath = "//div/h2[contains(text(),'Newsletter Signup')]")
	public static WebElement txt_newsLetterSignUp;

	@FindBy(xpath = "//input[@id='dwfrm_emailsignup_firstname']")
	public static WebElement input_firstName;

	@FindBy(xpath = "//input[@id='dwfrm_emailsignup_email']")
	public static WebElement input_email;

	@FindBy(xpath = "//input[@id='dwfrm_emailsignup_location_city']")
	public static WebElement input_city;

	@FindBy(xpath = "//div/span[contains(text(),'Select Province')]")
	public static WebElement btn_provience;
	
	@FindAll(@FindBy(xpath = "(//div[@class='selectric-items']/div/ul)[3]/li"))
	public static List<WebElement> dropDown_provience;

	// input[@id='dwfrm_emailsignup_email']

	// ################################ METHODS
	// ##########################################

	public void scrollToSelectedButton(String button) {
		scrollToElement(btn_signUpNow);
		assertTrue(btn_signUpNow.getText().equals(button));
	}

	public void enterDetailsToSignUp(int row, int col, String path) {
		String cellData = signUpPage.getCellDataString(row, col, path);
		System.out.println(cellData);
		if (cellData != "error") {
			signUpPage.input_enterEmail.sendKeys(cellData);
			setSleepTime(1000);
		} else
			assertTrue("can't open the specified file input stream from file", cellData != "error");
	}

	public void selectButton(String button) {
		clickWithJavaScriptOnWebElement(btn_signUpNow);
		assertTrue(txt_newsLetterSignUp.isDisplayed());
	}

	public void establihConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("DRIVER LOADED");
		String username1 = "root";
		String password1 = "WakeUpSid@1994";
		String dbURL = "jdbc:mysql://localhost:3306/sys";
		Connection con = DriverManager.getConnection(dbURL, username1, password1);
		System.out.println("Connection successful...");
//		 Creating statement object
//		Statement stmt = con.createStatement();
//		String selectquery = "Select * from User";
//		ResultSet rs = stmt.executeQuery(selectquery);
//		System.out.println(rs);
//		while (rs.next()) {
//			String name = rs.getString(2);
//			System.out.println(name);
//			//break;
//		 }
//		 Closing DB Connection
//		 con.close();
	}


	public void signUpWithDetails(int Id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("DRIVER LOADED");
		String username1 = "root";
		String password1 = "WakeUpSid@1994";
		String dbURL = "jdbc:mysql://localhost:3306/sys";
		Connection con = DriverManager.getConnection(dbURL, username1, password1);
		System.out.println("Connection successful...");
		System.out.println("PASSED ID FROM FEATURE" + Id);
		Statement stmt = con.createStatement();
		String selectquery = "Select * from User where UserId =" + Id;
		ResultSet rs = stmt.executeQuery(selectquery);
		System.out.println(rs);
		while (rs.next()) {
			String fname = rs.getString(1);
			String email = rs.getString(4);
			String city = rs.getString(2);
			input_firstName.sendKeys(fname);
			input_email.sendKeys(email);
			input_city.sendKeys(city);
			setSleepTime(1000);
			System.out.println("User has entered Firstname:" + fname + " , email: " + email + " , city: " + city);
			// setSleepTime(1000);
			// break;
		}
		// Closing DB Connection
		con.close();
	}
	
	public void selectProvinceFromList(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("DRIVER LOADED");
		String username1 = "root";
		String password1 = "WakeUpSid@1994";
		String dbURL = "jdbc:mysql://localhost:3306/sys";
		Connection con = DriverManager.getConnection(dbURL, username1, password1);
		System.out.println("Connection successful...");
		System.out.println("PASSED ID FROM FEATURE" + id);
		Statement stmt = con.createStatement();
		String selectquery = "Select * from User where UserId =" + id;
		ResultSet rs = stmt.executeQuery(selectquery);
		System.out.println(rs);
		while (rs.next()) {
			clickWithJavaScript(btn_provience);
			String province = rs.getString(3);
			for (int i = 0; i < dropDown_provience.size(); i++) { 
				if(dropDown_provience.get(i).getText().equalsIgnoreCase(province)) {
				clickElementWithJavaScript(dropDown_provience.get(i));
				}
			}
			setSleepTime(10000);
			System.out.println("User has entered Province:" + province);
			// setSleepTime(1000);
			// break;
		}
		// Closing DB Connection
		con.close();
		
	}

}
