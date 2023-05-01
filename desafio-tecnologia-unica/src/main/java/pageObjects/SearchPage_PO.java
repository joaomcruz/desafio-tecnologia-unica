package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Variables;

import java.util.List;

public class SearchPage_PO extends Base_PO {

    @FindBy(css = "[data-testid='list'] [data-testid='product-title']")
    private List<WebElement> productsReturned;

    private String clickedProductName;

    public String  getClickedProductName() {
        return clickedProductName;
    }

    public void setClickedProduct(WebElement clickedProduct) {

        this.clickedProductName = clickedProduct.getText();
    }

    public SearchPage_PO() {
        super();
    }

    public void checkReturnedProductsTextInput(String itemNameToCheck) {
        checkReturnedNamesFromList(productsReturned,itemNameToCheck);
        takeScreenshot(getDriver(),Global_Variables.SCREENSHOT_PATH , "4 - Checked returned products");
    }

    public void selectItemFromList() {
        setClickedProduct(clickFirstElementRegularList(productsReturned));
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH ,"5 - Clicked on a product");
    }

}
