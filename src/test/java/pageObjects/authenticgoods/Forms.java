package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Forms extends CommonPage {

    public void setEmail(String value) {
        By locator = By.id("exampleInputEmail1");
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }
    public void setEmail(boolean isValid) {
        By locator = By.id("exampleInputEmail1");
        String MAIN_PATH = "src/main/resources/";
        File file;
        if (isValid) {
            file = FileUtils.getFile(MAIN_PATH + "validemails.txt");
        } else{
            file = FileUtils.getFile(MAIN_PATH + "invalidemails.txt");
        }

        LineIterator iter = null;
        try {
            iter = FileUtils.lineIterator(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (iter.hasNext()) {
            getElement(locator).clear();
            getElement(locator).sendKeys(iter.next());
            pressSubmitButton();
        }
    }

    public void pressSubmitButton(){
        getClickableElement(By.xpath("//button[normalize-space()='Submit']")).click();
    }


    public void verifyIfElementXXXXXXXisThere() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getElement(locator).getText(), "Form Components");
    }

    public void attachTheFile(String arg0) {
        By locator = By.id("exampleInputFile");
        getElement(locator).sendKeys(arg0);
    }

    public void navigateToForms(){
        navigate();
        getClickableElement(By.cssSelector("[title='Forms']")).click();
        getClickableElement(By.cssSelector("[title='Components']")).click();
    }

}
