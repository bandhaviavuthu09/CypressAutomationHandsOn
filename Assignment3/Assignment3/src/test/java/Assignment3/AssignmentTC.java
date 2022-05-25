package Assignment3;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssignmentTC {
	
	
	@Test(description="to demonstrate post method")
	public void postMethod() {
		System.out.println("*********** post method *********");
		Response res=given().body("[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5,\r\n"
				+ "    \"first_name\": \"John\",\r\n"
				+ "    \"middle_name\": \"Druid\",\r\n"
				+ "    \"last_name\": \"Anthony\",\r\n"
				+ "    \"date_of_birth\": \"10 May 1990\"\r\n"
				+ "  }\r\n]").header("Content-Type", "application/json").when().post("http://thetestingworldapi.com/Help/Api/POST-api-studentsDetails");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description="demonstrate put method")
	public void putMethod() {
		System.out.println("*********** put method *********");
		Response res=given().body("[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 5,\r\n"
				+ "    \"first_name\": \"John\",\r\n"
				+ "    \"middle_name\": \"Druid\",\r\n"
				+ "    \"last_name\": \"Anthony\",\r\n"
				+ "    \"date_of_birth\": \"10 May 1991\"\r\n"
				+ "  }\r\n]").header("Content-Type", "application/json").when().put("http://thetestingworldapi.com/Help/Api/PUT-api-studentsDetails-id");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description="to demonstrate user get method")
	public void getMethod() {
		
		System.out.println("*********** get method *********");

		RestAssured.baseURI = "http://thetestingworldapi.com/Help";
		RequestSpecification httpRequest = RestAssured.given();
		Response res = httpRequest.queryParam("id","5").get("/Api/GET-api-studentsDetails");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(description="to demonstrate user delete method")
	public void deleteMethod() {
		System.out.println("*********** delete method *********");
		Response res=given().queryParam("id","5").delete("http://thetestingworldapi.com/Help/Api/DELETE-api-studentsDetails-id");
		System.out.println(res.asString());
		//System.out.println(res.path("username").toString());
		assertEquals(res.getStatusCode(), 200);
	}

}
