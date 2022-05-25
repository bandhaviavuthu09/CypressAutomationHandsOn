package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(	 
features="src/test/java/Features/Assignment2.feature",
glue={"StepDefinition"}
)
public class TestRunner {
	
		
}