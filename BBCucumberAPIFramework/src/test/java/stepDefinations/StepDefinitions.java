package stepDefinations;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Name;

public class StepDefinitions {
	
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	
	@Given("Add Name Payload")
	public void add_Name_Payload() {
		RestAssured.baseURI = "http://localhost:3030";
		
		Name n =new Name();
	
		n.setName("First BB Service");
		RequestSpecification req =new RequestSpecBuilder().setBaseUri("http://localhost:3030")
								.setContentType(ContentType.JSON).build();
		 
		 
		resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		res=given().spec(req)
		.body(n);
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
		
		response =res.when().post("services").
				then().spec(resspec).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Then("verify service_Id created to {string} using {string}")
	public void verify_service_Id_created_to_using(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    String res = response.asString();
	    JsonPath js = new JsonPath(res);
	    js.get("id");
	    System.out.println(js.get("id"));
	}

}
