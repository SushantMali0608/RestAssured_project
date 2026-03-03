package session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONobjectUsingJavaMap {

	@Test(enabled=false)
	public void creatingaccesstoken() {

		/*
		 * https://restful-booker.herokuapp.com/auth \
  -H 'Content-Type: application/json' \
  -d '{
    "username" : "admin",
    "password" : "password123"
}'*/		

		Map<String,String> authtoken = new HashMap<String,String>();
		authtoken.put("username", "admin");
		authtoken.put("password", "password123");

		Response response =RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/auth").
				contentType(ContentType.JSON).
				body(authtoken).
				post();

		response.prettyPrint();
		Assert.assertEquals(response.statusCode(),200);


	}

	@Test
	public void creatingusers() {

		//	https://reqres.in/api/users

		/*{
		 * "FirstName":"Sushant",
		 * "LastName":"Mali",
		 * "age":27,
		 * "IsMarried":false,
		 * "Hobbies":["cricket","swimming","Games"],
		 * "Techskills":{
		 *             "Programmming language":"Java",
		 *             "Web Automation":"Selenium",
		 *             "API Testing":"RestAssured"
		 * }
		 * }*/

		HashMap<String,Object> Userdata =new HashMap<String,Object>();
		Userdata.put("FirstName", "Sushant");
		Userdata.put("LastName", "Mali");
		Userdata.put("age", 27);
		Userdata.put("IsMarried", false);

		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Cricket");
		hobbies.add("swimming");
		hobbies.add("Games");

		Userdata.put("Hobbies",hobbies);

		HashMap<String,String> techskills = new HashMap<String,String>();
		techskills.put("Programmming language", "Java");
		techskills.put("Web Automation", "Selenium");
		techskills.put("API Testing", "RestAssured");


		Userdata.put("Techskills",techskills);

		Response response =RestAssured.given()
				.baseUri("https://reqres.in/api/users").
				contentType(ContentType.JSON).
				body(Userdata).
				post();

		response.prettyPrint();
		Assert.assertEquals(response.statusCode(),201,"Check for status code");

	}
}
