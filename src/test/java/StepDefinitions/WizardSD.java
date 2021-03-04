package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Wizard;

public class WizardSD {
    Wizard wizard = new Wizard();
    @When("Wizard. Fillout the first page with: {string} and {string}")
    public void filloutTheFirstPageWithAnd(String arg0, String arg1) {
        wizard.setFirstName(arg0);
        wizard.setLastName(arg1);
    }

    @Given("Wizard. I navigate to Wizard")
    public void iNavigateToWizard() {
        wizard.navigate();
        wizard.navigateToWizardPage();
    }



    @Then("Wizard. I press Next Button")
    public void iPressNextButton() {
        wizard.pressNextButton();
    }

    @When("Wizard. I Fillout the second Page with: {string}, {string}, {string}, {string}")
    public void iFilloutTheSecondPageWith(String arg0, String arg1, String arg2, String arg3) {
        wizard.setAddress(arg0);
        wizard.setCity(arg1);
        wizard.setState(arg2);
        wizard.setZIP(arg3);
    }

    @And("Wizard. I will wait for {string} seconds")
    public void iWillWaitForSeconds(String arg0) {
        wizard.waitFor(arg0);
    }

    @And("Wizard. I verify that I an on the correct Step and I see the label: {string}")
    public void iVerifyThatIAnOnTheCorrectStepAndISeeTheLabel(String arg0) {
        wizard.verifyStepLabel(arg0);
    }

    @Then("Wizard. I press Submit button")
    public void wizardIPressSubmitButton() {
        wizard.pressSubmitBtn();
    }

    @And("Wizard. I accept the alert")
    public void wizardIAcceptTheAlert() {
        wizard.acceptAlert();
    }

    @Then("Wizard. I check data on last step: {string}, {string}, {string}, {string},{string}, {string}")
    public void wizardICheckDataOnLastStep(String firstName, String lastName, String streetAddress, String city, String state, String zip) {
        wizard.checkFirstName(firstName);
        wizard.checkLastName(lastName);
        wizard.checkAddress(streetAddress,city,state,zip);
    }
}
