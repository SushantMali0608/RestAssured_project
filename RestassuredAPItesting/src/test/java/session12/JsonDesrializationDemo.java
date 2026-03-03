package session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonDesrializationDemo {

	//https://dummyjson.com/auth/login
		//request body {
//		  "username": "emilys",
//		  "password": "emilyspass"
//		}

	@SuppressWarnings("unchecked")
	@Test
	
	public void CreateUser() {
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("https://dummyjson.com");
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("username", "emilys");
		jsonobject.put("password", "emilyspass");
		
		Response response = reqspec.contentType(ContentType.JSON).body(jsonobject.toString()).post("/auth/login");
		
		response.prettyPrint();
		@SuppressWarnings("rawtypes")
		ResponseBody responsebody = response.getBody();
		
		JsonPostRequestresponse responseclass = responsebody.as(JsonPostRequestresponse.class);
		Assert.assertEquals(responseclass.username, "emilys", "Username verified");
		
		System.out.println(responseclass.id);
	}
	
}
