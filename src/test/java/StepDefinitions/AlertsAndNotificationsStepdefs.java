package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.authenticgoods.Alerts;

import java.util.List;
import java.util.Map;

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

    @Then("I read the notification message : {string}")
    public void iReadTheNotificationMessage(String messageText) {
        String txt = alerts.readNotification(messageText);
        System.out.println(txt);
       Assert.assertEquals(txt, messageText, "Wrong message on the notification");
    }

    @Then("I fill out and check notification message")
    public void iFillOutNotificationMessage(DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        for (String messageText :  rows) {
            alerts.fillinTextField(messageText);
            alerts.pressAddNotificationBtn();
            Assert.assertEquals(alerts.readNotification(messageText), messageText, "Wrong message on the notification");
        }
    }
}
