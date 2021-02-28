package pageObjects.authenticgoods;

import org.apache.poi.ss.formula.functions.Na;
import pageObjects.authenticgoods.Navigation.Navigation;

public class Alerts extends CommonPage {
Navigation navigation = new Navigation();
    public Alerts() {
        super();
    }

    public void navigateToAlertPage() {
        navigation.new UIElementsMenu().pressOnAlerts();
    }

    public void checkHeader() {

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
