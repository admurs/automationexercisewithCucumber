package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC2_LoginUserCorrectPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'Login to your account')]")
    public WebElement loginText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailText;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordText;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;


}
