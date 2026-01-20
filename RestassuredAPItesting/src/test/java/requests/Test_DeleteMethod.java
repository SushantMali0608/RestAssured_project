package requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod {
	
	@Test
	public void Testo6()
	{
		
		RestAssured.baseURI ="https://api.restful-api.dev/objects/ff8081819782e69e019ba4086474033e";
		
		RestAssured.given().
		when().delete().
		then().statusCode(200).log().all();
	}

}
