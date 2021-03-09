package pageObjects.authenticgoods;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class Wizard extends CommonPage {
    public static String URL = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/#/forms/wizard/step_one";
    public Wizard() {
        super();
    }

    public void setFirstName(String value) {
        saveToLogFile("Setting first name as: " + value);

        Logger.getLogger(CommonPage.class).info("Setting first name as: " + value);
        By locator = By.name("FirstName");
        saveToLogFile("Clearing the text field" + locator.toString());

        getClickableElement(locator).clear();
        saveToLogFile("Clicking");
        saveToLogFile("Filling out: " + value);
        getClickableElement(locator).sendKeys(value);
        saveToLogFile("Filled in: " + value);
    }

    public void setLastName(String value) {
        By locator = By.name("lastName");
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    public void pressNextButton() {
        By locator = By.cssSelector("[class='btn btn-primary ng-scope']");
        getClickableElement(locator).click();
    }

    public void setAddress(String value) {
        By locator = By.name("streetAddress");
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    public void setCity(String value) {
        By locator = By.name("city");
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    public void setState(String value) {
        By locator = By.name("state");
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    public void setZIP(String value) {
        By locator = By.name("postalCode");
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    public void verifyStepLabel(String value) {
        waitForPageLoad();
        By locator = By.xpath("//h2[normalize-space()='" + value + "']");
        Assert.assertTrue(getClickableElement(locator).isDisplayed(), "The label is not match");
    }

    public void checkFirstName(String arg0) {
        By locator = By.xpath("//*[normalize-space()='First Name:']/../p");
        try{
            Assert.assertEquals(getClickableElement(locator).getText(), arg0, "First name doesn't match: " + " getting " +
                    " this: " + getElement(locator).getText() + " instead of " + arg0);
        }catch (AssertionError assertionError){
            getScreenShot();
            Assert.fail(assertionError.getMessage());
        }

    }

    public void navigateToWizardPage() {
        getClickableElement(By.cssSelector("[title='Forms']")).click();
        getClickableElement(By.cssSelector("[title='Wizard']")).click();
        waitForPageLoad();
    }

    public void pressSubmitBtn() {
        getClickableElement(By.cssSelector("button[class='btn btn-primary ng-scope']")).click();
    }

    public void acceptAlert() {
        /**
         *
         */

        driver.switchTo().alert().accept();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void checkLastName(String arg0) {
        By locator = By.xpath("//*[normalize-space()='Last Name:']/../p");
        Assert.assertEquals(getClickableElement(locator).getText(), arg0, "Last name doesn't match: " + " getting " +
                " this: " + getElement(locator).getText() + " instead of " + arg0);
    }

    public void checkAddress(String streetAddress,String city,String state,String zip) {
        By locator = By.xpath("//*[normalize-space()='Address:']/../p");
        Assert.assertEquals(getClickableElement(locator).getText(), streetAddress+ "\n" +
                city + ", " + state + " " + zip, "Address doesn't match: " + " getting " +
                " this: " + getElement(locator).getText() + " instead of " + streetAddress);
    }
}
