package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC8_VerifyAllProductsandDetailPage;
import utilities.Driver;

public class TC8_VerifyAllProductsandDetailPageStepDef {
    TC8_VerifyAllProductsandDetailPage tc8_verifyAllProductsandDetailPage=new TC8_VerifyAllProductsandDetailPage();

    @When("I click on Products button")
    public void ıClickOnProductsButton() {
        tc8_verifyAllProductsandDetailPage.productPageButton.click();
    }

    @Then("I verify user is navigated to ALL PRODUCTS page successfully")
    public void ıVerifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        Assert.assertEquals(tc8_verifyAllProductsandDetailPage.productPageVerifyText.getText(),"ALL PRODUCTS");
    }

    @And("the products list is visible")
    public void theProductsListIsVisible() {
        int list=tc8_verifyAllProductsandDetailPage.productList.size();
        int image=tc8_verifyAllProductsandDetailPage.productImageList.size();
        Assert.assertEquals(list,image);
    }

    @When("I click on View Product of first product")
    public void ıClickOnViewProductOfFirstProduct() {
        tc8_verifyAllProductsandDetailPage.productViewButton.click();
    }

    @Then("I verify user is landed to product detail page")
    public void ıVerifyUserIsLandedToProductDetailPage() {

        String actualProductLink="https://www.automationexercise.com/product_details/1";
        String expectedProductLink= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualProductLink,expectedProductLink);

    }

    @And("I verify that detail is visible: product name, category, price, availability, condition, brand")
    public void ıVerifyThatDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productNameText.isDisplayed());
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productCategoryText.isDisplayed());
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productPriceText.isDisplayed());
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productAvailabilityText.isDisplayed());
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productConditionText.isDisplayed());
        Assert.assertTrue(tc8_verifyAllProductsandDetailPage.productBrandText.isDisplayed());
    }
}
