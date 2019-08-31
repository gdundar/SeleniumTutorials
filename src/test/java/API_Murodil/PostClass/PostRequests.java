package API_Murodil.PostClass;

import API_Murodil.beans.CountriesResponse;
import API_Murodil.beans.RegionResponse;
import com.github.javafaker.Country;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

import API_Murodil.beans.Region;
import API_Murodil.beans.Countries;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PostRequests {

    @Test
    public void postNewRegion(){
        String url= ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions/";
       //String requestJson = "{\"region_id\" : 5, \"region_name\" : \"yasin's region\"}";

        //a better format -> MAP , the upper string method is not looking good
        Map requestMap = new HashMap<>();
        requestMap.put("region_id", 555.0);
        requestMap.put("region_name", "Yasin'in yeri");

               Response response =  given().accept(ContentType.JSON)
                        .and().contentType(ContentType.JSON)
                        .and().body(requestMap)
                        .when().post(url);

        System.out.println(response.statusLine());
        response.prettyPrint();

        assertEquals(response.statusCode(),201);
        Map responseMap = response.body().as(Map.class);
        assertEquals(responseMap.get("region_id"), requestMap.get("region_id"));
        assertEquals(responseMap.get("region_name"), requestMap.get("region_name"));
    }

    @Test
    public void postUsingPOJO(){
        String url= ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions/";
        Region region = new Region();
        region.setRegion_id(new Random().nextInt(99));
        region.setRegion_name("Yasin' in yeri");

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(region)
                .when().post(url);

        assertEquals(response.statusCode(), 201);
        RegionResponse responseRegion = response.body().as(RegionResponse.class);
        assertEquals(responseRegion.getRegion_id(), region.getRegion_id());
        assertEquals(responseRegion.getRegion_name(), region.getRegion_name());

    }


    //givess 400 error !?
    @Test
    public void countryPOJO(){
        String url= ConfigurationReader.getProperty("hrapp.baseresturl") + "/countries/";
        Countries country = new Countries();
        country.setCountry_id("AA");
        country.setCountry_name("ABC Country");
        country.setRegion_id(6);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(country)
                .when().post(url);

        assertEquals(response.statusCode(), 201);
        CountriesResponse responseCountry = response.body().as(CountriesResponse.class);
        assertEquals(responseCountry.getCountry_id(), country.getCountry_id());
        assertEquals(responseCountry.getCountry_name(), country.getCountry_name());
        assertEquals(responseCountry.getRegion_id(), country.getRegion_id());
    }


}
