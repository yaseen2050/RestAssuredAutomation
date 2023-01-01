package Tests;
import static io.restassured.RestAssured.*;  // I add static and .*
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PracticOne {
    @Test
    public void tc_1(){
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.getTime() = " + response.getTime());
        System.out.println("response.getBody().asString() = " + response.getBody().asString());
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
        System.out.println("response.getHeaders() = " + response.getHeaders());

        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }
@Test
    public void tc_2(){
        baseURI="https://reqres.in/api";
        given().get("users?page=2").
                then().statusCode(200).body("data[2].id",equalTo(9));

    }
}

