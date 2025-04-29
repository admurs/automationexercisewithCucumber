package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC6_ContactUsFormPage extends BasePage{
    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement contactUsButon;

    @FindBy(xpath = "//*[contains(text(),'Get In Touch')]")
    public WebElement contactUsVerifyText;

    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement contactUsNameText;

    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement contactUsEmailText;

    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement contactUsSubjectText;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    public WebElement contactUsMessageText;

    @FindBy(xpath = "   //input[@name='upload_file']")
    public WebElement contactUsUploadButton;

    @FindBy(xpath = "   (//*[contains(@type, 'submit')])[1]")
    public WebElement contactUsSubmitButton;

    @FindBy(xpath = "//*[contains(text(),'Success! Your details have been submitted successfully.')]")
    public WebElement contactUsSuccessText;

    @FindBy(xpath = " //a[@class='btn btn-success']")
    public WebElement contactUsHomeButton;


}
