package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC5_RegisterUserExistingEmailPage extends BasePage{
    @FindBy(xpath = "//*[contains(text(),'Email Address already exist!')]")
    public WebElement alreadyExistText;
}
