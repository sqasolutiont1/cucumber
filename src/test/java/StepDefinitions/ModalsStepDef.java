package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.authenticgoods.Modals;

public class ModalsStepDef {
    Modals modals = new Modals();
    @Given("Modals. I navigate to Modals")
    public void modalsINavigateToModals() {
        modals.navigateTo();
    }

    @When("Modals. I hover mouse over the button1")
    public void modalsIHoverMouseOverTheButton() {
        modals.hoverOverButton1();
    }

    @Then("Modals. I see the tooltip: {string}")
    public void modalsISeeTheTooltip(String tooltipmessage) {
        Assert.assertEquals(modals.getToolTipForButton1(), tooltipmessage);
    }
}
