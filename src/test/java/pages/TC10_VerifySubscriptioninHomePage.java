package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC10_VerifySubscriptioninHomePage extends BasePage{

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    public WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    public WebElement susbscribeMailTextBox;

    @FindBy(id = "subscribe")
    public WebElement susbscribeButton;

    @FindBy(xpath = " //div[@class='alert-success alert']")
    public WebElement subscriptionSuccess;


}
