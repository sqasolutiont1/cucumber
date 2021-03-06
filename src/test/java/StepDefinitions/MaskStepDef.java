package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.authenticgoods.Mask;

public class MaskStepDef {
    Mask mask = new Mask();
    @When("Mask. Fill out Date : {string}")
    public void maskFillOutDate(String date) {
        mask.setDate(date);
    }

    @Then("Mask. Date in the field should be : {string}")
    public void maskDateInTheFieldShouldBe(String date) {
       Assert.assertEquals(mask.getDate(),date);
    }
}
