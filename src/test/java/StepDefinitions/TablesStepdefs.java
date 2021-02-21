package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
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
    public void iSortBySalaryAndCheckIfSortIsWorking() {
        //we clicked
        //we are assuming that soring happining in .... direction.
        //and then we should read all teh values in the column !!!!!
        //and then we want to make sure and each next element in the List is more than the previous element. GOOGLE IT!!
        // you shoudl sort values by yourself and then check if your sorting matches their sorting https://www.geeksforgeeks.org/sorting-in-java/
    }
}
