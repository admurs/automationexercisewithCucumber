package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC16_PlaceOrderLoginBeforeCheckoutPage extends BasePage{
    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailText;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordText;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;
}
