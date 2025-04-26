package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC17_RemoveProductsFromCartPage;
import utilities.BrowserUtils;

public class TC17_RemoveProductsFromCartStepDef {
    TC17_RemoveProductsFromCartPage tc17_removeProductsFromCartPage = new TC17_RemoveProductsFromCartPage();

    @When("I click X button corresponding to particular product")
    public void ıClickXButtonCorrespondingToParticularProduct() {
        tc17_removeProductsFromCartPage.cartDeleteButton.click();
    }

    @Then("I verify that product is removed from the cart")
    public void ıVerifyThatProductIsRemovedFromTheCart() {
        BrowserUtils.waitForVisibility(tc17_removeProductsFromCartPage.cartDeleteVerifyText,1);
        Assert.assertEquals("Cart is empty!",tc17_removeProductsFromCartPage.cartDeleteVerifyText.getText());

    }
}