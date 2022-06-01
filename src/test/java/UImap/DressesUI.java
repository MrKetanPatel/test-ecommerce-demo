package UImap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.DriverInitiate.driver;

public class DressesUI {

    public static By dressesTab = By.linkText("DRESSES");

    public static By priseList = By.cssSelector(".right-block [itemprop = 'price']");

    String maxP_xpath =  "//div[@class='right-block']//span[contains(text(),'$%s')]/../../h5/a";


    public static By addToCartSuccessMessage = By.xpath("//*[contains(@class, 'icon-ok')]/..");

    public ArrayList<Float> getSortedPriceList(){
        List<WebElement> pricesList = driver.findElements(DressesUI.priseList);
        ArrayList<Float> priceListSorted = new ArrayList<>();

        pricesList.forEach(p -> priceListSorted.add(Float.parseFloat(p.getText().replaceAll("\\$", "").trim())));
        Collections.sort(priceListSorted);
        return priceListSorted;
    }

    public void clickDresses(){
        driver.findElement(DressesUI.dressesTab).click();
    }

    public void selectProduct(String cost){
        String xpath = String.format(maxP_xpath, cost);
        driver.findElement(By.xpath(xpath)).click();
    }
}
