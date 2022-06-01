package steps;

import UImap.DressesUI;
import UImap.ProductUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import pages.Navigation;
import utils.DriverInitiate;


import java.util.ArrayList;

public class DressesPageStepsDef {
    DressesUI dress = new DressesUI();
    ProductUI product = new ProductUI();

    @Given("the browser is initiated with url {string}")
    public void theBrowserIsInitiatedWithUrl(String dressUI) {
        Navigation.navigate_Url(DriverInitiate.getProperties(dressUI));
    }


    @When("I Click on the Dresses Menu")
    public void i_click_on_the_dresses_menu() {
        dress.clickDresses();
    }

    @Then("Select the highest price item")
    public void select_the_highest_price_item() throws InterruptedException {

        ArrayList<Float> sortedList = dress.getSortedPriceList();

        try {
            dress.selectProduct(String.valueOf(sortedList.get(sortedList.size() - 1)));

        } catch (Exception e) {
            throw new RuntimeException("Exception cause due to : " + e);
        }
    }

    @Then("Add the selected highest price item to the cart")
    public void add_the_selected_highest_price_item_to_the_cart() {
        try {
            product.clickAddCartButton();
        } catch (Exception e) {
            throw new RuntimeException("Exception cause due to : " + e);
        }
    }

    @Then("the message displayed {string}")
    public void the_message_displayed(String successAddToCartMessage) {
        Assert.assertTrue(product.getAddToCartSuccessMessage().contains(successAddToCartMessage));
    }


}
