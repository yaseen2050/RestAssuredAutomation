package Tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Put_and_Patch {

    @Test
    public void testPut(){


        JSONObject request =new JSONObject();                   // this second way
        request.put("name","Yaseen");
        request.put("job","Teacher");
        System.out.println(request);
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toString()).
                when().
                put("/users/2").then().
                statusCode(200).log().all();
    }

    @Test
    public void testPatch(){


        JSONObject request =new JSONObject();                   // this second way
        request.put("name","Yaseen");
        request.put("job","Teacher");
        System.out.println(request);
        baseURI="https://reqres.in";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toString()).
                when().
                patch("/api/users/2").then().
                statusCode(200).log().all();
    }
}
