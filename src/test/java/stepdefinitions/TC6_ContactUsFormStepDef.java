package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC6_ContactUsFormPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.BrowserUtils.getFaker;


public class TC6_ContactUsFormStepDef {
    TC6_ContactUsFormPage tc6_contactUsFormPage=new TC6_ContactUsFormPage();
    @When("I click on Contact Us button")
    public void ıClickOnContactUsButton() {
       tc6_contactUsFormPage.contactUsButon.click();
    }

    @Then("I verify that GET IN TOUCH is visible")
    public void ıVerifyThatGETINTOUCHIsVisible() {
        Assert.assertTrue(tc6_contactUsFormPage.contactUsVerifyText.isDisplayed());
    }

    @When("I enter name, email, subject and message")
    public void ıEnterNameEmailSubjectAndMessage() {

        String name = getFaker().name().name();
        String email = getFaker().internet().emailAddress();
        String subject = getFaker().lorem().fixedString(10);
        String message= getFaker().lorem().fixedString(20);
        tc6_contactUsFormPage.contactUsNameText.sendKeys(name);
        tc6_contactUsFormPage.contactUsEmailText.sendKeys(email);
        tc6_contactUsFormPage.contactUsSubjectText.sendKeys(subject);
        tc6_contactUsFormPage.contactUsMessageText.sendKeys(message);

    }

    @And("I upload file")
    public void ıUploadFile() {
        String file =System.getProperty("user.dir") + "/" + ConfigReader.getProperty("file.upload.path");
        tc6_contactUsFormPage.contactUsUploadButton.sendKeys(file);
    }

    @And("I click Submit button")
    public void ıClickSubmitButton() {
        BrowserUtils.scrollToElement(tc6_contactUsFormPage.contactUsSubmitButton);
        tc6_contactUsFormPage.contactUsSubmitButton.click();

    }

    @And("I click OK button")
    public void ıClickOKButton() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("I verify success message Success! Your details have been submitted successfully. is visible")
    public void ıVerifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
       Assert.assertTrue(tc6_contactUsFormPage.contactUsSuccessText.isDisplayed());
    }

    @When("I click Home button")
    public void ıClickHomeButton() {
        tc6_contactUsFormPage.contactUsHomeButton.click();
    }

    @Then("I verify that landed to home page successfully")
    public void ıVerifyThatLandedToHomePageSuccessfully() {
        String actualTitle="Automation Exercise";
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
