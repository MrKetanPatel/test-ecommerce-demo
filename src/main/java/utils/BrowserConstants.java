package utils;

public class BrowserConstants {
    protected static final int FIREFOX = 1;
    protected static final int CHROME = 2;

    protected static int convert(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            return FIREFOX;
        }
        if (browser.equalsIgnoreCase("chrome")) {
            return CHROME;
        }

        return CHROME;
    }

}
