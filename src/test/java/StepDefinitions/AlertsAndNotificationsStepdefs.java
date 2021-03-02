package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.authenticgoods.Alerts;

public class AlertsAndNotificationsStepdefs {
    Alerts alerts = new Alerts();

    @Given("I navigate to alerts and notifications")
    public void iNavigateToAlertsAndNotifications() {
        alerts.navigateToAlertPage();
    }

    @After
    public void closeAll(){
        alerts.quit();
    }

    @When("I am on the Alert And notifications Page")
    public void iAmOnTheAlertAndNotificationsPage() {
        Assert.assertEquals(alerts.getHeader(),"Alerts & Notifications", "Wrong Header/ Maybe even wrong page");
    }

    @Then("I fill out new notification message: {string}")
    public void iFillOutNewNotificationMessage(String messageText) {
        alerts.fillinTextField(messageText);
        alerts.pressAddNotificationBtn();
    }
}
