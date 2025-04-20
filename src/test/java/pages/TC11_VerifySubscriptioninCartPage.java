package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC11_VerifySubscriptioninCartPage extends BasePage{

    @FindBy(xpath = "//li/a[@href='/view_cart']")
    public WebElement cardPageButton;

}
