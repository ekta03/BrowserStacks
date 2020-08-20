package Pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.commons.io.FileUtils;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;

public class Hook extends BasePage{

	@Before
	public void initTest() {
		System.out.println("OPENING THE BROWSER : MOCK");
	}

	@After
	public void tearDownTest(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			grabScreenshotForReport(driver, scenario);
			driver.quit();
		}
		System.out.println("CLOSING THE BROWSER : MOCK");
	}
}
