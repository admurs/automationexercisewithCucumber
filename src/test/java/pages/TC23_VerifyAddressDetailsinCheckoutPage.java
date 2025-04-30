package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TC23_VerifyAddressDetailsinCheckoutPage extends BasePage{
    @FindBy(xpath = "   //ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    public WebElement addressDeliveryNames;

    @FindBy(xpath = "   (//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[1]")
    public WebElement addressDeliveryCompany;

    @FindBy(xpath = "   (//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[2]")
    public WebElement addressDeliveryAddress1;

    @FindBy(xpath = "   (//ul[@id='address_delivery']//li[@class='address_address1 address_address2'])[3]")
    public WebElement addressDeliveryAddress2;

    @FindBy(xpath = "   //ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
    public WebElement addressDeliveryExtras;

    @FindBy(xpath = "   //ul[@id='address_delivery']//li[@class='address_country_name']")
    public WebElement addressDeliveryCountry;

    @FindBy(xpath = "   //ul[@id='address_delivery']//li[@class='address_phone']")
    public WebElement addressDeliveryPhone;

    @FindBy(xpath = "   //ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
    public WebElement addressBillingNames;

    @FindBy(xpath = "   (//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[1]")
    public WebElement addressBillingCompany;

    @FindBy(xpath = "   (//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[2]")
    public WebElement addressBillingAddress1;

    @FindBy(xpath = "   (//ul[@id='address_invoice']//li[@class='address_address1 address_address2'])[3]")
    public WebElement addressBillingAddress2;

    @FindBy(xpath = "   //ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
    public WebElement addressBillingExtras;

    @FindBy(xpath = "   //ul[@id='address_invoice']//li[@class='address_country_name']")
    public WebElement addressBillingCountry;

    @FindBy(xpath = "   //ul[@id='address_invoice']//li[@class='address_phone']")
    public WebElement addressBillingPhone;
}
