package Pages;

import static io.restassured.RestAssured.given;

import java.util.List;
import static io.restassured.RestAssured.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;

//import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiAutomationPage extends BasePage {

	// ################################ PAGE OBJECTS #####################################


	// ################################ METHODS ##########################################

	public void checkApiStatus(String url) throws Throwable {
        System.out.println("Add URL :"+url);
		given().
		when().
			get(url).
		then().
			assertThat().
			statusCode(200);
	}
}