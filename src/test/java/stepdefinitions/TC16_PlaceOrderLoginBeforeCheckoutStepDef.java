package stepdefinitions;

import io.cucumber.java.en.And;
import pages.TC16_PlaceOrderLoginBeforeCheckoutPage;

public class TC16_PlaceOrderLoginBeforeCheckoutStepDef {
    TC16_PlaceOrderLoginBeforeCheckoutPage tc16_placeOrderLoginBeforeCheckoutPage=new TC16_PlaceOrderLoginBeforeCheckoutPage();
    @And("I fill email, password and click Login button")
    public void ıFillEmailPasswordAndClickLoginButton() {

        tc16_placeOrderLoginBeforeCheckoutPage.emailText.sendKeys(Hooks.email);
        tc16_placeOrderLoginBeforeCheckoutPage.passwordText.sendKeys(Hooks.password);
        tc16_placeOrderLoginBeforeCheckoutPage.loginButton.click();
    }
}
