package pageObjects.authenticgoods;

import org.openqa.selenium.By;

public class Sliders extends CommonPage {

    public Sliders() {
        super();
    }

    public void slide(int percent){
        By locator = By.cssSelector("[class='slider-selection']");
        String style = "style='left: 0%; width: 54.8%;'";
    }
}
