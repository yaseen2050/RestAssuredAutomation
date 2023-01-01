package Tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class TestOnLocal_API {

  //  @Test
    public void get(){
        baseURI="http://localhost:3000";
       given().get("/users").then().statusCode(200).log().all();

    }
  //  @Test
    public void post(){
        baseURI="http://localhost:3000";
        JSONObject requset =new JSONObject();
        requset.put("firstName","Ahmed");
        requset.put("lastName","Yaseen");
        requset.put("subjectId",1);

        baseURI="http://localhost:3000";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requset.toString()).
                when()
                .post("/users")
                .then()
                .statusCode(201);
    }

   // @Test
    public void patch(){ // change all
        baseURI="http://localhost:3000";
        JSONObject requset =new JSONObject();
        requset.put("firstName","Danah");
        requset.put("lastName","Yaseen");
        requset.put("subjectId",2);

        baseURI="http://localhost:3000";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requset.toString()).
                when()
                .put("/users/4")
                .then()
                .statusCode(200);
    }

//@Test
    public void put(){     // change specific thing

        JSONObject requset =new JSONObject();
        requset.put("firstName","Hoor");

        baseURI="http://localhost:3000";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requset.toString()).
                when()
                .patch("/users/4")
                .then()
                .statusCode(200);
    }

    @Test
    public void Delete(){
        baseURI="http://localhost:3000";

        when()
                .delete("/users/4")
                .then()
                .statusCode(200);
    }
}
