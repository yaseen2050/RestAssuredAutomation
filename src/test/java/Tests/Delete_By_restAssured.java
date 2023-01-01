package Tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class Delete_By_restAssured {
    @Test
    public void testDelete(){


        baseURI="https://reqres.in";

                when().
                delete("/api/users/2").then().
                statusCode(204).log().all();
    }
}
