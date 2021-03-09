package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class OurDriver {
    public WebDriver localDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--silent");
        //options.addArguments("headless");
        options.addArguments("log-level=3");
        options.addArguments("--disable-logging");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
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
