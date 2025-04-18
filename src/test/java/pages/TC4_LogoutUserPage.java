package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC4_LogoutUserPage extends BasePage{
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logoutButton;


}
