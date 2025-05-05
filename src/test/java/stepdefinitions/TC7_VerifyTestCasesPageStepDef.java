package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TC7_VerifyTestCasesPage;

public class TC7_VerifyTestCasesPageStepDef {
    TC7_VerifyTestCasesPage tc7_verifyTestCasesPage=new TC7_VerifyTestCasesPage();
    @When("I click on Test Cases button")
    public void ıClickOnTestCasesButton() {
        tc7_verifyTestCasesPage.testCasesPage.click();
    }

    @Then("I verify user is navigated to test cases page successfully")
    public void ıVerifyUserIsNavigatedToTestCasesPageSuccessfully() {

        int caseCount= tc7_verifyTestCasesPage.testCasesValidation.size();

        Assert.assertTrue(caseCount > 0);
    }
}
