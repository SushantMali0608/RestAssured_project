package session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONArrayDemo {

	@Test
	public void creatingUserusingJsonArray() {


		//creating JSon Object for Users

		/*
		 * {
		 * "FirstName":"Sushant",
		 * "LastName":"Mali",
		 * "age":27,
		 * "salary":2000
		 * 
		 * }*/


		JSONObject user1 = new JSONObject();
		user1 .put("FirstName", "Sushant");
		user1.put("LastName", "Mali");
		user1.put("age", 27);
		user1.put("salary", 20000);

		JSONObject user2 = new JSONObject();
		user2 .put("FirstName", "Sourabh");
		user2.put("LastName", "Mali");
		user2.put("age", 77);
		user2.put("salary", 20000);

		JSONObject user3 = new JSONObject();
		user3 .put("FirstName", "Rohit");
		user3.put("LastName", "Mali");
		user3.put("age", 87);
		user3.put("salary", 20000);

		JSONArray userpayload = new JSONArray();

		userpayload.add(user1);
		userpayload.add(user2);
		userpayload.add(user3);

		//used URL is not working so it is getting failed
		Response response =RestAssured.given().baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON).body(userpayload)
				.post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(),200,"Check for status code");

	}
	
	
	@Test
	
	public void creatingUsersusingList() {
        //creating JSon Object for Users

		/*
		 * {
		 * "FirstName":"Sushant",
		 * "LastName":"Mali",
		 * "age":27,
		 * "salary":2000
		 * 
		 * }*/


		//JSONObject user1 = new JSONObject();
		
		//need to use Map for adding users
		Map <String,Object> user1 = new HashMap<>();
		user1 .put("FirstName", "Sushant");
		user1.put("LastName", "Mali");
		user1.put("age", 27);
		user1.put("salary", 20000);

		//JSONObject user2 = new JSONObject();
		Map <String,Object> user2 = new HashMap<>();
		user2 .put("FirstName", "Sourabh");
		user2.put("LastName", "Mali");
		user2.put("age", 77);
		user2.put("salary", 20000);

		//JSONObject user3 = new JSONObject();
		Map <String,Object> user3 = new HashMap<>();
		user3 .put("FirstName", "Rohit");
		user3.put("LastName", "Mali");
		user3.put("age", 87);
		user3.put("salary", 20000);

		//JSONArray userpayload = new JSONArray();
		//need to create list of map
		
        List<Map<String,Object>> userpayload = new ArrayList<>();
		userpayload.add(user1);
		userpayload.add(user2);
		userpayload.add(user3);

		//used URL is not working so it is getting failed
		Response response =RestAssured.given().baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON).body(userpayload)
				.post();

		response.prettyPrint();

		Assert.assertEquals(response.statusCode(),200,"Check for status code");

	}

}
