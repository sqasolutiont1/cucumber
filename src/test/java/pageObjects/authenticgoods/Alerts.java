package pageObjects.authenticgoods;

import org.apache.poi.ss.formula.functions.Na;
import org.apache.tools.ant.taskdefs.WaitFor;
import pageObjects.authenticgoods.Navigation.Navigation;

public class Alerts extends CommonPage {
Navigation navigation = new Navigation();
    public Alerts() {
        super();
    }

    public void navigateToAlertPage() {
        navigation.pressOnAlerts();
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
