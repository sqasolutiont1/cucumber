package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
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
}
