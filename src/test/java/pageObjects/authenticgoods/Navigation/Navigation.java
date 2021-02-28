package pageObjects.authenticgoods.Navigation;

import org.openqa.selenium.By;
import pageObjects.authenticgoods.CommonPage;

public class Navigation extends CommonPage {
String URL = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/index.html#";
    public Navigation() {
        super();
        navigate(URL);

    }


    public class UIElementsMenu extends CommonPage {
        private void pressOnUIElementsMenuItem() {
            getClickableElement(By.cssSelector("[title='UI Elements']")).click();
        }

        public void pressOnAlerts() {
            getClickableElement(By.cssSelector("[title='Alerts & Notifications']")).click();
        }
    }
}

