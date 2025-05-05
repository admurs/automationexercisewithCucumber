package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import pages.TC12_AddProductsinCartPage;
import pages.TC22_AddToCartFromRecommendedItemsPage;
import utilities.BrowserUtils;

public class TC22_AddToCartFromRecommendedItemsStepDef {
    TC22_AddToCartFromRecommendedItemsPage tc22_addToCartFromRecommendedItemsPage=new TC22_AddToCartFromRecommendedItemsPage();
    TC12_AddProductsinCartPage tc12_addProductsinCartPage=new TC12_AddProductsinCartPage();
    String text;
    @And("I scroll to bottom of page")
    public void ıScrollToBottomOfPage() {
        BrowserUtils.executeJSCommand("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("I verify RECOMMENDED ITEMS are visible")
    public void ıVerifyRECOMMENDEDITEMSAreVisible() {
        Assert.assertTrue(tc22_addToCartFromRecommendedItemsPage.verifyRecommendedItems.isDisplayed());
    }

    @When("I click on Add To Cart on Recommended product")
    public void ıClickOnAddToCartOnRecommendedProduct() {
    WebElement element= BrowserUtils.randomSelected(tc22_addToCartFromRecommendedItemsPage.listRecommendedItems);
    int select=tc22_addToCartFromRecommendedItemsPage.listRecommendedItems.indexOf(element);
    text=tc22_addToCartFromRecommendedItemsPage.addToCartRecommendedItemsText.get(select).getText();
    element.click();
    }

    @And("I click on View Cart button")
    public void ıClickOnViewCartButton() {
        tc12_addProductsinCartPage.viewCartButton.click();

    }

    @Then("I verify that product is displayed in cart page")
    public void ıVerifyThatProductIsDisplayedInCartPage() {
        Assert.assertTrue(tc22_addToCartFromRecommendedItemsPage.verifyViewCartProduct.getText().contains(text));

    }
}
