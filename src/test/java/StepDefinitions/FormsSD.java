package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Forms;

public class FormsSD {
    Forms forms = new Forms();
    @When("Forms. I navigate to Forms")
    public void formsINavigateToForms() {
        forms.navigateToForms();
    }

    @When("Forms. I fill in email with data with {string} values from data source")
    public void iFillInEmailWithDataWithValuesFromDataSource(String valid) {
        if (valid.equals("valid")){
            forms.setEmail(true);
        } else if (valid.equals("invalid")){
            forms.setEmail(false);
        } else {
            System.out.println("Wrong input");
        }
    }

    @Then("Forms. I fill out password:{string}")
    public void formsIFillOutPassword(String arg0) {
        forms.filloutPassword(arg0);
    }

    @And("Forms. I attach file:{string} to the form")
    public void formsIAttachFileToTheForm(String arg0) {
        forms.attachTheFile(arg0);
    }
}
