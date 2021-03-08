package pageObjects.authenticgoods;

import org.openqa.selenium.By;

public class Mask extends CommonPage {

    public String getDate() {
        By locator = By.xpath("/html/body/section/section/div[1]/div/section/div/div/div/div[2]/form/div[1]/div/input");
        return getElement(locator).getAttribute("value");
    }

    public void setDate(String value) {
        By locator = By.xpath("/html/body/section/section/div[1]/div/section/div/div/div/div[2]/form/div[1]/div/input");
        getElement(locator).click();
        getElement(locator).sendKeys(value);
    }
}
