package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class TC18_ViewCategoryProductsPage extends BasePage{

    @FindBy(xpath = " //div[@class='panel-group category-products']")
    public WebElement categoryGroup;

    @FindBy(xpath = " //a[@href='#Women']")
    public WebElement womenCategory;

    @FindBy(xpath = " //a[@href='#Men']")
    public WebElement menCategory;

    @FindBy(xpath = "  //div[@class='panel-collapse in']//li")
    public List<WebElement> subCategory;

    @FindBy(xpath = " //li[@class='active']")
    public WebElement categoryProductsVerify;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement categoryTitleVerify;







}
