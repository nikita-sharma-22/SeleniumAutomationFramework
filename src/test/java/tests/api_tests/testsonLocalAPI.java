package tests.api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class testsonLocalAPI {

//@Test
public void get(){

    baseURI = "http://localhost:3000";

    given().get("/users").then().statusCode(200).log().all();
}

//@Test
public void post(){

    baseURI = "http://localhost";
    port = 3000;

    JSONObject request = new JSONObject();
    request.put("firstname", "Becky");
    request.put("lastname", "Blackbell");
    request.put("subjectId", 3);
    request.put("id", 4);

    given().
        contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
    when().
        post("/users").
    then().
        statusCode(201).log().all();
}

//@Test
public void put(){

    baseURI = "http://localhost";
    port = 3000;

    JSONObject request = new JSONObject();
    request.put("firstname", "Helpert");
    request.put("lastname", "Smith");
    request.put("subjectId", 2);
    

    given().
        contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
    when().
        put("/users/6").
    then().
        statusCode(200).log().all();
}

//@Test
public void patch(){

    baseURI = "http://localhost";
    port = 3000;

    JSONObject request = new JSONObject();
    
    request.put("lastname", "Forger");
    
    

    given().
        contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).
    when().
        patch("/users/1").
    then().
        statusCode(200).log().all();
}

@Test
public void delete(){

    baseURI = "http://localhost";
    port = 3000;

    JSONObject request = new JSONObject();
    
    request.put("lastname", "Forger");
    
    
    when().
        delete("/users/1").
    then().
        statusCode(200).log().all();
}
    
}
