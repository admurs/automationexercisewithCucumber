package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TC1_RegisterUserPage;
import pages.TC2_LoginUserCorrectPage;
import pages.TC5_RegisterUserExistingEmailPage;

public class TC5_RegisterUserExistingEmailStepDef {
    TC2_LoginUserCorrectPage tc2_loginUserCorrectPage =new TC2_LoginUserCorrectPage();
    TC1_RegisterUserPage tc1_registerUserPage=new TC1_RegisterUserPage();
    TC5_RegisterUserExistingEmailPage tc5_registerUserExistingEmailPage=new TC5_RegisterUserExistingEmailPage();
    @When("I enter name and already registered email address")
    public void ıEnterNameAndAlreadyRegisteredEmailAddress() {
        tc1_registerUserPage.nameText.sendKeys(Hooks.name);
        tc1_registerUserPage.emailText.sendKeys(Hooks.email);

    }

    @Then("I verify error Email Address already exist! is visible")
    public void ıVerifyErrorEmailAddressAlreadyExistIsVisible() {
        Assert.assertEquals(tc5_registerUserExistingEmailPage.alreadyExistText.getText(),"Email Address already exist!");
    }
}
