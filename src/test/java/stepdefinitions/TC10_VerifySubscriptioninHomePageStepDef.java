package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TC10_VerifySubscriptioninHomePage;
import utilities.BrowserUtils;

import static utilities.BrowserUtils.getFaker;

public class TC10_VerifySubscriptioninHomePageStepDef {
    TC10_VerifySubscriptioninHomePage tc10_verifySubscriptioninHomePage=new TC10_VerifySubscriptioninHomePage();
    @When("I scroll down to footer")
    public void ıScrollDownToFooter() {
        BrowserUtils.clickWithJS(tc10_verifySubscriptioninHomePage.subscriptionText);
    }

    @Then("I verify text SUBSCRIPTION")
    public void ıVerifyTextSUBSCRIPTION() {
        Assert.assertTrue(tc10_verifySubscriptioninHomePage.subscriptionText.isDisplayed());
    }

    @When("I enter email address in input and click arrow button")
    public void ıEnterEmailAddressInInputAndClickArrowButton() {
        String mail=getFaker().internet().emailAddress();
        tc10_verifySubscriptioninHomePage.susbscribeMailTextBox.sendKeys(mail);
        tc10_verifySubscriptioninHomePage.susbscribeButton.click();

    }

    @Then("I verify success message You have been successfully subscribed! is visible")
    public void ıVerifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() {

        Assert.assertTrue(tc10_verifySubscriptioninHomePage.subscriptionSuccess.isDisplayed());
    }
}
