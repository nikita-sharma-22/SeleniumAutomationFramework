package tests.api_tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;


public class jsonschemavalidation {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api/";

        given().
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").get("users?page=1").
        then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
            statusCode(200);

    }
    
    
}
