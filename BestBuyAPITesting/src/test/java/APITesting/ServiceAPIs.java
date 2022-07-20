package APITesting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import Repository.JsonResponse;
import Utilities.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ServiceAPIs {
	String id;
		
	public String addService() {

		//************************************************** Add Service **************************************
		
		String response = given().log().all().header("Content-Type", "application/json")
				.body(JsonResponse.AddService()).when().post("services").then().assertThat().statusCode(201)
				.extract().response()
				.asString();
		System.out.println("Response: " + response);
		JsonPath js = new JsonPath(response); // for parsing Json      
		id = js.getString("id");
		System.out.println("PlaceId: " + id);
		return id;
	}
	
	public String updateService(String newName) {

		//************************************************** Update Service **************************************
		
		String res = given().log().all().header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"name\": \"" + newName + "\"\r\n"
				+ "}")
		.when().put("services/"+id+"").then().assertThat().log().all().statusCode(200).extract().response().asString();
		return res;

	}
	
	
	public String getService() {

		//************************************************** Get Service **************************************
		
		String getResponse = given().log().all()
				.when().get("services/"+id+"").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();
		JsonPath js1 = ReUsableMethods.rawToJson(getResponse);
		String actualName = js1.getString("name");
		System.out.println(actualName);
		
		return getResponse;

	}
	
	public String getAllServices() {

		//************************************************** Get Service **************************************
		
		String getResponse = given().log().all()
				.when().get("services").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();
		JsonPath js1 = ReUsableMethods.rawToJson(getResponse);
		String actualName = js1.getString("name");
		System.out.println(actualName);
		
		return getResponse;

	}

}
