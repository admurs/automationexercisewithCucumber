package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC24_DownloadInvoiceAfterPurchaseOrderPage;
import utilities.BrowserUtils;


public class TC24_DownloadInvoiceAfterPurchaseOrderStepDef {
    TC24_DownloadInvoiceAfterPurchaseOrderPage tc24_downloadInvoiceAfterPurchaseOrderPage = new TC24_DownloadInvoiceAfterPurchaseOrderPage();

    @When("I click Download Invoice button and verify invoice is downloaded successfully")
    public void ıClickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() {
        tc24_downloadInvoiceAfterPurchaseOrderPage.downloadInvoiceButton.click();
        Assert.assertTrue(tc24_downloadInvoiceAfterPurchaseOrderPage.downloadInvoiceButtonVerify.isDisplayed());
        BrowserUtils.waitFor(5);
        BrowserUtils.deleteIndexTxtFiles("invoice","txt");
    }

    @And("I click Continue button")
    public void ıClickContinueButton() {
        tc24_downloadInvoiceAfterPurchaseOrderPage.downloadInvoiceContinueButton.click();

    }




}

