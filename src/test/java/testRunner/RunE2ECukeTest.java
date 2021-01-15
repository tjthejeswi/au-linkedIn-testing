package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/fetaures"
        , glue = {"stepDefinitions"}
        , plugin = {"pretty", "html:target/Reports/cucumberReports.html"}
        , tags = "@sampleTest"
        , monochrome = true
        )
public class RunE2ECukeTest {

}
