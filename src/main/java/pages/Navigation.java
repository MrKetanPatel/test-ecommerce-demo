package pages;

import utils.DriverInitiate;

public class Navigation extends DriverInitiate {

    public static void navigate_Url(String url)
    {
        driver.get(url);
    }
}
