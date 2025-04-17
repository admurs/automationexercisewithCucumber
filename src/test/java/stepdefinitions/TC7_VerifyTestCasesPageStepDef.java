package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC7_VerifyTestCasesPage;

public class TC7_VerifyTestCasesPageStepDef {
    TC7_VerifyTestCasesPage tc7_verifyTestCasesPage=new TC7_VerifyTestCasesPage();
    @When("I click on Test Cases button")
    public void ıClickOnTestCasesButton() {
        tc7_verifyTestCasesPage.testCasesPage.click();
    }

    @Then("I verify user is navigated to test cases page successfully")
    public void ıVerifyUserIsNavigatedToTestCasesPageSuccessfully() {
        int total=0;
        for (int i = 0; i < tc7_verifyTestCasesPage.testCasesValidation.size(); i++) {
            total=total+1;
        }
        Assert.assertEquals(total,26);

    }
}
