package pro.edusoft.cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "pro.edusoft.cucumber.steps" }, features = "src/test/resources", plugin = { "pretty",
		"html:target/site/cucumber-pretty.html", "json:target/cucumber.json" })
public class RunCucumberTests {
}