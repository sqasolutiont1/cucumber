package StepDefinitions;

import io.cucumber.java.en.Given;
import pageObjects.authenticgoods.Tables;

public class TablesStepdefs {
    Tables tables = new Tables();
    @Given("Navigate to tables")
    public void navigateToTables() {
        tables.navToTables();
    }
}
