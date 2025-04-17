package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TC7_VerifyTestCasesPage {
    public TC7_VerifyTestCasesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/test_cases']")
    public WebElement testCasesPage;

    @FindBy(xpath = "//div[@class='panel-collapse collapse']")
    public List<WebElement> testCasesValidation;
}
