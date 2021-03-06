package pageObjects.authenticgoods;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

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
        String argumentsValue = elementSlider.getAttribute("style");

        String initValue = StringUtils.substringBefore(argumentsValue.substring(argumentsValue.indexOf("width: ") + 6), "%;");
        /*
        if init value is more than target value -> this is what we got at the start.
        If init value id equal to target -> nothing supposed to be done
        If init value is less than target -> we should decrease , not increase the value which we sending to arguments
        if init value doesn't match starting value -> we should adjust it. and make this adjustment smooth. as usual.
         */
        double dArg0 = Double.parseDouble(arg0);
        double dArg1 = Double.parseDouble(arg1);
        double step = 10;

        if (initValue.equals(Double.toString(dArg1))){
            System.out.println("do nothing");
        }

        for (double i=dArg0; i<=dArg1 ; i=i+step){
            dArg0 = dArg0 + step;
            executeTheScript(elementSlider,elementHandle, js,dArg0);
        }

        for(double i=dArg0; i>=dArg1 ; i=i-step){
            executeTheScript(elementSlider,elementHandle, js,dArg0);
            dArg0 = dArg0 - step;
        }
    }

    private void getTheLoop(){

    }
    private void executeTheScript(WebElement elementSlider, WebElement elementHandle, JavascriptExecutor js, double dArg0){
        js.executeScript("arguments[0].setAttribute('style', 'top: " + dArg0 + "%')", elementSlider);
        js.executeScript("arguments[0].setAttribute('style', 'top: " + dArg0 + "%')", elementHandle);
        System.out.println(dArg0);
    }
    /**
     * get the list of the sliders
     * make a loop through this list
     * for each element of this list execute function which will move the slider to the required position
     * here is the trick - by default all the elements will be moving one by one, not in the same time
     */
}
