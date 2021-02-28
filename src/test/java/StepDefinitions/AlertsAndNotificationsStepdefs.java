package StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import pageObjects.authenticgoods.Alerts;

public class AlertsAndNotificationsStepdefs {
    Alerts alerts = new Alerts();

    @Given("I navigate to alerts and notifications")
    public void iNavigateToAlertsAndNotifications() {
        alerts.navigateToAlertPage();
    }
}
