package API_Murodil.cucumberApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.xwpf.usermodel.IBody;
import org.testng.annotations.Test;
import selenium.utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class PostThenGet {

    @Test
    public void PostEmployeeTheGetEmployee(){

        String url = ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/";
        Map reqEmployee = new HashMap();
        int randomID = new Random().nextInt(1000);
        reqEmployee.put("employee_id", randomID);
        reqEmployee.put("first_name", "POSTNAME");
        reqEmployee.put("last_name", "POSTLASTNAME");
        reqEmployee.put("email", "EM" + randomID);
        reqEmployee.put("phone_number", "202.213.4567");
        reqEmployee.put("hire_date", "2018-06-17T04:00:00Z");
        reqEmployee.put("job_id", "IT_PROG");
        reqEmployee.put("salary", 24000);
        reqEmployee.put("commission_pct", null);
        reqEmployee.put("manager_id", null);
        reqEmployee.put(    "department_id", 90.0);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(reqEmployee)
                .when().post(url);

        assertEquals(response.statusCode(), 201);
        Map postResEmployee = response.body().as(Map.class);
        for(Object key : reqEmployee.keySet()){
            System.out.println(postResEmployee.get(key) + "<>" + reqEmployee.get(key));
            assertEquals(postResEmployee.get(key), reqEmployee.get(key));
        }

        response = given().accept(ContentType.JSON)
                .when().get(url + randomID);
        postResEmployee = response.body().as(Map.class);
        for(Object key : reqEmployee.keySet()){
            System.out.println(postResEmployee.get(key) + "<>" + reqEmployee.get(key));
            assertEquals(postResEmployee.get(key), reqEmployee.get(key));
        }



        //GET
        response = given().accept(ContentType.JSON)
                    .when().get(url + randomID);

        assertEquals(response.statusCode(),200);

        Map getResMap = response.body().as(Map.class);
        for(Object key : reqEmployee.keySet()){
            System.out.println(key + ":" + reqEmployee.get(key) + "<>" + getResMap.get(key));
            assertEquals(getResMap.get(key), reqEmployee.get(key));
        }

    }







}
