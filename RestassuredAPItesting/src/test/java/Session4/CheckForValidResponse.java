package Session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	

	@Test(enabled=false)
	public void GetSingleUser()
	{
		//specifying base url
		RestAssured.baseURI ="https://api.restful-api.dev/objects";
		
		//get request specification
		
		RequestSpecification requestSpecification = RestAssured.given();
		
		//hitting get request and storing response
		
		Response response = requestSpecification.get();
		
		int actualstatuscode =response.statusCode();
		
		//Adding Validation for status code
		
		Assert.assertEquals(actualstatuscode, 200,"Incorrect Status Code");
		
		//adding validation for Status Line
		
		String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK" , "Incorrect Statusline code");
		
		
	}
	
	@Test(enabled=false)
	public void getSingleUserValidatableResponse()
	{
		
		RestAssured.baseURI ="https://api.restful-api.dev/objects";
		
		RequestSpecification requestSpecific = RestAssured.given();
		
	      Response response = requestSpecific.get();
	      
	      ValidatableResponse validateresponse = response.then();
	      
	      validateresponse.statusCode(200);
	      validateresponse.statusLine("HTTP/1.1 200 OK");
	}
	
	
	@Test
	public void getSinglUserBDD_Style()
	{
		
		RestAssured.given()
		.when()
		      .get("https://api.restful-api.dev/objects")
		.then() 
		      .statusCode(200)
		      .statusLine("HTTP/1.1 200 OK");
		    		  
	}
}
