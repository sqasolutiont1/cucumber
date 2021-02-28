package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class Tables extends CommonPage {
    String url = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/tables/data";
    String header = "Data Tables";
    String[] headerContents = {"Name", "Position", "Office", "Age", "Start date", "Salary"};

    public Tables() {
        super();
    }

    public void navToTables() {
        navigate();
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
        List<String> actualData = new ArrayList<String>();
        for (int i = 0; i < getElements(locator).size(); i++) {
            actualData.add(getElements(locator).get(i).getText());
            System.out.println(getElements(locator).get(i).getText());
        }
        /**
         * this is our reference data set. agains which we are going to assert if whatever
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
        By tableLocator = By.cssSelector("[id='example'] >tbody >tr");
        int rows = getElements(tableLocator).size();
        Map<Integer, String> tableContent = new LinkedHashMap<>();

        for (int i=1; i<=rows; i++){
            for (WebElement element: getElements(tableLocator)){
                tableContent.put(i, element.getText());
            }
        }
        System.out.println(tableContent);

    }
}
