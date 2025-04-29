package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC22_AddToCartFromRecommendedItemsPage extends BasePage{
    @FindBy(xpath = "  //div[@class='recommended_items']")
    public WebElement verifyRecommendedItems;

    @FindBy(xpath = "  //div[@class='item active']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> listRecommendedItems;

    @FindBy(xpath = "  //div[@class='item active']//div[@class='productinfo text-center']/p")
    public List<WebElement> addToCartRecommendedItemsText;

    @FindBy(xpath = "  //td[@class='cart_description']/h4")
    public WebElement verifyViewCartProduct;




}
