package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.authenticgoods.Navigation.Navigation;

public class Modals extends CommonPage {
    Navigation navigation = new Navigation();

    public void hoverOverButton1(){
        Actions actions = new Actions(driver);
        WebElement element = getClickableElement(By.cssSelector("button[tooltip-placement='right']"));
        actions.moveToElement(element).build().perform();
    }

    public void navigateTo() {
        navigate();
        navigation.navigateToModals();
    }
}
