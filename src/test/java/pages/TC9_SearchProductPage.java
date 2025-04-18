package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC9_SearchProductPage extends BasePage{
    @FindBy(id = "search_product")
    public WebElement searchTextBox;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(xpath = " //div[@class='productinfo text-center']/p")
    public List<WebElement> searchProducts;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement searchProductsVerifyText;




}
