package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.driverInitiate;

public class hooks extends driverInitiate {

    @Before
    public void startup() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
