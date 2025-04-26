package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC17_RemoveProductsFromCartPage extends BasePage{

    @FindBy(xpath = " //a[@class='cart_quantity_delete']")
    public WebElement cartDeleteButton;

    @FindBy(xpath = "//p[@class='text-center']/b")
    public WebElement cartDeleteVerifyText;
}
