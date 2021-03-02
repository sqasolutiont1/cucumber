package pageObjects.authenticgoods.Navigation;

import org.openqa.selenium.By;
import pageObjects.authenticgoods.CommonPage;

public class Navigation extends CommonPage {

    public void pressOnAlertsMenuItem() {
        pressOnUIElementsMenuItem();
        getClickableElement(By.cssSelector("[title='Alerts & Notifications']")).click();
        waitForPageLoad();
    }

    private void pressOnUIElementsMenuItem() {
        getClickableElement(By.cssSelector("[title='UI Elements']")).click();
    }
}

