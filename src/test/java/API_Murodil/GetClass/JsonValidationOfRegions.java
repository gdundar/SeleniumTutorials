package API_Murodil.GetClass;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class JsonValidationOfRegions {

    @Test
    public void testRegions(){
        String url = ConfigurationReader.getProperty("url") + "/regions";
        Response response = given().accept(ContentType.JSON)
                .and().params("limit", 10)
                .when().get(url);
        assertEquals(response.statusCode(), 200);
        JsonPath json = response.jsonPath();

        assertEquals(json.getInt("item[0].region_id"),1);
        assertEquals(json.getString("item[0].region_name"),"Europe");


        // map version deserialize json to map list
        List<Map> regions = json.getList("items", Map.class);
        Map<Integer, String> expecteRegions = new HashMap<>();
        expecteRegions.put(1, "Europe");
        expecteRegions.put(2, "Americas");
        expecteRegions.put(3, "Asia");
        expecteRegions.put(4, "Middle East and Africa");

        for(Integer regionId : expecteRegions.keySet()){
            System.out.println(regionId);

            for(Map map : regions){
                if(map.get("region_id") == regionId){
                    assertEquals(map.get("region_name"), expecteRegions.get(regionId));
                }
            }
        }
    }

    @Test
    public void testRegionsVersion2(){
        String url = ConfigurationReader.getProperty("url") + "/regions";
        Response response = given().accept(ContentType.JSON)
                .and().params("limit", 10)
                .when().get(url);
        assertEquals(response.statusCode(), 200);
        JsonPath json = response.jsonPath();

        assertEquals(json.getInt("item[0].region_id"),1);
        assertEquals(json.getString("item[0].region_name"),"Europe");


        // map version deserialize json to map list
        List<Map> regions = json.getList("items", Map.class);
        Map<Integer, String> expecteRegions = new HashMap<>();
        expecteRegions.put(1, "Europe");
        expecteRegions.put(2, "Americas");
        expecteRegions.put(3, "Asia");
        expecteRegions.put(4, "Middle East and Africa");

        for(int i=0; i< regions.size(); i++){
            assertEquals(regions.get(i).get("region_id"), i +1);
            assertEquals(regions.get(i).get("region_name"), expecteRegions.get(i + 1));
        }

    }


    @Test
    public void testRegionsVersion3() {
        String url = ConfigurationReader.getProperty("url") + "/regions";
        Response response = given().accept(ContentType.JSON)
                .and().params("limit", 10)
                .when().get(url);
        assertEquals(response.statusCode(), 200);

        JsonPath json = response.jsonPath();

        List<String> testData = Arrays.asList("22 Europe", "2 Americas", "3 Asia", "4 Middle East and Africa");

        List<String> regionNames = new ArrayList<>();

        for (Object item : json.getList("items")) {
            regionNames.add(((HashMap) item).get("region_id").toString() + " " +
                    ((HashMap) item).get("region_name").toString());
        }
        assertTrue(regionNames.containsAll(testData));

    }
}
