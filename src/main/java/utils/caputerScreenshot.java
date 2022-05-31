package utils;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class caputerScreenshot {

    public static void Screenshot(WebDriver driver, String s) throws IOException {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-yy-hh:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");
        Date date = new Date();
        String screenshotNameFormat = formatter.format(date)+"-";
        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,500,true).withName(screenshotNameFormat).save("./ScreenShots/");
    }


}
