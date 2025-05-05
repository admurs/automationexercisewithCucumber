package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/failed-html-report.html",
                "rerun:target/rerun.txt"
        },
        features = "@target/rerun.txt",
        glue = "stepdefinitions"
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {

}