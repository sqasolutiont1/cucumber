package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Wizard;

public class WizardSD {
    Wizard wizard = new Wizard();
    @When("Fillout the first page with: {string} and {string}")
    public void filloutTheFirstPageWithAnd(String arg0, String arg1) {
        wizard.setFirstName(arg0);
        wizard.setLastName(arg1);
    }

    @Given("I navigate to Wizard")
    public void iNavigateToWizard() {
        wizard.navigate(Wizard.URL);
    }

    @After
    public void close(){
        wizard.quit();
    }

    @Then("I press Next Button")
    public void iPressNextButton() {
        wizard.pressNextButton();
    }
}
