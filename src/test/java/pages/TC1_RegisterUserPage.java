package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TC1_RegisterUserPage {
    public TC1_RegisterUserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLoginButton;
    @FindBy(xpath = "//*[contains(text(),'New User Signup!')]")
    public WebElement signUpText;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameText;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailText;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;
    @FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
    public WebElement signUpVerifyText;
    @FindBy(xpath = "//div[@class='radio-inline']")
    public List<WebElement> titleRadioButton;
    @FindBy(xpath = "//input[@data-qa='password']")
    public WebElement accountPasswordText;
    @FindBy(xpath = "//select[@data-qa='days']")
    public WebElement selectDaysDrop;
    @FindBy(xpath = "//select[@data-qa='months']")
    public WebElement selectMonthsDrop;
    @FindBy(xpath = "//select[@data-qa='years']")
    public WebElement selectYearsDrop;
    @FindBy(id = "newsletter")
    public WebElement checkBox1;
    @FindBy(id = "optin")
    public WebElement checkBox2;
    @FindBy(xpath = "//input[@data-qa='first_name']")
    public WebElement firstNameText;
    @FindBy(xpath = "//input[@data-qa='last_name']")
    public WebElement lastNameText;
    @FindBy(xpath = "//input[@data-qa='company']")
    public WebElement companyNameText;
    @FindBy(xpath = "//input[@data-qa='address']")
    public WebElement addressText;
    @FindBy(xpath = "//input[@data-qa='address2']")
    public WebElement address2Text;
    @FindBy(xpath = "//select[@data-qa='country']")
    public WebElement countryDrop;
    @FindBy(xpath = "//input[@data-qa='state']")
    public WebElement stateText;
    @FindBy(xpath = "//input[@data-qa='city']")
    public WebElement cityText;
    @FindBy(xpath = "//input[@data-qa='zipcode']")
    public WebElement zipcodeText;
    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    public WebElement mobileNumberText;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;
    @FindBy(xpath = "//h2[@data-qa='account-created']")
    public WebElement createAccoutVerifyText;
    @FindBy(xpath = "   //a[@data-qa='continue-button']")
    public WebElement continueButton;
    @FindBy(xpath = "   //*[contains(text(),'Logged in as')]")
    public WebElement userNameVerifyText;
    @FindBy(xpath = " //a[@href='/delete_account']")
    public WebElement deleteAccountButton;
    @FindBy(xpath = " //h2[@data-qa='account-deleted']")
    public WebElement deleteAccountVerifyText;
    @FindBy(xpath = " //a[@data-qa='continue-button']")
    public WebElement deleteContinueButton;

}