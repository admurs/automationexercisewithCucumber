package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC3_LoginUserInCorrectPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'Login to your account')]")
    public WebElement incorrectLoginText;
}
