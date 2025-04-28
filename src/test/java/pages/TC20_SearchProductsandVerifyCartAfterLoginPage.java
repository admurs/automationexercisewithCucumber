package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC20_SearchProductsandVerifyCartAfterLoginPage extends BasePage{
    @FindBy(xpath = "   //a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "    //img[contains(@src, '/get_product_picture')]")
    public List<WebElement> searcProductList;

    @FindBy(xpath = "   //div[@class='overlay-content']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> productAddCart;

    @FindBy(xpath = "   //button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement searchProductsVerifyText;

    @FindBy(xpath = "   //td[@class='cart_description']/h4")
    public List<WebElement> productCartList;



}
