package API_Murodil.GetClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GsonAPI {

    @Test
    public void testWithJsonToHashMap(){
        Response response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/120");

        HashMap<String, String> map = response.as(HashMap.class);
        System.out.println(map.keySet());
        System.out.println(map.values());
        assertEquals(map.get("employee_id"),120.0);
        assertEquals(map.get("job_id"),"ST_MAN");
    }

    @Test
    public void convertJsonToListOfMaps(){
        Response response = given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/120");

        //convert the response that contains dep info into list of maps
        List<Map> listOfMaps = response.jsonPath().getList("items" , Map.class);
        System.out.println(listOfMaps.get(1));
        assertEquals(listOfMaps.get(1).get("department_name"), "Administration");
    }


}
