package Tests;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import  java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class SoapXMLRequest {

    @Test
    public void ValidatesopXML() throws IOException {
        File file = new File("./SopeRequest/Add.xml");
        if (file.exists()) {
            System.out.println(">> File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
        baseURI = "http://dneonline.com/";
        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/calculator.asmx").
                then().statusCode(200).log().all().
                 and().body("//*:AddResult.text()",equalTo("5"));


    }
}