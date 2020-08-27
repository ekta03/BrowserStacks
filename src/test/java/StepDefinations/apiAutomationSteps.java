package StepDefinations;

import Pages.BasePage;
import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.*;

public class apiAutomationSteps extends BasePage {

	@Given("^I check status for api endpoint \"([^\"]*)\"$")
	public void checkApiStatus(String url) throws Throwable {
		System.out.println("URL TO CHECK : " + url);
		System.out.println("Add URL :" + url);
		given().when().get(url).then().assertThat().statusCode(200);
	}
}
