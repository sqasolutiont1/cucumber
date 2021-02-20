package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class Tables extends CommonPage {
    String url = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/tables/basic";
    String header = "Basic Tables";
    String[] headerContents = {"#", "First Name", "Last Name", "Username"};

    public Tables() {
        super();
    }

    public void navToTables() {
        navigate(url);
    }

    public void checkIfOnTheCorrectPage() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getClickableElement(locator).getText(), header);
    }

    public void checkHeader() {
        By locator = By.xpath("//body//section[@id='main-wrapper']//div[@class='ng-scope']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[2]//table[1]//thead[1]//tr[1]/th");
        /**
         * we build the first list base on the values we read from teh webpage
         */
        List<String> actualData = new ArrayList<String>();
        for (int i = 0; i < getElements(locator).size(); i++) {
            actualData.add(getElements(locator).get(i).getText());
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
        By tableLocator = By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr");
        int rows = getElements(tableLocator).size();
        Map<Integer, List<String>> tableContent = new LinkedHashMap<>();

        for (int i=1; i<=rows; i++){
            By locator = By.xpath("/html[1]/body[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+i+"]/td");
            for (WebElement element: getElements(locator)){
                System.out.println(element.getText());
            }
        }
    }
}
