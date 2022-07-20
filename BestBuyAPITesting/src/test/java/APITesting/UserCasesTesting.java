package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UserCasesTesting {
	
	ServiceAPIs sa = new ServiceAPIs();
	
	/*** Use Case 1 - Create a New Service ****/
	@Test
	public void UserCase1() {
		RestAssured.baseURI = "http://localhost:3030";
		String id = sa.addService();
		System.out.println("The new service Id created is:"+id);
	}
	
	
	/*** Use Case 2 - Create a new service, update it with a new name and retrieve service details to 
validate if the new service name is present in the json response body **/
	@Test
	public void UserCase2() {
		RestAssured.baseURI = "http://localhost:3030";
		String id = sa.addService();
		System.out.println("The new service Id created is:"+id);
		String newName = "Updated Service Name";
		String response = sa.updateService(newName);
		System.out.println("Updated Response :: "+response);
		String getUpdatedName = sa.getService();
		Assert.assertEquals(newName, getUpdatedName);
	}
	
	/*** Use Case 3 - Retrieve a count of all the services and print IDs and the names of all the services ***/
	@Test
	public void UserCase3() {
		RestAssured.baseURI = "http://localhost:3030";
		String response = sa.getAllServices();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String serviceCount = js.getString("total");
		System.out.println("Total count of all services : " + serviceCount);

		int count = js.getInt("limit");
		for (int i = 0; i < count; i++) {
			String id = js.getString("data[" + i + "].id");
			String name = js.getString("data[" + i + "].name");
			System.out.println("Id :" + id + "\n Name:" + name);

		}
		System.out.println("Response :" + response);

	}

}
