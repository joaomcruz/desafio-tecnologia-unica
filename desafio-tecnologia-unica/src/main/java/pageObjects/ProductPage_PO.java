package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Variables;

import java.util.List;

public class ProductPage_PO extends Base_PO {

    @FindBy(css = "[data-testid='heading-product-title']")
    private WebElement productName;

    @FindBy(css = "[data-testid='bagButton']")
    private WebElement addToCartButton;

    @FindBy(css = "[data-testid='attribute-item']")
    private List<WebElement> attrButton;

    String attrButtonPath = "[data-testid='attribute-item']";

    @FindBy(xpath = "//div[@data-testid='dialog-content']/div[2]/button")
    private WebElement acceptAllertButton;



    public ProductPage_PO() {
        super();
    }

    public WebElement getProductName() {
        return productName;
    }


    public void proceedBasedOnDynamicsAttr() {
        if(checkSpecialAttribute()) {
            clickFirstElementRegularList(attrButton);
            waitForWebElementAndClick(addToCartButton);
            takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH ,"6 - Clicked on add to cart");
        } else {
            waitForWebElementAndClick(addToCartButton);
            takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH ,"6 - Clicked on add to cart");
        }
    }

    public Boolean checkSpecialAttribute() {
        return returnWebElementPath(attrButtonPath).size() > 0;
    }

    public void addToBasket() {
        proceedBasedOnDynamicsAttr();
    }

}
