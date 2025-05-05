package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TC18_ViewCategoryProductsPage;
import utilities.BrowserUtils;


public class TC18_ViewCategoryProductsStepDef {
    TC18_ViewCategoryProductsPage tc18_viewCategoryProductsPage=new TC18_ViewCategoryProductsPage();
    String text;
    @Then("I verify that categories are visible on left side bar")
    public void ıVerifyThatCategoriesAreVisibleOnLeftSideBar() {
        Assert.assertTrue(tc18_viewCategoryProductsPage.categoryGroup.isDisplayed());

    }

    @When("I click on Women category")
    public void ıClickOnWomenCategory() {
        BrowserUtils.clickWithJS(tc18_viewCategoryProductsPage.womenCategory);
        tc18_viewCategoryProductsPage.womenCategory.click();
    }

    @And("I click on any category link under Women category, for example: Dress")
    public void ıClickOnAnyCategoryLinkUnderWomenCategoryForExampleDress() {
      subCategoryProcces();

    }

    @Then("I verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS")
    public void ıVerifyThatCategoryPageIsDisplayedAndConfirmTextWOMENTOPSPRODUCTS() {
        verifyCategory();
    }

    @When("On left side bar, I click on any sub-category link of Men category")
    public void onLeftSideBarIClickOnAnySubCategoryLinkOfMenCategory() {
        BrowserUtils.clickWithJS(tc18_viewCategoryProductsPage.menCategory);
        tc18_viewCategoryProductsPage.menCategory.click();
        subCategoryProcces();
    }

    @Then("I verify that user is navigated to that category page")
    public void ıVerifyThatUserIsNavigatedToThatCategoryPage() {

        verifyCategory();
    }

    private void subCategoryProcces(){
        WebElement element= BrowserUtils.randomSelected(tc18_viewCategoryProductsPage.subCategory);
        text = element.findElement(By.xpath("./a")).getText();
        element.findElement(By.xpath("./a")).click();
    }
    private void verifyCategory(){
        Assert.assertTrue(BrowserUtils.convertTurkishCharsToEnglish(tc18_viewCategoryProductsPage.categoryProductsVerify.getText().toUpperCase()).contains(text.toUpperCase()));
        Assert.assertTrue(BrowserUtils.convertTurkishCharsToEnglish(tc18_viewCategoryProductsPage.categoryTitleVerify.getText().toUpperCase()).contains(text.toUpperCase()));
    }
}
