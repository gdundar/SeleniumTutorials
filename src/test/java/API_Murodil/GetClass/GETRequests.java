package API_Murodil.GetClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class GETRequests {

    @Test
    public void simpleGet() {
        when().get("url")
                .then().statusCode(200);
    }

    @Test
    public void printResponse() {
        when().get("url")
                .body().prettyPrint();
    }

    @Test
    public void getWithHeaders() {
        with().accept(ContentType.JSON)
                .when().get("url")
                .then().statusCode(200);
    }

    @Test
    public void negativeGet() {
        Response response = when().get("url");
        assertEquals(response.statusCode(), 404);
        response.prettyPrint();
    }

    @Test
    public void VerifyContentTypeWithAssertThat() {
        String url = "url";
        given().accept(ContentType.JSON)
                .when().get(url)
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON);

    }

    @Test
    public void verifyFirstName() throws URISyntaxException{
        URI uri =new  URI("url");
                given().accept(ContentType.JSON)
                .when().get(uri)
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("first_name", Matchers.equalTo("Steven"))
                .and().assertThat().body("employee_id", Matchers.equalTo(100));
    }

}
