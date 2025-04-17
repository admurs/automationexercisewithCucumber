package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC4_LogoutUserPage;
import utilities.Driver;

public class TC4_LogoutUserStepDef {
    TC4_LogoutUserPage tc4_logoutUserPage=new TC4_LogoutUserPage();
    @When("I click Logout button")
    public void ıClickLogoutButton() {
        tc4_logoutUserPage.logoutButton.click();
    }

    @Then("I verify that user is navigated to login page")
    public void ıVerifyThatUserIsNavigatedToLoginPage() {

        String actualTitle="Automation Exercise - Signup / Login";
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
