package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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
        } else {
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

    public void pressSubmitButton() {
        getClickableElement(By.xpath("//button[normalize-space()='Submit']")).click();
    }


    public void verifyIfElementXXXXXXXisThere() {
        By locator = By.cssSelector("h1");
        Assert.assertEquals(getElement(locator).getText(), "Form Components");
    }

    public void attachTheFile(String arg0) {
        getElement(By.id("exampleInputFile")).sendKeys(System.getProperty("user.dir") + arg0);
    }

    public void attachTheFiles(String arg0) {
        By locator = By.id("file-dropzone");
//        getElement(Locator).click();
//        StringSelection ss = new StringSelection(System.getProperty("user.dir") + arg0);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


        // By locator = By.cssSelector("[class='dropzone ng-pristine ng-valid dz-clickable']");
        getClickableElement(locator).click();
        getElement(locator).sendKeys(System.getProperty("user.dir") + arg0);
    }

    public void navigateToForms() {
        navigate();
        getClickableElement(By.cssSelector("[title='Forms']")).click();
        getClickableElement(By.cssSelector("[title='Components']")).click();
    }

    public void filloutPassword(String arg0) {
        getElement(By.cssSelector("[type='password']")).sendKeys(arg0);
    }

    public void selectMultiple(String arg0, String arg1, String arg2) {
        Select select = new Select(getClickableElement(By.xpath("//div[4]//select[1]")));
        if (select.isMultiple()) {
            select.selectByValue(arg0);
            select.selectByValue(arg1);
            select.selectByValue(arg2);
        }

    }

    public boolean isCheckBox1Checked() {
        By locator = By.cssSelector("div[class='radio'] div[class='icheckbox_flat-grey']");
        getClickableElement(locator).click();
        By checkedLocator = By.cssSelector("div[class='radio'] div[class='icheckbox_flat-grey checked']");
        return getClickableElement(checkedLocator).isDisplayed();
    }

    public void navigateToMultipleFileUpload() {
        navigate();
        getClickableElement(By.cssSelector("[title='Forms']")).click();
        getClickableElement(By.cssSelector("[title='Multiple File Upload']")).click();
    }

    public void navigateMasks() {
        navigate();
        getClickableElement(By.cssSelector("[title='Forms']")).click();
        getClickableElement(By.cssSelector("[title='Mask']")).click();
    }

}
