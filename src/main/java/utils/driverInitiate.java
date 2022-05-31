package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class driverInitiate {
    // Holds the WebDriver
    public static WebDriver driver = getDriver();

    // Returns driver if instatiated, if not sets driver then returns it
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = browserFactory.apply();
        }
        return driver;
    }

    public static WebElement find(By e) {
        return driver.findElement(e);
    }

}
