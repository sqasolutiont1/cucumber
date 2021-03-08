package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @When("Forms. I select from multiple element: {string}, {string}, {string}")
    public void formsISelectFromThatElement(String arg0, String arg1, String arg2) {
        forms.selectMultiple(arg0, arg1, arg2);
    }

    @When("Forms. I check if the check box is checked")
    public void formsICheckIfTheCheckBoxIsChecked() {
        forms.isCheckBox1Checked();
    }

    @When("I drag and drop from OS")
    public void iDragAndDropFromOS() {
        forms.attachTheFiles("/src/main/resources/zipFile.zip");
        forms.attachTheFiles("/src/main/resources/validemails.txt");
    }

    @Given("Forms. I navigate to Multiple File Upload")
    public void formsINavigateToMultipleFileUpload() {
        forms.navigateToMultipleFileUpload();
    }
    @Given("Forms. I navigate to Masks")
    public void formsINavigateToMask() {
        forms.navigateMasks();
    }

}
