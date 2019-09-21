package apiUdemy;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetData {

    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/yasinbekar/IdeaProjects/SeleniumTutorials/src/test/java/apiUdemy/env.properties");
        prop.load(fis);
        //prop.get("HOST");
    }

    @Test
    public void AddandDeletePlace() {
        String payLoad = "{" +
                "\"location\": {" +
                "\"lat\": -33.8669710," +
                "\"lng\": 151.1958750" +
                "}," +
                "\"accuracy\": 50," +
                "\"name\": \"Google Shoes!\"," +
                "\"phone_number\": \"(02) 9374 4000\"," +
                "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," +
                "\"types\": [\"shoe_store\"]," +
                "\"website\": \"http://www.google.com.au/\"," +
                "\"language\": \"en-AU\"" +
                "}";
        //Task 1- Grab the response
        RestAssured.baseURI = prop.getProperty("HOST");
        Response res = given().

                queryParam("key", prop.getProperty("KEY")).
                body(payLoad).
                when().
                post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response();
        // Task 2- Grab the Place ID from response

        String responseString = res.asString();
        System.out.println(responseString);
        JsonPath js = new JsonPath(responseString);
        String placeid = js.get("place_id");
        System.out.println(placeid);


        //Task 3 place this place id in the Delete request
        given().
                queryParam("key", prop.getProperty("KEY")).

                body("{" +
                        "\"place_id\": \"" + placeid + "\"" +
                        "}").
                when().
                post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));


    }
}