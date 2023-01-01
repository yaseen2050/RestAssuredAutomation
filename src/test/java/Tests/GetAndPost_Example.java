package Tests;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPost_Example {


 //  @Test
   public void testGet(){
    baseURI="https://reqres.in/api";
    given().get("/users?page=2")
            .then().statusCode(200).
            body("data[4].first_name",equalTo("George"))
            .body("data.first_name",hasItems("George","Rachel"));

   }
   @Test
    public void testPost(){
//       Map<String,Object>map=new HashMap<String,Object>();  // this first way
//       map.put("name","Yaseen");
//       map.put("job","Teacher");

//       System.out.println(map);

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
              post("/users").then().
              statusCode(201).log().all();
   }
}
