package session04;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class authenticationVouth2_0 {
	static String accesstoken;
	
	@Test
	
	public void generateToken() {
		
		//POST https://dummyjson.com/auth/login
		
//		RequestSpecification requestspec = RestAssured.given();
//		String username = "kminchelle";
//		String Password ="0lelplR";
		
//		Response response =requestspec.baseUri("https://dummyjson.com/auth/login").
//	    header("Content-Type", "application/json").
//	    body("{\"username\":\"emilys\",\"password\":\"emilyspass\"}").
//		post();
//		accesstoken =response.getBody().path("accessToken");
//		System.out.println(response.statusCode());
//		response.prettyPrint();
//		
//		Assert.assertEquals(response.statusCode(),200);
		
		accesstoken = RestAssured.
		given().header("Content-Type", "application/json").body("{\"username\":\"emilys\",\"password\":\"emilyspass\"}").
		when().post("https://dummyjson.com/auth/login").
		then().statusCode(200).
		extract().
		path("accessToken");
		
		System.out.println(accesstoken);
		
	}
     @Test(dependsOnMethods="generateToken")
	public void APIAuthentication(){
		
//		Response res =RestAssured.given().auth().oauth2(accesstoken).get("https://dummyjson.com/auth/me");
//	    res.prettyPrint();
//		System.out.println(res.statusCode());
//	    Assert.assertEquals(res.statusCode(),200);
    	 RestAssured.
    	 given().auth().oauth2(accesstoken).
    	 when().get("https://dummyjson.com/auth/me").
    	 then().statusCode(200);
		
	}
	
	
}
