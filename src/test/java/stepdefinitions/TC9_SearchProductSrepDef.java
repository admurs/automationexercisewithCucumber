package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.TC9_SearchProductPage;
import utilities.ReusableMethods;

import java.util.List;

public class TC9_SearchProductSrepDef {
    String searchItem;
    TC9_SearchProductPage tc9_searchProductPage=new TC9_SearchProductPage();
    @When("I enter {string} in search input and click search button")
    public void ıEnterInSearchInputAndClickSearchButton(String search) {
        tc9_searchProductPage.searchTextBox.sendKeys(search);
        tc9_searchProductPage.searchButton.click();
        searchItem=search;
    }

    @Then("I verify SEARCHED PRODUCTS is visible")
    public void ıVerifySEARCHEDPRODUCTSIsVisible() {
       Assert.assertTrue(tc9_searchProductPage.searchProductsVerifyText.isDisplayed());
    }

    @And("I verify all the products related to search are visible")
    public void ıVerifyAllTheProductsRelatedToSearchAreVisible() {
        for (WebElement element: tc9_searchProductPage.searchProducts){
            Assert.assertTrue(element.getText().contains(searchItem));

        }
    }


}
