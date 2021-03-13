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

    private void pressOnTablesMenuItem() {
        getClickableElement(By.cssSelector("[title='Tables']")).click();
    }

    public void pressOnDataTables() {
        pressOnTablesMenuItem();
        getClickableElement(By.cssSelector("[title='Data Tables']")).click();
        waitForPageLoad();
    }

    public void navigateToModals() {
        pressOnUIElementsMenuItem();
        getClickableElement(By.cssSelector("[title='Modals & Popups']")).click();
        waitForPageLoad();
    }

    public void pressOnBasicTables() {
        pressOnTablesMenuItem();
        getClickableElement(By.cssSelector("[title='Basic']")).click();
        waitForPageLoad();
    }
}

