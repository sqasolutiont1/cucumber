package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.authenticgoods.Navigation.Navigation;

public class Alerts extends CommonPage {
    Navigation navigation = new Navigation();

    public void navigateToAlertPage() {
        navigate();
        navigation.pressOnAlertsMenuItem();
    }

    public String getHeader() {
        waitForPageLoad();
        return getClickableElement(By.cssSelector("h1")).getText();
    }

    public void fillinTextField(String messageText) {
        By locator = By.cssSelector("[ng-model='newNotification']");
        WebElement element = getClickableElement(locator);
        element.clear();
        element.sendKeys(messageText);
    }

    public void pressAddNotificationBtn() {
        By locator = By.cssSelector("[ng-click='add(newNotification)']");
        getClickableElement(locator).click();
    }

    public void checkErrorMessage() {

    }

    public String readNotification(String messageText) {
        By locator = By.xpath("//*[@class='ng-scope ng-binding'][contains(text(),'" + messageText + "')]");
        return getClickableElement(locator).getText();
    }
}
