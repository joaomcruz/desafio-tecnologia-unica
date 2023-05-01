package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.*;

public class addToBasket_UsingDropDown_Steps extends Base_PO{

        private final HomePage_PO homePage_PO;
        private final OrderResume_PO orderResume_PO;

        private final ProductPage_PO productPage_PO;

        private final SearchPage_PO searchPage_PO;

        private final WarrantyPage_PO warrantyPage_PO;


        public addToBasket_UsingDropDown_Steps(HomePage_PO homePage_PO, OrderResume_PO orderResume_PO,
                                                ProductPage_PO productPage_PO, SearchPage_PO searchPage_PO,
                                                WarrantyPage_PO warrantyPage_PO) {
            this.homePage_PO = homePage_PO;
            this.orderResume_PO = orderResume_PO;
            this.productPage_PO = productPage_PO;
            this.searchPage_PO = searchPage_PO;
            this.warrantyPage_PO = warrantyPage_PO;

        }


        @And("I search for a product clicking on the dropdown")
        public void I_search_for_a_product_clicking_on_the_dropdown() {
            homePage_PO.searchProductDropdown();
        }


        @Then("I confirm that the search returned the searched product from the dropdown")
        public void I_confirm_that_the_search_returned_the_searched_product() {
            searchPage_PO.checkReturnedProductsTextInput(homePage_PO.getProductNameDropdownSearch());
        }


        @Then("I check the product name from the dropdown menu")
        public void I_check_the_product_name_from_the_dropdown_menu() {
            webElementsContainsString(homePage_PO.getProductNameDropdownSearch(), warrantyPage_PO.getProductNameTop(), warrantyPage_PO.getProductNameBottom());
        }






    }


