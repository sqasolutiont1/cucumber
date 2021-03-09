package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.authenticgoods.Cookies;

public class cookiesSD {
    Cookies cookies = new Cookies();
    @Given("Cookies. I navigate to :{string}")
    public void cookiesINavigateTo(String arg0) {
        cookies.navigate(arg0);
    }


    @Then("I get Cookies")
    public void iGetCookies() {
        cookies.getSomeCookies();
    }
}
