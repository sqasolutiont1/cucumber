package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Tables extends CommonPage{
    String url = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/tables/basic";
    String header = "Basic Tables";

    public Tables(){
        super();
    }

    public void navToTables(){
        navigate(url);
    }

    public void checkIfOnTheCorrectPage() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getElement(locator).getText(), header);
    }
}
