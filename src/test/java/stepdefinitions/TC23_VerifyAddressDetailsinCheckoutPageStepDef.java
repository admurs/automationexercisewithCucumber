package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.TC23_VerifyAddressDetailsinCheckoutPage;


public class TC23_VerifyAddressDetailsinCheckoutPageStepDef {
    TC23_VerifyAddressDetailsinCheckoutPage tc23_verifyAddressDetailsinCheckoutPage=new TC23_VerifyAddressDetailsinCheckoutPage();

    @Then("I verify that the delivery address is same address filled at the time registration of account")
    public void ıVerifyThatTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() {
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryNames.getText(),Hooks.title+" "+Hooks.firstName+" "+Hooks.lastName);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryCompany.getText(),Hooks.companyName);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryAddress1.getText(),Hooks.address);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryAddress2.getText(),Hooks.address2);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryExtras.getText(),Hooks.city+" "+Hooks.state+" "+Hooks.zipCode);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryCountry.getText(),Hooks.country);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressDeliveryPhone.getText(),Hooks.mobile);
    }


    @And("I verify that the billing address is same address filled at the time registration of account")
    public void ıVerifyThatTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() {
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingNames.getText(),Hooks.title+" "+Hooks.firstName+" "+Hooks.lastName);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingCompany.getText(),Hooks.companyName);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingAddress1.getText(),Hooks.address);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingAddress2.getText(),Hooks.address2);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingExtras.getText(),Hooks.city+" "+Hooks.state+" "+Hooks.zipCode);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingCountry.getText(),Hooks.country);
        Assert.assertEquals(tc23_verifyAddressDetailsinCheckoutPage.addressBillingPhone.getText(),Hooks.mobile);
    }
}
