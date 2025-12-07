package tests.api_tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class get_and_post_examples {

    @Test
    public void testGet(){

        baseURI = "https://reqres.in/api/";

        given().
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").get("users?page=1").
        then().
            statusCode(200).body("data[1].first_name", equalTo("Janet")).
            body("data.first_name", hasItems("George", "Eve"));

    }

    @Test
    public void testPost(){

        Map<String,Object> map = new HashMap<String,Object>();
        // map.put("name", "Nikita");
        // map.put("job", "Software Engineer");

        // System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("name", "Nikita");
        request.put("job", "Software Engineer");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";

        given().contentType("application/json").accept(ContentType.JSON).
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").
            body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).log().all();

    }
    
}
