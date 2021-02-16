package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.LocalDriver;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CommonPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    public CommonPage() {
        this.driver = new LocalDriver().LocalDriver();
        WaitFor();
    }

    public void WaitFor() {
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public WebElement getElement(By locator) {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public void navigate(String arg0) {
        driver.navigate().to(arg0);
    }
}
