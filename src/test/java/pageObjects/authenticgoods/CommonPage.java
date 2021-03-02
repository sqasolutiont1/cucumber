package pageObjects.authenticgoods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.authenticgoods.Navigation.TestURLs;
import utils.OurDriver;

import java.time.Duration;
import java.util.List;

public class CommonPage {

    static WebDriver driver;
    Wait<WebDriver> wait;
    String URL = TestURLs.MainURL;


    public CommonPage() {
        if (driver == null) {
            driver = OurDriver.localDriver();
        }
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
    }

    /**
     * Important, KEEP IT. USE IT
     */
    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(driver -> {
            System.out.println("Current Window State       : "
                    + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    public WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement getElement(By locator) {
        return wait.until(driver -> driver.findElement(locator));
    }

    public void sendKeysRedefined(WebElement element, String value, int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.sendKeys(value);
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(driver -> driver.findElements(locator));
    }

    public void quit() {
        driver.close();
    }

    public void navigate() {
        driver.navigate().to(URL);
        waitForPageLoad();
    }

    public void waitFor(String arg0) {
        System.out.println(arg0);
        try {
            Thread.sleep(Integer.parseInt(arg0) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
