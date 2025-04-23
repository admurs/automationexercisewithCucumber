package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TC14_15_PlaceOrderRegisterWhileBeforeCheckoutPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Year;

import static utilities.BrowserUtils.getFaker;

public class TC14_15_PlaceOrderRegisterWhileBeforeCheckoutStepDef {
    TC14_15_PlaceOrderRegisterWhileBeforeCheckoutPage tc14_15_placeOrderRegisterWhileBeforeCheckoutPage =new TC14_15_PlaceOrderRegisterWhileBeforeCheckoutPage();
    Hooks hooks=new Hooks();
    String product;

    @When("I add products to cart")
    public void AddProductsToCart() {
       WebElement elementProduct= BrowserUtils.randomSelected(tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.anyProducts);
       BrowserUtils.clickWithJS(elementProduct);
       BrowserUtils.hover(elementProduct);
       elementProduct.click();
       product=elementProduct.getText();
    }

    @Then("I verify that cart page is displayed")
    public void ıVerifyThatCartPageIsDisplayed() {
        String actualPage="https://www.automationexercise.com/view_cart";
        String expectedPage= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualPage,expectedPage);
    }

    @When("I click Proceed To Checkout")
    public void ıClickProceedToCheckout() {
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.checkOutButton.click();
    }

    @And("I click Register-Login button")
    public void ıClickRegisterLoginButton() {
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.registerLoginButton.click();
    }

    @And("I fill all details in Signup and create account")
    public void ıFillAllDetailsInSignupAndCreateAccount() {

        hooks.fillAndCreateAccount();
    }

    @Then("I verify ACCOUNT CREATED! and click Continue button")
    public void ıVerifyACCOUNTCREATEDAndClickContinueButton() {
        Assert.assertEquals(tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.createAccoutVerifyText.getText(),"ACCOUNT CREATED!");
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.continueButton.click();

    }

    @And("I verify Logged in as username at top")
    public void ıVerifyLoggedInAsUsernameAtTop() {
        Assert.assertEquals(tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.userNameVerifyText.getText(),"Logged in as "+Hooks.name);

    }

    @And("I click Proceed To Checkout button")
    public void ıClickProceedToCheckoutButton() {
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.checkOutButton.click();
    }

    @Then("I verify Address Details and Review Your Order")
    public void ıVerifyAddressDetailsAndReviewYourOrder() {
        Assert.assertEquals(2, tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.checkoutVerifyAddress.size());

        Assert.assertEquals(1, tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.checkoutVerifyOrder.size());
    }

    @When("I enter description in comment text area and click Place Order")
    public void ıEnterDescriptionInCommentTextAreaAndClickPlaceOrder() {
        String message= getFaker().lorem().fixedString(100);
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.descriptionTextBox.sendKeys(message);
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.placeOrderButton.click();
    }

    @And("I enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void ıEnterPaymentDetailsNameOnCardCardNumberCVCExpirationDate() {
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.nameOnCardTextBox.sendKeys(Hooks.name);
        String cardNumber=getFaker().business().creditCardNumber();
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.cardNumberTextBox.sendKeys(cardNumber);
        String cvc=getFaker().number().digits(3);
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.cvcTextBox.sendKeys(cvc);
        Integer expMonth=getFaker().random().nextInt(1,12);
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.expiryMonthTextBox.sendKeys(String.valueOf(expMonth));
        Integer expYear=getFaker().random().nextInt(Year.now().getValue(),2100);
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.expiryYearTextBox.sendKeys(String.valueOf(expYear));

    }

    @And("I click Pay and Confirm Order button")
    public void ıClickPayAndConfirmOrderButton() {
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.payAndConfirmOrderButton.click();

    }

    @Then("I verify success message Your order has been placed successfully!")
    public void ıVerifySuccessMessageYourOrderHasBeenPlacedSuccessfully() {

        Assert.assertEquals("Congratulations! Your order has been confirmed!",
                tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.payAndConfirmOrderSuccessText.getText());

    }

    @Then("I verify ACCOUNT DELETED! and click Continue button")
    public void ıVerifyACCOUNTDELETEDAndClickContinueButton() {
        Assert.assertTrue(tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.accountDeleteVerifyText.isDisplayed());
        tc14_15_placeOrderRegisterWhileBeforeCheckoutPage.accountDeleteContinueButton.click();
    }
}
