package pageObjects.authenticgoods.Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.authenticgoods.CommonPage;

public class Navigation extends CommonPage {

    public void pressOnAlertsMenuItem() {
        pressOnUIElementsMenuItem();
        getClickableElement(By.cssSelector("[title='Alerts & Notifications']")).click();
    }

    private void pressOnUIElementsMenuItem() {
        getClickableElement(By.cssSelector("[title='UI Elements']")).click();
    }
}

