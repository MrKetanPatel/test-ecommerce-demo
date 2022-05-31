package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory extends browserConstants{
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
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case HEADLESSCHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/java/utils/drivers/");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }
}
