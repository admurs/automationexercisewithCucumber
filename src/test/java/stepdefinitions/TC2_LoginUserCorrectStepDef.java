package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TC2_LoginUserCorrectPage;

public class TC2_LoginUserCorrectStepDef  {

    TC2_LoginUserCorrectPage tc2_loginUserCorrectPage =new TC2_LoginUserCorrectPage();


    @Then("I verify that Login to your account is visible")
    public void ıVerifyThatLoginToYourAccountIsVisible() {
        Assert.assertTrue(tc2_loginUserCorrectPage.loginText.isDisplayed());
    }

    @When("I enter correct email address and password")
    public void ıEnterCorrectEmailAddressAndPassword() {
        tc2_loginUserCorrectPage.emailText.sendKeys(Hooks.email);
        tc2_loginUserCorrectPage.passwordText.sendKeys(Hooks.password);
    }

    @And("I click login button")
    public void ıClickLoginButton() {
        tc2_loginUserCorrectPage.loginButton.click();
    }



}
