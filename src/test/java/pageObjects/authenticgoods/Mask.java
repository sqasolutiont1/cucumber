package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Mask extends CommonPage {

    public void setDate(String value) {
        By locator = By.xpath("/html/body/section/section/div[1]/div/section/div/div/div/div[2]/form/div[1]/div/input");
        getElement(locator).click();
        getElement(locator).sendKeys(value);
    }

    public String getDate() {
        By locator = By.xpath("/html/body/section/section/div[1]/div/section/div/div/div/div[2]/form/div[1]/div/input");
        return getElement(locator).getAttribute("value");
    }
}
