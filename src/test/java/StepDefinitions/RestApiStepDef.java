package StepDefinitions;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestApiStepDef {
    protected static RequestSpecification request;
    protected static ResponseSpecification responseSpec;

    @When("I call Get Categories I have a response")
    public void iCallGetCategoriesIHaveAResponse() {
        request = new RequestSpecBuilder().
                setBaseUri("https://petstore.swagger.io/v2").
                build();
        Response response = given().
                spec(request).
                when().
                get("/pet/findByStatus?status=available");
        //System.out.println(response.asString());
        System.out.println(response.then().extract().body().jsonPath().prettify());
    }
}
