package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC5_RegisterUserExistingEmailPage {
    public TC5_RegisterUserExistingEmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[contains(text(),'Email Address already exist!')]")
    public WebElement alreadyExistText;
}
