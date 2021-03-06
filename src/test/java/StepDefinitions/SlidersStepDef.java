package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Sliders;

public class SlidersStepDef {
    Sliders sliders = new Sliders();

    @Given("I navigate to Sliders")
    public void iNavigateToWizard() {
        sliders.navigateToSliders();
    }

    @Then("I slide to :{string}%")
    public void iSlideTo(String arg0) throws InterruptedException {
        sliders.slide(Integer.parseInt(arg0));
    }

    @When("I move slider from {string} to {string}")
    public void iMoveSliderFromTo(String arg0, String arg1) {
        sliders.moveFromTo(arg0,arg1);
    }
}
