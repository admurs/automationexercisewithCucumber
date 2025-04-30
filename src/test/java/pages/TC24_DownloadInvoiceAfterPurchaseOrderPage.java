package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC24_DownloadInvoiceAfterPurchaseOrderPage extends  BasePage{
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement downloadInvoiceButton;

    @FindBy(xpath = "  //*[contains(text(),'Congratulations! Your order has been confirmed!')]")
    public WebElement downloadInvoiceButtonVerify;

    @FindBy(xpath = "  //a[@data-qa='continue-button']")
    public WebElement downloadInvoiceContinueButton;


}
