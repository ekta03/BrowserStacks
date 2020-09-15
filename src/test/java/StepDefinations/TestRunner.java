package StepDefinations;

import org.apache.log4j.BasicConfigurator;
import org.junit.runner.JUnitCore;
//import org.apache.log4j.BasicConfigurator;
//import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/Features",glue= {"StepDefinations", "Pages"},
monochrome=true,
plugin={"pretty","html:target/htmlReports/reports.html",
		"json:target/JSONReports/reports.json",
		"junit:target/JUnitReports/reports.xml"},
tags="@landingPage")
public class TestRunner {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		JUnitCore.main("StepDefinations.TestRunner");
	}
}


