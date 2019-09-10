package API_Murodil.GetClass;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class JsonPathAPI {

    @Test
    public void testItemsCountFromResponseBody(){
        given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/regions")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType(ContentType.JSON)
                .and().assertThat().body("items.region_id", hasSize(4))
                .and().assertThat().body("items.region_name", hasItem("Americas"))
                .and().assertThat().body("items.region_name", hasItems("Europe", "Americas", "Asia", "Middle East", "Africa"))
                .and().assertThat().body("items.region_name", contains("Americas"));
    }

    @Test
    public void testWithQueryParameter(){
        ValidatableResponse limit = given().accept(ContentType.JSON)
                .and().params("limit", 100)
                .when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("items.employee_id", hasSize(100));
    }

    @Test
    public void testWithTestParameter(){
        given().accept(ContentType.JSON)
                .and().params("limit" ,100)
                .and().pathParam(":id", 110)
                .when().get(ConfigurationReader.getProperty("url") + "/employees/{employee_id}")
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().assertThat().body("employee_id", equalTo(110),
                "first_name", equalTo("john"),
                "last_name", equalTo("Chen"),
                "email", equalTo("JChen"));
    }

    @Test
    public void testWithJasonPath(){
        Map<String, Integer> rParamMap  =new HashMap<>();
        rParamMap.put("limit", 100);

        Response response = given().accept(ContentType.JSON)
                .and().params(rParamMap)
                .and().pathParam("employee_id", 177)
                .when().get(ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/{employee_id}");

        JsonPath json = response.jsonPath();
        System.out.println(json.getInt("employee_id"));
        System.out.println(json.getString("last_name"));
        System.out.println(json.getString("job_id"));
        System.out.println(json.getInt("salary"));
        System.out.println(json.getString("links[1].href"));
        List<String> hrefs =json.getList("links.href");
        System.out.println(hrefs);

    }

    @Test
    public void testJsonPathWithLists(){
        Map<String, Integer> rParamMap  =new HashMap<>();
        rParamMap.put("limit", 100);

        Response response = given().accept(ContentType.JSON)
                .and().params(rParamMap)
                .and().pathParam("employee_id", 177)
                .when().get(ConfigurationReader.getProperty("url") + "/employees");
        assertEquals(response.statusCode(),200);
        //JasonPath json = new JasonPath(response.asString())
        JsonPath json = response.jsonPath();

        //get all employee id
        List<Integer> empIds = json.getList("items.employee_id");
        System.out.println(empIds);
        assertEquals(empIds.size(), 100);

        //get all emails
        List<String> emails = json.getList("item.email");
        System.out.println(emails);
        assertEquals(emails.size(), 100);

        //get all id > 150
        List<String> empIdList = json.getList("items.findAll{it.employee_id > 150}.employee_id"); //it means THIS
        System.out.println(empIdList);

        //get all lastnames who has salary > 7000
        List<String> lastnames = json.getList("items.findAll{it.salary > 10000}.last_name");
        System.out.println(lastnames);

        //get emails via a file
        JsonPath jsonFromFile = new JsonPath(new File("the path of the file after uploding to the ide"));
        List<String> email = jsonFromFile.getList("items.email");
        System.out.println(email);

    }



}
