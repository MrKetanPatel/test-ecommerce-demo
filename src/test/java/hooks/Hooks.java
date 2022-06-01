package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverInitiate;

public class Hooks extends DriverInitiate {

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
