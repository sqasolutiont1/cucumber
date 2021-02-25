package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Sliders;
import pageObjects.authenticgoods.Wizard;

public class SlidersStepDef {
    Sliders sliders = new Sliders();
    @Given("I navigate to Sliders")
    public void iNavigateToWizard() {
        sliders.navigate(Sliders.URL);
    }

    @Then("I slide to :{string}%")
    public void iSlideTo(String arg0) throws InterruptedException {
        sliders.slide(Integer.parseInt(arg0));
    }
}
