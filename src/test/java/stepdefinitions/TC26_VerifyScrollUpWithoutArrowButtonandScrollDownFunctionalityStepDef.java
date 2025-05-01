package stepdefinitions;

import io.cucumber.java.en.When;
import utilities.BrowserUtils;

public class TC26_VerifyScrollUpWithoutArrowButtonandScrollDownFunctionalityStepDef {
    @When("I scroll up page to top")
    public void ıScrollUpPageToTop() {
       BrowserUtils.slowScrollToTop();
    }
}
