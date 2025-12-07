package tests.api_tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;

import io.restassured.http.ContentType;

public class put_patch_delete_examples {

    @Test
    public void testPut(){

        JSONObject request = new JSONObject();
        request.put("name", "Loid");
        request.put("job", "Psychiatrist");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";

        given().contentType("application/json").accept(ContentType.JSON).
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").
            body(request.toJSONString()).
        when().
            put("/users/2").
        then().
            statusCode(200).log().all();

    }

    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();
        request.put("name", "Yor");
        request.put("job", "Administrator");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/";

        given().contentType("application/json").accept(ContentType.JSON).
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").
            body(request.toJSONString()).
        when().
            patch("/api/users/2").
        then().
            statusCode(200).log().all();

    }

    @Test
    public void testDelete(){

        
        baseURI = "https://reqres.in/";

        given().header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").
        when().
            delete("/api/users/2").
        then().
            statusCode(204).
            log().all();

    }
    
}
