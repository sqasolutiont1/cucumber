package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.authenticgoods.Navigation.Navigation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tables extends CommonPage {
    String header = "Data Tables";
    String[] headerContents = {"Name", "Position", "Office", "Age", "Start date", "Salary"};
    Navigation navigation = new Navigation();
    private String basicHeader = "Basic Tables";

    public Tables() {
        super();
    }

    public void navToTables() {
        navigate();
        navigation.pressOnDataTables();
    }

    public void checkIfOnTheCorrectPage() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getClickableElement(locator).getText(), header);
    }

    public void checkHeader() {
        By locator = By.cssSelector("[role = 'row'] > th");
        /**
         * we build the first list base on the values we read from teh webpage
         */
        List<String> actualData = new ArrayList<>();
        for (int i = 0; i < getElements(locator).size(); i++) {
            actualData.add(getElements(locator).get(i).getText());
        }
        /**
         * this is our reference data set. against which we are going to assert if whatever
         * we got form teh webpage is what we were expecting.
         */
        /**
         * Cast array to List
         */
        List testData = Arrays.asList(headerContents);
        /**
         * And this is were the test happens
         */
        Assert.assertEquals(actualData, testData);
    }

    public void printTheTable() {
        /**
         * This method will set the amount of the elements on teh table to the given number
         */
        pickPaginationOptions("100");
        By tableLocator = By.cssSelector("[id='example'] >tbody >tr");
        waitForPageLoad();
        List<WebElement> rows = getElements(tableLocator);
        List<String> tableContent = new ArrayList<>();
            for (WebElement element : rows) {
                tableContent.add(element.getText());
            }

        System.out.println(tableContent);
        try {
            FileUtils.writeLines(new File("src/test/resources/output.txt"), tableContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pickPaginationOptions(String numberOfElements) {
        By locator = By.cssSelector("[name='example_length']");
        Select selector = new Select(getElement(locator));
        selector.selectByValue(numberOfElements);
        waitForPageLoad();
    }

    public int getNumberOfElementsOnTheTable() {
        By tableLocator = By.cssSelector("[id='example'] >tbody >tr");
        return getElements(tableLocator).size();
    }

    public int getTheTotalAmountOfElements() {
        By locator = By.cssSelector("[class='dataTables_info']");
        String text = getClickableElement(locator).getText();
        return Integer.parseInt(text.substring(19, 21));
    }

    public void search(String value) {
        By locator = By.cssSelector("[type='search']");
        WebElement element = getClickableElement(locator);
        element.clear();
        element.sendKeys(value);
        waitForPageLoad();
    }

    public List<String> getAllTheRecordsFromTable() {
        By Locator = By.cssSelector("[id='example'] >tbody >tr >td");
        List<WebElement> cells = getElements(Locator);
        List<String> textFromCells = new ArrayList<>();
        for (WebElement element : cells){
            textFromCells.add(element.getText());
        }
        return textFromCells;
    }

    public List<String> getTestData() {
        pickPaginationOptions("100");
        By tableLocator = By.cssSelector("[id='example'] >tbody >tr");
        waitForPageLoad();
        List<WebElement> rows = getElements(tableLocator);
        List<String> tableContent = new ArrayList<>();
        for (WebElement element : rows) {
            tableContent.add(element.getText());
        }
        return tableContent;
    }

    public List<String> readTestData() {
        List<String> lines = new ArrayList<>();
        Charset cs= StandardCharsets.UTF_8;
        try {
            lines = FileUtils.readLines(new File("src/test/resources/output.txt"), cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void navToBasicTables() {
        navigate();
        navigation.pressOnBasicTables();
    }

    public void checkBasicTablesHeader() {
        By locator = By.xpath("//h1[normalize-space()='Basic Tables']");
        Assert.assertEquals(getClickableElement(locator).getText(), basicHeader);
    }
    List<List<String>> actualData = new ArrayList<List<String>>();

    public List<List<String>> readColumns() {
        /**
         * Creating the selector for rows. All teh rows of the table.
         */
        By rowLocator = By.cssSelector("div.row:nth-child(1) > div.col-md-6:nth-child(1) > div.panel.panel-default:nth-child(1) > div.panel-body:nth-child(2) > table.table:nth-child(1) > tbody > tr");

        /**
         * Getting these rows as elements.
         */
        List<WebElement> rowElement = getElements(rowLocator);
        /**
         * Creating List to store data from Rows.
         */
        List<String> dataFromRow = new ArrayList<>();
        /**
         * Creating List of elements for cells.
         */
        List<WebElement> listOfCells;
        /**
         * Loop through rows, by changing the index of the row.
         */
        for (int i=0; i<rowElement.size(); i++){
            /**
             * changing this index of the row.
             */
            By genericLocator = By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+(i+1)+"]/td");
            /**
             * getting the list of the cells for the specific row.
             */
            listOfCells = getElements(genericLocator);
            /**
             * Looping through all the cells.
             */
            for (int j =0; j<listOfCells.size();j++){
                /**
                 * Read data from each cell. And add data to List
                 */
                dataFromRow.add(listOfCells.get(j).getText());
            }
            /**
             * Add List ot the LIst of List
             */
            actualData.add(new ArrayList<>(dataFromRow));
            /**
             * Clearing the List with old values so we could add new data.
             */
            dataFromRow.clear();
        }
        return actualData;
    }
}
