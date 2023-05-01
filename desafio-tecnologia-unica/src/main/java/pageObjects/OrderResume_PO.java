package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Global_Variables;

public class OrderResume_PO extends Base_PO {

    private @FindBy(css = "div div.BasketPage-title")
    WebElement basketTitle;

    private @FindBy(css = "select.BasketItemProduct-quantity-dropdown")
    WebElement quantityDropDown;

    private @FindBy(css = "div.BasketItemProduct-price")
    WebElement priceNextToDropDown;

    private @FindBy(css = "span.BasketPriceBox-prices-title--normal")
    WebElement itemQuantitySubTotal;

    private @FindBy(css = "div div.BasketPriceBox-prices-values")
    WebElement itemsSubTotalValue;

    private @FindBy(css = "span.BasketItem-delete-label")
    WebElement itemExcludeFromBasket;

    private @FindBy(css = "div div.EmptyBasket-title")
    WebElement messageEmptyBasket;

    private Select quantityChosen;

    public OrderResume_PO() {
        super();
    }


    public void confirmBasketPage() {
        webElementStringAssertion(basketTitle, Global_Variables.TITLE_BASKET);
        takeScreenshot(getDriver(),Global_Variables.SCREENSHOT_PATH , "9 - Confirming that I am on the cart page");
    }

    public void confirmMatchingQuantities() {
        takeScreenshot(getDriver(),Global_Variables.SCREENSHOT_PATH , "11 - Confirm the amount of items");
        assertWebElementWithSelect(itemQuantitySubTotal, quantityChosen);

    }


    public void setProductAmount(String quantity) {
        Select quantityDropDown = new Select(this.quantityDropDown);
        quantityDropDown.selectByValue(quantity);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH ,"10 - I set the amount of items");
        this.quantityChosen = quantityDropDown;

    }



}
