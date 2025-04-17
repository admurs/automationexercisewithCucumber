package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC3_LoginUserInCorrectPage {
    public TC3_LoginUserInCorrectPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[contains(text(),'Login to your account')]")
    public WebElement incorrectLoginText;
}
