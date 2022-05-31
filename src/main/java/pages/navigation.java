package pages;

import utils.driverInitiate;

public class navigation extends driverInitiate {

    public static void navigate_Url(String url)
    {
        driver.get(url);
    }
}
