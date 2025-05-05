package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TC19_ViewandCartBrandProductsPage;
import utilities.BrowserUtils;

public class TC19_ViewandCartBrandProductsStepDef {
    TC19_ViewandCartBrandProductsPage tc19_viewandCartBrandProductsPage=new TC19_ViewandCartBrandProductsPage();
    String text;
    @Then("I verify that Brands are visible on left side bar")
    public void ıVerifyThatBrandsAreVisibleOnLeftSideBar() {
        Assert.assertTrue(tc19_viewandCartBrandProductsPage.brandsProducts.isDisplayed());
    }

    @When("I click on any brand name")
    public void ıClickOnAnyBrandName() {
       clickRandomBrand();
    }

    @Then("I verify that user is navigated to brand page and brand products are displayed")
    public void ıVerifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() {
        verifyBrand();
    }

    @When("On left side bar, I click on any other brand link")
    public void onLeftSideBarIClickOnAnyOtherBrandLink() {
        clickRandomBrand();
    }

    @Then("I verify that user is navigated to that brand page and can see products")
    public void ıVerifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() {
        verifyBrand();
    }


    private void clickRandomBrand(){
        BrowserUtils.clickWithJS(tc19_viewandCartBrandProductsPage.brandsProducts);
        WebElement element= BrowserUtils.randomSelected(tc19_viewandCartBrandProductsPage.brandsProductsList);
        text=BrowserUtils.textRegex(element);
        element.click();
    }
    private void verifyBrand(){
        Assert.assertTrue(tc19_viewandCartBrandProductsPage.brandsProductsTextVerify.getText().contains(text));
    }
}
