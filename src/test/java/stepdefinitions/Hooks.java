package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import pages.TC1_RegisterUserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.getFaker;



public class Hooks {
    TC1_RegisterUserPage tc1_registerUserPage =new TC1_RegisterUserPage();

     static String email;
     static String password;
     static String name;

    @Before(order = 1, value = "@RegisterUser")
    public void registerUser() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        tc1_registerUserPage.signUpLoginButton.click();
        email = getFaker().internet().emailAddress();
        name = getFaker().name().name();
        tc1_registerUserPage.nameText.sendKeys(name);
        tc1_registerUserPage.emailText.sendKeys(email);
        tc1_registerUserPage.signUpButton.click();
        ReusableMethods.titleSelected(tc1_registerUserPage.titleRadioButton).click();
        password = getFaker().internet().password();
        tc1_registerUserPage.accountPasswordText.sendKeys(password);
        ReusableMethods.selectBirthDate(tc1_registerUserPage.selectDaysDrop, tc1_registerUserPage.selectMonthsDrop, tc1_registerUserPage.selectYearsDrop);
        tc1_registerUserPage.checkBox1.click();
        tc1_registerUserPage.checkBox2.click();
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
        tc1_registerUserPage.createAccountButton.click();
        tc1_registerUserPage.continueButton.click();
        Driver.closeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }
}