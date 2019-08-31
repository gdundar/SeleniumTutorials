package API_Murodil.cucumberApi.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import selenium.utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PostEmployeeStepDefinitions {

    RequestSpecification request;
    int employeeId;
    Response response;
    Map reqEmployee;
    String url = ConfigurationReader.getProperty("hrapp.baseresturl") + "/employees/";

    @Given("Content ype and Accept type is Json")
    public void content_ype_and_Accept_type_is_Json() {
        request = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON);
    }

    @When("I post a new Employee with {string} id")
    public void i_post_a_new_Employee_with_id(String id) {
        if(id.equals("random")){
            employeeId = new Random().nextInt(99999);
        }else{
            employeeId = Integer.parseInt(id);
        }
        reqEmployee = new HashMap();
        reqEmployee.put("employee_id", employeeId);
        reqEmployee.put("first_name", "POSTNAME");
        reqEmployee.put("last_name", "POSTLASTNAME");
        reqEmployee.put("email", "EM" + employeeId);
        reqEmployee.put("phone_number", "202.213.4567");
        reqEmployee.put("hire_date", "2018-06-17T04:00:00Z");
        reqEmployee.put("job_id", "IT_PROG");
        reqEmployee.put("salary", 24000);
        reqEmployee.put("commission_pct", null);
        reqEmployee.put("manager_id", null);
        reqEmployee.put(    "department_id", 90.0);

         response = request.body(reqEmployee)
                .when().post(url);

    }

    @Then("Status code is {int}")
    public void status_code_is(int statusCode){
        assertEquals(response.statusCode(), statusCode);
    }

    @Then("Response Json should contain Employee info")
    public void response_Json_should_contain_Employee_info() {
        Map postResEmployee = response.body().as(Map.class);
        for(Object key : reqEmployee.keySet()){
            System.out.println(postResEmployee.get(key) + "<>" + reqEmployee.get(key));
            assertEquals(postResEmployee.get(key), reqEmployee.get(key));
        }
    }


    @When("I send a Get request with {string} id")
    public void i_send_a_Get_request_with_id(String id) {
        if(!id.equals(("random"))){
            employeeId = Integer.parseInt(id);
        }
        response = given().accept(ContentType.JSON)
                .when().get(url + employeeId);
    }


    @Then("Employee JSON Response Data should match the posted JSON data")
    public void employee_JSON_Response_Data_should_match_the_posted_JSON_data() {
        Map getResMap = response.body().as(Map.class);
        for(Object key : reqEmployee.keySet()){
            System.out.println(key + ":" + reqEmployee.get(key) + "<>" + getResMap.get(key));
            assertEquals(getResMap.get(key), reqEmployee.get(key));
        }
    }
}
