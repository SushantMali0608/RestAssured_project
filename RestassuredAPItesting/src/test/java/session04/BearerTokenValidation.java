package session04;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BearerTokenValidation {
	
   	@SuppressWarnings("unchecked")
	@Test
   	public void BearerToken() {
   		
   		RequestSpecification requestspecification = RestAssured.given();
   		
   		requestspecification.baseUri("https://gorest.co.in/");
   		requestspecification.basePath("/public/v2/users");
   		
   		JSONObject payload = new JSONObject();
   		payload.put("name", "sushawwwwwmali");
   		payload.put("gender", "male");
   		payload.put("email", "sushamali123@mail.com");
   		payload.put("status", "active");
   		
        String authkey ="Bearer a9da9c0b47e7fd85ee602a94ce736a410100535595814c1f6090337c1d13d0be";
   		requestspecification.headers("Authorization", authkey)
   		.contentType(ContentType.JSON)
   		.body(payload.toJSONString());
   		
   		Response response = requestspecification.post();
   		
   		System.out.println("Status code" + "=" +response.statusCode());
   		System.out.println("Status line" + "=" +response.statusLine());
   		
   		
   		Assert.assertEquals("Check for status code",201,response.statusCode());
   		
   		System.out.println("Response body" +"="+ response.body().asString());
   		
   		
   		
   		
   	
   	}
}
