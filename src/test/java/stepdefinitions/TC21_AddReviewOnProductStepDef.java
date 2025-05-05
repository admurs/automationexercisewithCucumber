package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import pages.TC13_VerifyProductQuantityinCartPage;
import pages.TC21_AddReviewOnProductPage;
import utilities.BrowserUtils;

import static utilities.BrowserUtils.getFaker;

public class TC21_AddReviewOnProductStepDef {
    TC13_VerifyProductQuantityinCartPage tc13_verifyProductQuantityinCartPage=new TC13_VerifyProductQuantityinCartPage();
    TC21_AddReviewOnProductPage tc21_addReviewOnProductPage=new TC21_AddReviewOnProductPage();
    @When("I click on View Product button")
    public void ıClickOnViewProductButton() {
        WebElement element= BrowserUtils.randomSelected(tc13_verifyProductQuantityinCartPage.viewAnyProducts);
        BrowserUtils.clickWithJS(element);
        element.click();
    }

    @Then("I verify Write Your Review is visible")
    public void ıVerifyWriteYourReviewIsVisible() {
        Assert.assertTrue(tc21_addReviewOnProductPage.viewProductVerify.isDisplayed());
    }

    @When("I enter name, email and review")
    public void ıEnterNameEmailAndReview() {
        String email = getFaker().internet().emailAddress();
        String name = getFaker().name().name();
        String review=getFaker().lorem().paragraph(3);
        tc21_addReviewOnProductPage.nameTextBox.sendKeys(name);
        tc21_addReviewOnProductPage.emailTextBox.sendKeys(email);
        tc21_addReviewOnProductPage.reviewTextBox.sendKeys(review);
    }

    @Then("I verify success message Thank you for your review.")
    public void ıVerifySuccessMessageThankYouForYourReview() {
        Assert.assertTrue(tc21_addReviewOnProductPage.verifyReviewMessage.isDisplayed());
    }
}
