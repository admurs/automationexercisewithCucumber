package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.TC12_AddProductsinCartPage;
import utilities.BrowserUtils;

public class TC12_AddProductsinCartStepDef {

    TC12_AddProductsinCartPage tc12_addProductsinCartPage=new TC12_AddProductsinCartPage();

    String firstProductPrice,secondProductPrice;
    Integer defaultQuantity=1;

    @And("I hover over first product and click Add to cart")
    public void ıHoverOverFirstProductAndClickAddToCart() {
        BrowserUtils.clickWithJS(tc12_addProductsinCartPage.firstProduct);
        BrowserUtils.hover(tc12_addProductsinCartPage.firstProduct);
        tc12_addProductsinCartPage.firstProductAddCart.click();
        firstProductPrice=tc12_addProductsinCartPage.firstProductPrice.getText();
    }

    @And("I click Continue Shopping button")
    public void ıClickContinueShoppingButton() {
        tc12_addProductsinCartPage.continueShoppingButton.click();
    }

    @And("I hover over second product and click Add to cart")
    public void ıHoverOverSecondProductAndClickAddToCart() {
        BrowserUtils.hover(tc12_addProductsinCartPage.secondProduct);
        tc12_addProductsinCartPage.secondProductAddCart.click();

        secondProductPrice=tc12_addProductsinCartPage.secondProductPrice.getText();

    }

    @And("I click View Cart button")
    public void ıClickViewCartButton() {
        BrowserUtils.waitForClickablility ( tc12_addProductsinCartPage.viewCartButton,5);
        tc12_addProductsinCartPage.viewCartButton.click();
    }

    @Then("I verify both products are added to Cart")
    public void ıVerifyBothProductsAreAddedToCart() {
        Assert.assertEquals(2, tc12_addProductsinCartPage.viewCartProducts.size());
    }

    @And("I verify their prices, quantity and total price")
    public void ıVerifyTheirPricesQuantityAndTotalPrice() {
        Assert.assertEquals(firstProductPrice,tc12_addProductsinCartPage.viewCartFirstProductPrice.getText());
        Assert.assertEquals(String.valueOf(defaultQuantity),tc12_addProductsinCartPage.viewCartFirstProductQuantity.getText());
        Assert.assertEquals(firstProductPrice,tc12_addProductsinCartPage.viewCartFirstProductTotal.getText());

        Assert.assertEquals(secondProductPrice,tc12_addProductsinCartPage.viewCartSecondProductPrice.getText());
        Assert.assertEquals(String.valueOf(defaultQuantity),tc12_addProductsinCartPage.viewCartSecondProductQuantity.getText());
        Assert.assertEquals(secondProductPrice,tc12_addProductsinCartPage.viewCartSecondProductTotal.getText());

    }
}
