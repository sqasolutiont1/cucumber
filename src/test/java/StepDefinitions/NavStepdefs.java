package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Forms;


public class NavStepdefs {
Forms form = new Forms();

    @Given("Navigate to {string}")
    public void navigateTo(String arg0) {
        form.navigate(arg0);
    }

    @When("I fill in email: {string}")
    public void iFillInEmail(String arg0) {
        form.setEmail(arg0);
    }

    @Then("I fill in password: {string}")
    public void iFillInPassword(String arg0) {
    }

    @And("I press on Submit button")
    public void iPressOnSubmitButton() {
    }
}
