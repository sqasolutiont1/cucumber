package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Forms;


public class NavStepdefs {
Forms form = new Forms();

    @Given("Navigate to {string}")
    public void navigateTo(String arg0) {
        form.navigate();
    }

    @When("I fill in email: {string}")
    public void iFillInEmail(String value) {
        form.setEmail(value);
    }

    @Then("I fill in password: {string}")
    public void iFillInPassword(String arg0) {
    }

    @And("I press on Submit button")
    public void iPressOnSubmitButton() {
    }

    @And("I verify that I see some kind of element")
    public void iVerifyThatISeeSomeKindOfElement() {
        form.verifyIfElementXXXXXXXisThere();
    }

    @Then("I attach the file: {string}")
    public void iAttachTheFile(String arg0) {
        form.attachTheFile(arg0);
    }



    @When("Fillut the first page with <FirstName>, <LastName>")
    public void fillutTheFirstPageWithFirstNameLastName() {

    }
}
