package pageObjects.authenticgoods;

import org.openqa.selenium.By;
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

    public void fillinTextField() {

    }

    public void pressAddNotificationBtn() {

    }

    public void checkErrorMessage() {

    }

    public void readNotification() {

    }
}
