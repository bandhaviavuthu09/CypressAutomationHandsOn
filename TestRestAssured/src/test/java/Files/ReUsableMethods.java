package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReUsableMethods {
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
	
	public static JsonPath rawToJson(Response r)
	{
		String response = r.asString();
		JsonPath js1 =new JsonPath(response);
		return js1;
	}
	
	
	public static String getSessionKey() {
		
		RestAssured.baseURI = "https://localhost:8080";
		Response res = given().header("Content-Type", "application/json")
				.body("{\"username\": \"rahulonlinetutor\", \"password\": \"Jira12345\"}")
				.when().post("/rest/auth/1/session").then().statusCode(200).
				extract().response();
		JsonPath js = ReUsableMethods.rawToJson(res);
		String sessionid = js.get("session.value");
		return sessionid;
	}

}

