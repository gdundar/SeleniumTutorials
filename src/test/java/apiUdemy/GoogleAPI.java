package apiUdemy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class GoogleAPI {

    @Test
    public void getGoogleApi() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        given().
                param("location", "-33.8670522,151.1957362").
                param("radius", "500").
                param("key", "AIzaSyADuArlYduTa6mp6RKVezOjUvZdIBMEFm0").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Sydney")).and().
                body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
                header("Server", "scaffolding on HTTPServer2");
    }


    @Test
    //WHY not working??? SAME as the below code!!!
    public void postGoogleApi() {
        RestAssured.baseURI = "http://216.10.245.166";
        given().
                queryParam("key", "qaclick123")
                .body("{" +
                        "\"location\": {" +
                        "\"lat\": -33.8670522 " +
                        "\"lng\": 151.1958750" +
                        "}," +
                        "\"accuracy\": 50," +
                        "\"name\": \"Google Shoes!\", " +
                        "\"phone_number\": \"(02) 9374 4000\", " +
                        "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\", " +
                        "\"types\": [\"shoe_store\"]," +
                        "\"website\": \"http://www.google.com.au/\", " +
                        "\"language\": \"en-AU\"" +
                        "}").
                when().post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));


    }

    @Test
    public void createPlaceAPI() {
        RestAssured.baseURI = "http://216.10.245.166";
        given().
                queryParam("key", "qaclick123").
                body("{" +
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
                        "}").

                when().
                post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));
    }

    @Test
    public void deletePlaceAPI() {
        RestAssured.baseURI = "http://216.10.245.166";
        String bdy = "{" +
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
        Response response = given().
                queryParam("key", "qaclick123").
                body(bdy).
                when().
                post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response();

        String responseString = response.asString();
        System.out.println(responseString);
        response.prettyPrint();
        JsonPath jsonPath = new JsonPath(responseString);
        String placeid = jsonPath.get("place_id");
        System.out.println(placeid);


        //Place the place_id in delete request
        given().
                queryParam("key", "qaclick123").
                body("{" + "\"place_id\": \""+placeid+"\""+ "}").
                when().post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));

    }
}