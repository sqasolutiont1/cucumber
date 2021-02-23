package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.authenticgoods.Tables;

import java.util.List;
import java.util.Map;

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


    @Then("I check the list of the elements in the Header")
    public void iCheckTheListOfTheElementsInTheHeader() {
        tables.checkHeader();
    }

    @And("I print all the table")
    public void iPrintAllTheTable() {
        tables.printTheTable();
    }

    @When("I select {int} elements on the page")
    public void iSelectElementsOnThePage(int arg0) {
        //I have to located the dropdown
        //Press on it
        //Select the elements
        //check if the element was selected

    }

    @Then("I search for: {string}")
    public void iSearchFor(String arg0) {
        //Locate Search field
        // make sure that there is no any data in search field from previous search attempts!!!! .clear()
        //fillout search field
       //wait for search results
        //read the search results
        //Assert: compare the actual with expected


    }

    @Then("I sort by Salary and check if sort is working.")
    public void iSortBySalaryAndCheckIfSortIsWorking(DataTable table) {
       List<List<String>> rows = table.asLists(String.class);
//        List<Map<String, String>> rows1 = table.asMaps(String.class, String.class);
//
//        for (Map<String,String> columns : rows) {
//            System.out.println(columns);
//        }
//
//        for (List<String> columns : rows) {
//            System.out.println(columns);
//            System.out.println(columns.get(0));
//            System.out.println(columns.get(1));
//
//        }
    }
}
