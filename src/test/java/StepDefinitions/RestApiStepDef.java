package StepDefinitions;

import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestApiStepDef {
    protected static RequestSpecification request;
    protected static ResponseSpecification responseSpec;

    @When("I call Get Categories I have a response")
    public void iCallGetCategoriesIHaveAResponse() throws IOException {
        request = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2").
                build();
        Response response = given().
                spec(request).
                when().
                get("/pet/findByStatus?status=available");
                int responseCode = response.then().assertThat().extract().response().getStatusCode();
        Assert.assertEquals(responseCode, 201);

    }
}
