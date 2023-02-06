package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue=("stepDefinition"),
		plugin = { "pretty", "html:target/cucumber-reports.html" })
public class Runner extends AbstractTestNGCucumberTests {
	

}