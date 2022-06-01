package UImap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.DriverInitiate.driver;

public class ProductUI {
    public static By addToCartButton = By.xpath("//p[@id='add_to_cart']/button");
    public void clickAddCartButton (){
        driver.findElement(addToCartButton).click();
    }

    public String getAddToCartSuccessMessage(){
        String msg = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(DressesUI.addToCartSuccessMessage));
            WebElement message = driver.findElement(DressesUI.addToCartSuccessMessage);

         msg = message.getText();
        } catch (Exception e) {
            throw new RuntimeException("Exception cause due to : " + e);
        }
        return msg;
    }


}
