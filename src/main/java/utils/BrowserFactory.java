package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory extends BrowserConstants {
    protected static WebDriver apply() {
        String browser = System.getProperty("browser");
        int chosenBrowser;
        if (browser == null) { chosenBrowser = CHROME; } else {
            chosenBrowser = convert(browser);
        }
        String os = System.getProperty("os.name").substring(0,3).toLowerCase();
        switch (chosenBrowser) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
                if (headless)
                {
                    chromeOptions.addArguments("--headless");
                }
                return new ChromeDriver(chromeOptions);



        }
    }
}
