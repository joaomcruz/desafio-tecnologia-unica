package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.*;
import utils.Global_Variables;


public class addToBasket_UsingSearchBox_Steps extends Base_PO {

    private final HomePage_PO homePage_PO;
    private final OrderResume_PO orderResume_PO;

    private final ProductPage_PO productPage_PO;

    private final SearchPage_PO searchPage_PO;

    private final WarrantyPage_PO warrantyPage_PO;


    public addToBasket_UsingSearchBox_Steps(HomePage_PO homePage_PO, OrderResume_PO orderResume_PO,
                                            ProductPage_PO productPage_PO, SearchPage_PO searchPage_PO,
                                            WarrantyPage_PO warrantyPage_PO) {
        this.homePage_PO = homePage_PO;
        this.orderResume_PO = orderResume_PO;
        this.productPage_PO = productPage_PO;
        this.searchPage_PO = searchPage_PO;
        this.warrantyPage_PO = warrantyPage_PO;

    }

    @Given("I access magazine luiza website")
    public void I_access_magazine_luiza_website() {

        homePage_PO.visitHomePage();
        takeScreenshot(getDriver(), Global_Variables.SCREENSHOT_PATH, "1 - Visiting URL step");

    }

    @And("I search for a product clicking on the search button {}")
    public void I_search_for_a_product_clicking_on_the_search_button(String product) {
        homePage_PO.searchProductClickingButton(product);

    }


    @Then("I confirm that the search returned the searched product")
    public void I_confirm_that_the_search_returned_the_searched_product() {
        searchPage_PO.checkReturnedProductsTextInput(homePage_PO.getProductNameButtonSearch());
    }

    @And("I select one product from the list")
    public void I_select_one_product_from_the_list() {
        searchPage_PO.selectItemFromList();
    }


    @Then("I check that I was redirected to the products page that I clicked")
    public void I_check_that_I_was_redirected_to_the_products_page_that_I_clicked() {
        assertWebElementsString(searchPage_PO.getClickedProductName(), productPage_PO.getProductName());
    }

    @And("I click to add it to the cart")
    public void I_click_to_add_it_to_the_cart(){
        productPage_PO.addToBasket();
    }


    @Then("I check the product name")
    public void I_check_the_product_name() {
        webElementsContainsString(homePage_PO.getProductNameButtonSearch(), warrantyPage_PO.getProductNameTop(), warrantyPage_PO.getProductNameBottom());

    }


    @And("I proceed to the order resume")
    public void I_proceed_to_the_order_resume() {
        warrantyPage_PO.proceedToOrderResume();
    }


    @Then("I confirm that I am on the cart page")
    public void I_confirm_that_i_am_on_the_cart_page() {
        orderResume_PO.confirmBasketPage();
    }

    @And("I set the product amount {}")
    public void I_set_the_product_amount(String value) {
        orderResume_PO.setProductAmount(value);
    }

    @Then("I confirm the product amount")
    public void I_confirm_the_product_amount() {
        orderResume_PO.confirmMatchingQuantities();
    }




}
