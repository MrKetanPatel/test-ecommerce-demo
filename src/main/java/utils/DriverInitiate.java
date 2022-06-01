package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class DriverInitiate {
    // Holds the WebDriver
    public static WebDriver driver = getDriver();

    // Returns driver if instatiated, if not sets driver then returns it
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.apply();
        }
        return driver;
    }

    public static String getProperties(String key) {
        String val = null;
        try (InputStream input = new FileInputStream("src/test/resources/config/test.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            val = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return val;
    }
}
