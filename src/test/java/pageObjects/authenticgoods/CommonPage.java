package pageObjects.authenticgoods;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;
import org.testng.log4testng.Logger;
import pageObjects.authenticgoods.Navigation.TestURLs;
import utils.OurDriver;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonPage {

    static WebDriver driver;
    Wait<WebDriver> wait;
    String URL = TestURLs.MainURL;

    public CommonPage() {
        if (driver == null){
            driver = new OurDriver().localDriver();
        }
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    /**
     * Important, KEEP IT. USE IT
     */
    public void waitForPageLoad() {
        //Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        try{
            wait.until(driver -> {
                System.out.println("Current Window State       : "
                        + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            });
        } catch (TimeoutException timeoutException){
            getScreenShot();
            Logger.getLogger(CommonPage.class).fatal(timeoutException.getMessage());
        }
    }

    public WebElement getClickableElement(By locator) {
        WebElement webElement = null;
        try{
            webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (TimeoutException timeoutException){
            getScreenShot();
            saveToLogFile(timeoutException.getMessage());
            Logger.getLogger(CommonPage.class).fatal(timeoutException.getMessage());
        }
        return webElement;
    }

    public WebElement getElement(By locator) {
        WebElement webElement = null;
        try {
            webElement = wait.until(driver -> driver.findElement(locator));
        }catch (TimeoutException timeoutException){
            getScreenShot();
            Logger.getLogger(CommonPage.class).fatal(timeoutException.getMessage());
        }
        return webElement;
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(driver -> driver.findElements(locator));
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void navigate() {
        saveToLogFile("Navigating to the webpage: " + URL);
        driver.navigate().to(URL);
        saveToLogFile("Navigated: " + URL);
        saveToLogFile("Waiting for page to load: " + URL);
        waitForPageLoad();
        saveToLogFile("Page loaded: " + URL);

    }
    public void navigate(String url) {
        driver.navigate().to(url);
        waitForPageLoad();
    }

    public void waitFor(String arg0) {
        System.out.println(arg0);
        try {
            Thread.sleep(Integer.parseInt(arg0) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void testImages() {
        // Storing all elements with img tag in a list of WebElements
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on the Page are " + images.size());

        //checking the links fetched.
        for(int index=0;index<images.size();index++)
        {
            WebElement image= images.get(index);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
            verifyLinks(imageURL);

            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
        }
    }

    public void verifyLinks(String linkUrl)
    {
        try
        {
            java.net.URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }

    public void getScreenShot() {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory with name "screenshot.png"
        try {
            FileHandler.copy(scrFile, new File("src/test/screenshots/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();

        if (cookies.size() == 0) { // To support FF and IE
            String cookiesString = (String) ((JavascriptExecutor) driver).executeScript("return document.cookie");
            cookies = parseBrowserCookies(cookiesString);
        }
        String my_new_str = cookies.toString().replace(";", ";\n");

        System.out.println(my_new_str);
    }

    private Set<Cookie> parseBrowserCookies(String cookiesString) {
        Set<Cookie> cookies = new HashSet<>();

        if (StringUtils.isBlank(cookiesString)) {
            return cookies;
        }

        Arrays.asList(cookiesString.split("; ")).forEach(cookie -> {
            String[] splitCookie = cookie.split("=", 2);
            cookies.add(new Cookie(splitCookie[0], splitCookie[1], "/"));
        });

        return cookies;
    }

    public void saveToLogFile(String errorMessagesData) {
        File fileToWrite1 = FileUtils.getFile("src/test/logs/" + "log.txt");
        try {
            FileUtils.write(fileToWrite1, errorMessagesData+"\n", StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean isInvisible(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Boolean isInvisible(WebElement webElement){
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
