package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
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
        tables.search(arg0);
    }

    @Then("I sort by Salary and check if sort is working.")
    public void iSortBySalaryAndCheckIfSortIsWorking(DataTable table) {
       List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
        }
    }

    @When("I pick {string} elements in records per page controller")
    public void iPickElementsInRecordsPerPageController(String numberOfElements) {
        tables.pickPaginationOptions(numberOfElements);
    }

    @And("I will see {string} records on the page")
    public void iWillSeeRecordsOnThePage(String number) {
        int numberOfElements = Integer.parseInt(number);
        int totalAmountOfElements = tables.getTheTotalAmountOfElements();
        if (numberOfElements > totalAmountOfElements) numberOfElements = totalAmountOfElements;

        tables.getNumberOfElementsOnTheTable();
        Assert.assertEquals(tables.getNumberOfElementsOnTheTable(), numberOfElements, "Numbers of the elements on the table and in selector don't match");
    }

    @Then("I check if I see the expected result")
    public void iCheckIfISeeTheExpectedResult(DataTable dataTable) {
        Assert.assertEquals(tables.getAllTheRecordsFromTable(), dataTable.asList(), "no match");
    }

    @When("I search for something")
    public void iSearchForSomething() {
        //tables.printTheTable();
        List<String> testData = tables.readTestData();
        Assert.assertEquals(tables.getTestData(), testData, "Actual data doesn't match the test data");
    }
}
