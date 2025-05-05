package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
             tags = "@All or @RegisterUser",
        //    tags="@Test",
        dryRun = false
)
public class CukesRunner extends AbstractTestNGCucumberTests {

}