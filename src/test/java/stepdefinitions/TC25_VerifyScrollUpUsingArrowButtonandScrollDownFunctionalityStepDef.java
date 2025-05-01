package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC25_VerifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage;
import utilities.BrowserUtils;

public class TC25_VerifyScrollUpUsingArrowButtonandScrollDownFunctionalityStepDef {
    TC25_VerifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage tc25_verifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage=new TC25_VerifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage();

    @When("I scroll down page to bottom")
    public void ıScrollDownPageToBottom() {
        BrowserUtils.slowScrollToBottom();
    }
    @When("I click on arrow at bottom right side to move upward")
    public void ıClickOnArrowAtBottomRightSideToMoveUpward() {
            tc25_verifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage.pageUpButton.click();
    }

    @Then("I verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void ıVerifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() {
        Assert.assertEquals(tc25_verifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage.verfiySliderText.getText(),"Full-Fledged practice website for Automation Engineers");
    }


}
