package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class OurDriver {
    public static WebDriver localDriver(){
        WebDriverManager.chromedriver().setup();
//        // Create object of HashMap Class as shown below.
//        Map<String, Object> prefs = new HashMap<>();
//
//        // Set the notification setting it will override the default setting.
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//
//        // Create object of ChromeOption class.
//        ChromeOptions options = new ChromeOptions();
//
//        // Set the experimental option.
//        options.setExperimentalOption("prefs", prefs);
//
//        // Open chrome browser.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        return new ChromeDriver(options);
    }

    public RemoteWebDriver remoteDriver() {
        RemoteWebDriver webDriver = null;
        ChromeOptions options = new ChromeOptions();
        try {
            webDriver = new RemoteWebDriver(new URL("http://10.0.1.57:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return webDriver;
    }
}
