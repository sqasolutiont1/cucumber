package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Mask extends CommonPage {

    public void setDate(String value) {
        By locator = By.xpath("//div[@class='panel panel-default']//div[1]//div[1]//input[1]");
        getElement(locator).click();
        getElement(locator).sendKeys(Keys.HOME + value);
    }

    public String getDate() {
        By locator = By.xpath("//div[@class='panel panel-default']//div[1]//div[1]//input[1]");
        return getElement(locator).getAttribute("value");
    }
}
