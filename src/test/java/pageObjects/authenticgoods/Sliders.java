package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Sliders extends CommonPage {

    public static final String URL = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/index.html#/ui/sliders-progress";

    public Sliders() {
        super();
    }

    public void slide(int percent) throws InterruptedException {
        By locator = By.xpath("//div[@class='slider slider-default']//div[@class='slider slider-vertical']//div[@class='slider-selection']");
        By handle = By.xpath("//div[@class='slider slider-default']//div[@class='slider slider-vertical']//div[@class='slider-handle round']");
//TODO:
        /**
         * initial percent.
         * passed percent through the argument
         */
        String style = "style='left: 0%; width: 54.8%;'";
        /**
         * if percent is less than initialPercent -> decrease
         * if percent is more than initialPercent -> increase
         */

        /**
         * make loop which will gracefully move the slider and handler
         */

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementSlider = getClickableElement(locator);
        WebElement elementHandle = getClickableElement(handle);
        String initialPercent = elementSlider.getAttribute("style");
        System.out.println("initialPercent:" + initialPercent);
        /**
         * parse teh string to get width value.
         */
        System.out.println(initialPercent.substring(initialPercent.indexOf("width: ") + 7));
        /**
         * remove %;
         */

        js.executeScript("arguments[0].setAttribute('style', 'width: 10.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 10.0%')", elementHandle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('style', 'width: 20.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 20.0%')", elementHandle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('style', 'width: 30.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 30.0%')", elementHandle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('style', 'width: 40.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 40.0%')", elementHandle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('style', 'width: 50.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 50.0%')", elementHandle);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('style', 'width: 60.0%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'left: 60.0%')", elementHandle);
        Thread.sleep(10000);
    }

    public void navigateToSliders() {
        navigate();
        getClickableElement(By.cssSelector("[title='UI Elements']")).click();
        getClickableElement(By.cssSelector("[title='Sliders & Progress']")).click();
        waitForPageLoad();
    }

    public void moveFromTo(String arg0, String arg1) {
        By locator = By.xpath("//div[@class='slider slider-default']//div[@class='slider slider-vertical']//div[@class='slider-selection']");
        By handle = By.xpath("//div[@class='slider slider-default']//div[@class='slider slider-vertical']//div[@class='slider-handle round']");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementSlider = getClickableElement(locator);
        WebElement elementHandle = getClickableElement(handle);
        String initialPercent = elementSlider.getAttribute("style");

        System.out.println("initialPercent:" + initialPercent);
        double dInit = Double.parseDouble(initialPercent);
        double dArg0 = Double.parseDouble(arg0);
        double dArg1 = Double.parseDouble(arg1);
        double step = 0.1;
        for (double i=dArg0; i<dArg1 ; i=i+step){
            dArg0 = dArg0 + step;
            js.executeScript("arguments[0].setAttribute('style', 'top: " + dArg0 + "%')", elementSlider);
            js.executeScript("arguments[0].setAttribute('style', 'top: " + dArg0 + "%')", elementHandle);
            System.out.println(dArg0);
        }

    }
}
