package session04;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APIKeyAuthentication {
	
	
 @Test
 
 public void GetWhetherdatabycity() {
	 
	// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	 
	 RequestSpecification requestspecification = RestAssured.given();
	 
	 requestspecification.baseUri("https://api.openweathermap.org");
	 requestspecification.basePath("/data/2.5/weather");
	 
	 requestspecification.queryParam("q", "Sangli").queryParam("appid", "c3481f8132eb15ee9a653c21b4418d7c");
	 
	 Response response = requestspecification.get();
	 
	 Assert.assertEquals("Check for status code",200,response.statusCode());
	 System.out.println("Status code" + "=" +response.statusCode());
	 System.out.println("Status line" + "=" +response.statusLine());
	 System.out.println("Response body" +"="+ response.body().asString());
			 
 }

}
