package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestApiStepDef {
    protected static RequestSpecification request;

    @When("I call Get to receive all {string} entries")
    public void iCallGetToReceiveAllEntries(String api) {
        request = new RequestSpecBuilder().
                setBaseUri("https://api.publicapis.org").
                build();
        Response response = given().
                spec(request).
                when().
                get("/entries");
        int responseCode = response.then().assertThat().extract().response().getStatusCode();
        ArrayList list = response.then().extract().body().jsonPath().get("entries");
        //System.out.println(response.then().extract().body().jsonPath().getMap("entries[0]"));
        List<Map<String, String>> entries = response.jsonPath().getList("entries");
        for (int i=0; i<entries.size(); i++){
            System.out.println(entries.get(i).get(api));
        }

        Assert.assertEquals(responseCode, 200);
    }

    @Then("I call to get health status of the service")
    public void iCallToGetHealthStatusOfTheService() {
        request = new RequestSpecBuilder().
                setBaseUri("https://api.publicapis.org").
                build();
        Response response = given().
                spec(request).
                when().
                get("/health");
        int responseCode = response.then().assertThat().extract().response().getStatusCode();
        Assert.assertEquals(responseCode, 200);

        Assert.assertTrue(response.then().extract().body().jsonPath().get("alive"));
    }

    @When("I call to get all the animals")
    public void iCallToGetAllTheAnimals() {
        request = new RequestSpecBuilder().
                setBaseUri("https://api.publicapis.org").
                build();
        Response response = given().
                spec(request).
                when().
                get("/entries?category=animals&https=true");
        int responseCode = response.then().assertThat().extract().response().getStatusCode();
        Assert.assertEquals(responseCode, 200);
        List<Map<String, String>> entries = response.jsonPath().getList("entries");
        for (int i=0; i<entries.size(); i++){
            System.out.println(entries.get(i).get("Category"));
            Assert.assertEquals(entries.get(i).get("Category"),"Animals");
        }

    }

    @When("I call for the random joke, I get it")
    public void iCallForTheRandomJokeIGetIt() {
        request = new RequestSpecBuilder().
                addHeader("x-rapidapi-key","ab88a28a99msh5911ffd6faa9e68p1dfe95jsn0573c0c1775a").
                addHeader("x-rapidapi-host","jokeapi-v2.p.rapidapi.com").
                addHeader("useQueryString","true").
                setBaseUri("https://jokeapi-v2.p.rapidapi.com").
                build().body("{\n" +
                "\t\"contains\": \"C%23\",\n" +
                "\t\"format\": \"json\",\n" +
                "\t\"blacklistFlags\": \"nsfw,racist\",\n" +
                "\t\"idRange\": \"0-150\",\n" +
                "\t\"type\": \"single,twopart\"\n" +
                "}");
        Response response = given().
                spec(request).
                when().
                get("/joke/Any");
        int responseCode = response.then().assertThat().extract().response().getStatusCode();
        Assert.assertEquals(responseCode, 200);
        //System.out.println(response.then().extract().body().jsonPath().prettify());
        System.out.println(response.then().extract().body().jsonPath().get("setup").toString());
        System.out.println(response.then().extract().body().jsonPath().get("delivery").toString());
    }
}
