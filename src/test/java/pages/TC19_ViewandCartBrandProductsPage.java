package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC19_ViewandCartBrandProductsPage extends BasePage{

    @FindBy(xpath = " //div[@class='brands_products']")
    public WebElement brandsProducts;

    @FindBy(xpath = " //ul[@class='nav nav-pills nav-stacked']//li//a")
    public List<WebElement> brandsProductsList;

    @FindBy(xpath = " //h2[@class='title text-center']")
    public WebElement brandsProductsTextVerify;


}
