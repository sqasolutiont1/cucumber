package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.bouncycastle.math.raw.Mod;
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
}
