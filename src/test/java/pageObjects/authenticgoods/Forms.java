package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Forms extends CommonPage {

    public Forms() {
        super();
    }

    public void setEmail(String value) {
        By locator = By.id("exampleInputEmail1");
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    public void verifyIfElementXXXXXXXisThere() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getElement(locator).getText(),"Form Components");
    }

    public void attachTheFile(String arg0) {
        By locator = By.id("exampleInputFile");
        getElement(locator).sendKeys(arg0);
    }
}
