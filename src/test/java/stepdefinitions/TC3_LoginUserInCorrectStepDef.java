package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC2_LoginUserCorrectPage;
import pages.TC3_LoginUserInCorrectPage;

public class TC3_LoginUserInCorrectStepDef {
    TC2_LoginUserCorrectPage tc2_loginUserCorrectPage =new TC2_LoginUserCorrectPage();
    TC3_LoginUserInCorrectPage tc3_loginUserInCorrectPage =new TC3_LoginUserInCorrectPage();

    @When("I enter incorrect email address and password")
    public void ıEnterIncorrectEmailAddressAndPassword() {
        tc2_loginUserCorrectPage.emailText.sendKeys("incorrect@mail.com");
        tc2_loginUserCorrectPage.passwordText.sendKeys("incorrect1234");
    }

    @Then("I verify error Your email or password is incorrect! is visible")
    public void ıVerifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(tc3_loginUserInCorrectPage.incorrectLoginText.isDisplayed());
    }
}
