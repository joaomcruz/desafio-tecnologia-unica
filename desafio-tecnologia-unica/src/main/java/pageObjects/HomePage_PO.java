package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Variables;

import java.util.List;

public class HomePage_PO extends Base_PO {

    @FindBy(css = "[data-testid='input-search']")
    private WebElement searchBox;

    @FindBy(css = "[data-testid='search-submit']")
    private WebElement searchButton;


    @FindBy(css = "[data-testid='top-terms-item']")
    private List<WebElement> suggestionList;

    private String searchedProductDropdown;

    private String searchedProductButton;



    public HomePage_PO() {
        super();
    }

    public void visitHomePage() {

        navigateTo_URL(Global_Variables.URL);

    }

    public void searchProductClickingButton(String product) {
        sendKeys(searchBox, product);
        setSearchedProductButton(product);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "2 - Name entered on the search box");
        waitForWebElementAndClick(searchButton);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "3 - Clicked on the search button");

    }

    public void searchProductDropdown() {
        waitForWebElementAndClick(searchBox);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "2 - Name entered on the search box");
        waitForListToBeVisible(suggestionList);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "3 - Names presented on the dropdown");
                setSearchedNameFromDropdown(suggestionList.get(0).getText().replaceAll("[^A-Z]","").trim());
        clickFirstElementSpecialList(suggestionList);
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "4- Clicked on the first option of the dropdown menu");
    }

    public String getProductNameButtonSearch() {
        return searchedProductButton;
    }

    public String getProductNameDropdownSearch() {
        return searchedProductDropdown;
    }



    public void setSearchedProductButton(String searchedName) {
        this.searchedProductButton = searchedName;
    }

    public void setSearchedNameFromDropdown(String searchedName) {
        this.searchedProductDropdown = searchedName;
    }


}
