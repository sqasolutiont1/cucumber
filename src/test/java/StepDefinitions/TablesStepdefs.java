package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Tables;

public class TablesStepdefs {
    Tables tables = new Tables();
    @Given("Navigate to tables")
    public void navigateToTables() {
        tables.navToTables();
    }

    @When("I check if I'm on the tables page")
    public void iCheckIfIMOnTheTablesPage() {
        tables.checkIfOnTheCorrectPage();
    }
    @After
    public void close(){
        tables.quit();
    }

    @Then("I check the list of the elements in the Header")
    public void iCheckTheListOfTheElementsInTheHeader() {
        tables.checkHeader();
    }

    @Then("I check the list of the elements in the Header: {String},{String},{String},{String}")
    public void iCheckTheListOfTheElementsInTheHeaderNumberFNLNUN(String arg0, String arg1, String arg2, String arg3) {
        System.out.println(arg0+arg1+arg2+arg3);
    }
}
