package steps;

import UImap.dressesUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.navigation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.driverInitiate.driver;

public class dressesPageStepsDef {

    @Given("the browser is initiated with url {string}")
    public void theBrowserIsInitiatedWithUrl(String url) {
        navigation.navigate_Url(url);
    }


    @When("I Click on the Dresses Menu")
    public void i_click_on_the_dresses_menu() {
        driver.findElement(dressesUI.dressesTab).click();
    }

    @Then("Select the highest price item")
        public static void select_the_highest_price_item() throws InterruptedException {
try {
    List<WebElement> pricesList = driver.findElements(dressesUI.priseList);
    ArrayList<Float> priceListSorted = new ArrayList<>();

    pricesList.forEach(p -> priceListSorted.add(Float.parseFloat(p.getText().replaceAll("\\$", "").trim())));
    Collections.sort(priceListSorted);

    String maxP_xpath = "//div[@class='right-block']//span[contains(text(),'$" + priceListSorted.get(priceListSorted.size() - 1) + "')]/../../h5/a";
    driver.findElement(By.xpath(maxP_xpath)).click();
} catch (Exception e) {
    throw new RuntimeException("Exception cause due to : "+e);
}


  }
    @Then("Add the selected highest price item to the cart")
    public void add_the_selected_highest_price_item_to_the_cart() {
        try {
            driver.findElement(dressesUI.addToCartButton).click();
        } catch (Exception e) {
            throw new RuntimeException("Exception cause due to : " + e);
        }
    }
    @Then("the message displayed {string}")
    public void the_message_displayed(String successAddToCartMessage) {
        try{
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesUI.addToCartSuccessMessage));
        WebElement message = driver.findElement(dressesUI.addToCartSuccessMessage);

        Assert.assertTrue(message.getText().contains(successAddToCartMessage));
    } catch (Exception e) {
            throw new RuntimeException("Exception cause due to : " + e);
        }
    }


}
