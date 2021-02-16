package pageObjects.authenticgoods;

import org.openqa.selenium.By;

public class Forms extends CommonPage {

    public Forms() {
        super();
    }

    public void setEmail(String value) {
        By locator = By.id("exampleInputEmail1");
        getElement(locator).sendKeys(value);
    }

}
