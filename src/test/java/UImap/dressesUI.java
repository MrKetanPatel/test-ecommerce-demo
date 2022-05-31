package UImap;

import org.openqa.selenium.By;

public class dressesUI {

    public static By dressesTab = By.linkText("DRESSES");

    public static By priseList = By.cssSelector(".right-block [itemprop = 'price']");

    public static By addToCartButton = By.xpath("//p[@id='add_to_cart']/button");

    public static By addToCartSuccessMessage = By.xpath("//*[contains(@class, 'icon-ok')]/..");
}
