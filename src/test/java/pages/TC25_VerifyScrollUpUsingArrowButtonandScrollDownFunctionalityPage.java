package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC25_VerifyScrollUpUsingArrowButtonandScrollDownFunctionalityPage extends BasePage{

    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    public WebElement pageUpButton;

    @FindBy(xpath = "//div[@id='slider-carousel']//div[@class='item active']//h2")
    public WebElement verfiySliderText;


}
