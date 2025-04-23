package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.WebElement;
import pages.TC1_RegisterUserPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;


import static utilities.BrowserUtils.getFaker;
import static utilities.BrowserUtils.selectCountryAndGetName;


public class Hooks {

    TC1_RegisterUserPage tc1_registerUserPage =new TC1_RegisterUserPage();
    static String email;
    static String password;
    static String name;
    static String firstName;
    static String lastName;
    static String companyName;
    static String address;
    static String address2;
    static  String state;
    static String city;
    static  String zipCode;
    static String mobile;
    static  String title;
    static  String country;

    @Before(order = 1, value = "@RegisterUser")
    public void registerUser() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        fillAndCreateAccount();
        tc1_registerUserPage.continueButton.click();
        Driver.closeDriver();
    }

    public void fillAndCreateAccount(){
        tc1_registerUserPage.signUpLoginButton.click();
        email = getFaker().internet().emailAddress();
        name = getFaker().name().name();
        tc1_registerUserPage.nameText.sendKeys(name);
        tc1_registerUserPage.emailText.sendKeys(email);
        tc1_registerUserPage.signUpButton.click();
        WebElement elementTitle= BrowserUtils.randomSelected(tc1_registerUserPage.titleRadioButton);
        elementTitle.click();
        title=elementTitle.getText();
        password = getFaker().internet().password();
        tc1_registerUserPage.accountPasswordText.sendKeys(password);
        BrowserUtils.selectBirthDate(tc1_registerUserPage.selectDaysDrop, tc1_registerUserPage.selectMonthsDrop, tc1_registerUserPage.selectYearsDrop);
        tc1_registerUserPage.checkBox1.click();
        tc1_registerUserPage.checkBox2.click();
        firstName = getFaker().name().firstName();
         lastName = getFaker().name().lastName();
         companyName=getFaker().company().name();
         address=getFaker().address().fullAddress();
         address2=getFaker().address().secondaryAddress();
         state=getFaker().address().state();
         city=getFaker().address().city();
         zipCode=getFaker().address().zipCode();
         mobile=getFaker().phoneNumber().cellPhone();
        tc1_registerUserPage.firstNameText.sendKeys(firstName);
        tc1_registerUserPage.lastNameText.sendKeys(lastName);
        tc1_registerUserPage.companyNameText.sendKeys(companyName);
        tc1_registerUserPage.addressText.sendKeys(address);
        tc1_registerUserPage.address2Text.sendKeys(address2);
        selectCountryAndGetName(tc1_registerUserPage.countryDrop);
        country= selectCountryAndGetName(tc1_registerUserPage.countryDrop);
        tc1_registerUserPage.stateText.sendKeys(state);
        tc1_registerUserPage.cityText.sendKeys(city);
        tc1_registerUserPage.zipcodeText.sendKeys(zipCode);
        tc1_registerUserPage.mobileNumberText.sendKeys(mobile);
        tc1_registerUserPage.createAccountButton.click();
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