import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_01_GET {

	
	@Test
	void test_01() {
		
		RestAssured.get();
	}
}
