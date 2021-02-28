package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
        wizard.navigate();
    }



    @Then("I press Next Button")
    public void iPressNextButton() {
        wizard.pressNextButton();
    }

    @When("I Fillout the second Page with: {string}, {string}, {string}, {string}")
    public void iFilloutTheSecondPageWith(String arg0, String arg1, String arg2, String arg3) {
        wizard.setAddress(arg0);
        wizard.setCity(arg1);
        wizard.setState(arg2);
        wizard.setZIP(arg3);
    }

    @And("I will wait for {string} seconds")
    public void iWillWaitForSeconds(String arg0) {
        wizard.waitFor(arg0);
    }

    @And("I verify that I an on the correct Step and I see the label: {string}")
    public void iVerifyThatIAnOnTheCorrectStepAndISeeTheLabel(String arg0) {
        wizard.verifyStepLabel(arg0);
    }

    @When("I check First Name, I see: {string}")
    public void iCheckFirstNameISee(String arg0) {
        wizard.checkFirstName(arg0);
    }
}
