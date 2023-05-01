package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Variables;

public class WarrantyPage_PO extends Base_PO {

    private @FindBy(css = "[data-testid='product-card-title']")
    WebElement productNameTop;

    private @FindBy(css = "[data-testid='summary-product-title']")
    WebElement productNameBottom;

    private @FindBy(css = "[data-testid='summary-continue-btn']")
    WebElement continueButton;


    public WarrantyPage_PO() {
        super();
    }

    public WebElement getProductNameTop() {
        return productNameTop;
    }

    public WebElement getProductNameBottom() {
        return productNameBottom;
    }

    public void proceedToOrderResume() {
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH , "7 - Clicking on proceed button");
        waitForWebElementAndClick(continueButton);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH ,"8 - Clicked on proceed button");
    }
}

