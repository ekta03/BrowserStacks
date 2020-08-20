package StepDefinations;

//import com.jayway.restassured.http.ContentType;

import Pages.BasePage;
import Pages.Hook;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
import cucumber.api.java.en.Given;

//import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;

public class apiAutomationSteps extends BasePage{
//	WebDriver driver = Hook.driver;
	
	@Given("^I check status for api endpoint \"([^\"]*)\"$")
	public void checkApiStatus(String url) throws Throwable {
		System.out.println("URL TO CHECK : "+url);
		System.out.println("Add URL :"+url);
		given().
		when().
			get(url).
		then().
			assertThat().
			statusCode(200);
	}
}
