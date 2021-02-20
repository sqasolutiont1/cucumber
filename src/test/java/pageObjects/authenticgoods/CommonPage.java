package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.LocalDriver;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CommonPage {
    WebDriver driver;
    Wait<WebDriver> wait;


    public CommonPage() {
        this.driver = new LocalDriver().LocalDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
    }


    public WebElement getElement(By locator) {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
    }

    public void quit(){
        driver.close();
    }

    public void navigate(String arg0) {
        driver.navigate().to(arg0);
    }
}
