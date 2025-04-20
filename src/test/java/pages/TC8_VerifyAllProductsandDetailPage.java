package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TC8_VerifyAllProductsandDetailPage extends BasePage{

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productPageButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement productPageVerifyText;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    public List<WebElement>  productList;

    @FindBy(xpath = "//img[contains(@src, '/get_product_picture/')]")
    public List<WebElement>  productImageList;

    @FindBy(xpath = "//div[@class='choose']//ul[@class='nav nav-pills nav-justified']")
    public WebElement productViewButton;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productNameText;

    @FindBy(xpath = "(//div[@class='product-information']/p)[1]")
    public WebElement productCategoryText;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    public WebElement productPriceText;

    @FindBy(xpath = " (//div[@class='product-information']/p)[2]")
    public WebElement productAvailabilityText;

    @FindBy(xpath = " (//div[@class='product-information']/p)[3]")
    public WebElement productConditionText;

    @FindBy(xpath = " (//div[@class='product-information']/p)[4]")
    public WebElement productBrandText;
}
