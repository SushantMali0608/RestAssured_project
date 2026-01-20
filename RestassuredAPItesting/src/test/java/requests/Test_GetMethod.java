package requests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {

	@Test
	
	public void Test001() 
	{
		
		Response response = get("https://fake-json-api.mock.beeceptor.com/users");
		
		System.out.println("Response Code" + response.getStatusCode());
		System.out.println("Response body" + response.getBody().asString());
		System.out.println("Response time" + response.getTime());
		System.out.println("Response header" + response.getHeader("Content-Type"));
		
		
		//Validaton Statuscode =403
		
	int expectedStatusCode =200;
	int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
	
	
	
	@Test
	public void test02()
	{
		//given when then format
		
		baseURI ="https://fake-json-api.mock.beeceptor.com/users";
		given().queryParam("id","1")
		.when().get()
		.then().statusCode(200);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
