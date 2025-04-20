package stepdefinitions;

import io.cucumber.java.en.When;
import pages.TC11_VerifySubscriptioninCartPage;

public class TC11_VerifySubscriptioninCartPageStepDef {
    TC11_VerifySubscriptioninCartPage tc11_verifySubscriptioninCartPage=new TC11_VerifySubscriptioninCartPage();
    @When("I click Cart button")
    public void ıClickCartButton() {
        tc11_verifySubscriptioninCartPage.cardPageButton.click();

    }
}
