package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC21_AddReviewOnProductPage extends BasePage{
    @FindBy(xpath = "  //*[contains(text(),'Write Your Review')]")
    public WebElement viewProductVerify;

    @FindBy(id = "name")
    public WebElement nameTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "review")
    public WebElement reviewTextBox;

    @FindBy(xpath = " //div[@class='alert-success alert']//span")
    public WebElement verifyReviewMessage;

}
