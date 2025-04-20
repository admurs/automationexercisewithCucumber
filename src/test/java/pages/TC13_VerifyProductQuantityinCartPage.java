package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC13_VerifyProductQuantityinCartPage extends BasePage {

    @FindBy(xpath = " //div[@class='choose']//ul[@class='nav nav-pills nav-justified']")
    public List<WebElement> viewAnyProducts;

    @FindBy(id = "quantity")
    public WebElement quantityTextBox;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement addCartButton;

    @FindBy(xpath = " (//td[@class='cart_quantity'])[1]")
    public WebElement viewCartFirstProductQuantity;


}
