package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TC13_VerifyProductQuantityinCartPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC13_VerifyProductQuantityinCartStepDef {

    TC13_VerifyProductQuantityinCartPage tc13_verifyProductQuantityinCartPage=new TC13_VerifyProductQuantityinCartPage();
    int viewQuantity=0;
    @When("I click View Product for any product on home page")
    public void ıClickViewProductForAnyProductOnHomePage() {

       WebElement element= BrowserUtils.randomSelected(tc13_verifyProductQuantityinCartPage.viewAnyProducts);
       BrowserUtils.clickWithJS(element);
       element.click();


    }

    @Then("I verify product detail is opened")
    public void ıVerifyProductDetailIsOpened() {
        String actualTitle="Automation Exercise - Product Details";
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @When("I increase quantity to {int}")
    public void ıIncreaseQuantityTo(int quantity) {
        tc13_verifyProductQuantityinCartPage.quantityTextBox.clear();
        tc13_verifyProductQuantityinCartPage.quantityTextBox.sendKeys(String.valueOf(quantity));
        viewQuantity=quantity;
    }

    @And("I click Add to cart button")
    public void ıClickAddToCartButton() {
        tc13_verifyProductQuantityinCartPage.addCartButton.click();
    }

    @Then("I verify that product is displayed in cart page with exact quantity")
    public void ıVerifyThatProductIsDisplayedInCartPageWithExactQuantity() {
           Assert.assertEquals(String.valueOf(viewQuantity),tc13_verifyProductQuantityinCartPage.viewCartFirstProductQuantity.getText());
    }
}
