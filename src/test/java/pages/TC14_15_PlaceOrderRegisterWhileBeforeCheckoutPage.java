package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC14_15_PlaceOrderRegisterWhileBeforeCheckoutPage extends BasePage{

    @FindBy(xpath = " //div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> anyProducts;

    @FindBy(xpath = " //a[@class='btn btn-default check_out']")
    public WebElement checkOutButton;

    @FindBy(xpath = " //p[@class='text-center']/a[@href='/login']")
    public WebElement registerLoginButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    public WebElement createAccoutVerifyText;

    @FindBy(xpath = "   //a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "   //*[contains(text(),'Logged in as')]")
    public WebElement userNameVerifyText;

    @FindBy(xpath = "    //div[@class='col-xs-12 col-sm-6']")
    public List<WebElement> checkoutVerifyAddress;

       @FindBy(xpath = "      //tr[contains(@id, 'product')]")
    public List<WebElement> checkoutVerifyOrder;

    @FindBy(name = "message")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement placeOrderButton;

    @FindBy(name = "name_on_card")
    public WebElement nameOnCardTextBox;

    @FindBy(name = "card_number")
    public WebElement cardNumberTextBox;

    @FindBy(name = "cvc")
    public WebElement cvcTextBox;
    @FindBy(name = "expiry_month")
    public WebElement expiryMonthTextBox;

    @FindBy(name = "expiry_year")
    public WebElement expiryYearTextBox;

    @FindBy(id = "submit")
    public WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//*[contains(text(),'Congratulations! Your order has been confirmed!')]")
    public WebElement payAndConfirmOrderSuccessText;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    public WebElement accountDeleteVerifyText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement accountDeleteContinueButton;




}
