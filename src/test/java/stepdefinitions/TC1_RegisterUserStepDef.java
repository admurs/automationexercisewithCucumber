package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TC1_RegisterUserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import static utilities.ReusableMethods.getFaker;

public class TC1_RegisterUserStepDef {
    TC1_RegisterUserPage tc1_registerUserPage =new TC1_RegisterUserPage();
    @Given("I launch the browser")
    public void ıLaunchTheBrowser() {
    }

    @When("I navigate to url automationexercise")
    public void ıNavigateToUrlAutomationexercise() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @Then("I verify that home page is visible successfully")
    public void ıVerifyThatHomePageIsVisibleSuccessfully() {
        String actualTitle="Automation Exercise";
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @When("I click on Signup-Login button")
    public void ıClickOnSignupLoginButton() {
        tc1_registerUserPage.signUpLoginButton.click();
    }

    @Then("I verify that New User Signup! is visible")
    public void ıVerifyThatNewUserSignupIsVisible() {
        tc1_registerUserPage.signUpText.isDisplayed();
    }

    @When("I enter name and email address")
    public void ıEnterNameAndEmailAddress() {
        String email = getFaker().internet().emailAddress();
        String name = getFaker().name().name();
        tc1_registerUserPage.nameText.sendKeys(name);
        tc1_registerUserPage.emailText.sendKeys(email);
    }

    @And("I click Signup button")
    public void ıClickSignupButton() {
        tc1_registerUserPage.signUpButton.click();
    }

    @Then("I verify that ENTER ACCOUNT INFORMATION is visible")
    public void ıVerifyThatENTERACCOUNTINFORMATIONIsVisible()  {
        Assert.assertTrue(tc1_registerUserPage.signUpVerifyText.isDisplayed());
    }

    @When("I fill details: Title, Name, Email, Password, Date of birth")
    public void ıFillDetailsTitleNameEmailPasswordDateOfBirth() {
        ReusableMethods.titleSelected(tc1_registerUserPage.titleRadioButton).click();
        String password = getFaker().internet().password();
        tc1_registerUserPage.accountPasswordText.sendKeys(password);
        ReusableMethods.selectBirthDate(tc1_registerUserPage.selectDaysDrop, tc1_registerUserPage.selectMonthsDrop, tc1_registerUserPage.selectYearsDrop);

    }

    @And("I select checkbox Sign up for our newsletter!")
    public void ıSelectCheckboxSignUpForOurNewsletter() {
        tc1_registerUserPage.checkBox1.click();

    }

    @And("I select checkbox Receive special offers from our partners!")
    public void ıSelectCheckboxReceiveSpecialOffersFromOurPartners() {
        tc1_registerUserPage.checkBox2.click();
    }

    @And("I fill details: First name, Last name, Company, Address, AddressDetail, Country, State, City, Zipcode, Mobile Number")
    public void ıFillDetailsFirstNameLastNameCompanyAddressAddressDetailCountryStateCityZipcodeMobileNumber() {
        String firstName = getFaker().name().firstName();
        String lastName = getFaker().name().lastName();
        String companyName=getFaker().company().name();
        String address=getFaker().address().fullAddress();
        String address2=getFaker().address().secondaryAddress();
        String state=getFaker().address().state();
        String city=getFaker().address().city();
        String zipCode=getFaker().address().zipCode();
        String mobile=getFaker().phoneNumber().cellPhone();
        tc1_registerUserPage.firstNameText.sendKeys(firstName);
        tc1_registerUserPage.lastNameText.sendKeys(lastName);
        tc1_registerUserPage.companyNameText.sendKeys(companyName);
        tc1_registerUserPage.addressText.sendKeys(address);
        tc1_registerUserPage.address2Text.sendKeys(address2);
        ReusableMethods.selectCountry(tc1_registerUserPage.countryDrop);
        tc1_registerUserPage.stateText.sendKeys(state);
        tc1_registerUserPage.cityText.sendKeys(city);
        tc1_registerUserPage.zipcodeText.sendKeys(zipCode);
        tc1_registerUserPage.mobileNumberText.sendKeys(mobile);
    }

    @And("I click Create Account button")
    public void ıClickCreateAccountButton() {
        tc1_registerUserPage.createAccountButton.click();
    }

    @Then("I verify that ACCOUNT CREATED! is visible")
    public void ıVerifyThatACCOUNTCREATEDIsVisible() {
      Assert.assertTrue( tc1_registerUserPage.createAccoutVerifyText.isDisplayed());
    }

    @When("I click Create Continue button")
    public void ıClickCreateContinueButton() {
        tc1_registerUserPage.continueButton.click();
    }

    @Then("I verify that Logged in as username is visible")
    public void ıVerifyThatLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(tc1_registerUserPage.userNameVerifyText.isDisplayed());

    }

    @When("I click Delete Account button")
    public void ıClickDeleteAccountButton() {
        tc1_registerUserPage.deleteAccountButton.click();

    }

    @Then("I verify that ACCOUNT DELETED! is visible")
    public void ıVerifyThatACCOUNTDELETEDIsVisible() {
        Assert.assertTrue( tc1_registerUserPage.deleteAccountVerifyText.isDisplayed());


    }

    @And("I click Delete Continue button")
    public void ıClickDeleteContinueButton() {
        tc1_registerUserPage.deleteContinueButton.click();
    }


}
