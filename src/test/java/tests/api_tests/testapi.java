package tests.api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class testapi {

    @Test()
    public void test1(){

        Response response = given().header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").get("https://reqres.in/api/users?page=1");

        
        System.out.println("The response code is "+response.getStatusCode()+" in time: "+response.getTime());
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeader("content-type"));
        
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
        

    }

    @Test()
    public void test2(){

        baseURI = "https://reqres.in/api/";

        given().
            header("x-api-key", "reqres_d785c753486b4b05806b569181cfdd74").get("users?page=1").
        then().
            statusCode(200).body("data[1].id", equalTo(2)).
            log().all();

            

        
       
        

    }
}
