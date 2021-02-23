package StepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Forms;

public class MyStepdefs {
    Forms form = new Forms();

    @When("I fill in email: '(.*)'$")
    public void iFillInEmailEmail(String value) {
        form.setEmail(value);
    }
}
