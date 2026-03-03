package session13;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class queryRequestSpecifcation {

	@Test

	public void createUser() {

		//https://dummyjson.com/auth/login
		//request body {
		//		  "username": "emilys",
		//		  "password": "emilyspass"
		//		}

		//Creating JSonObject to post values 
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("username", "emilys");
		jsonobject.put("password", "emilyspass");

		//creating request specification 		
		//		RequestSpecification reqspec = RestAssured.given();
		//		
		//		//specifying url  
		//		reqspec.baseUri("https://dummyjson.com").basePath("/auth/login").
		//		contentType(ContentType.JSON).body(jsonobject.toString()).header("header1","Headervalue");
		//		
		//writing this request in BDD form 
		RequestSpecification reqspec = 

				RestAssured.
				given().baseUri("https://dummyjson.com").basePath("/auth/login").
				contentType(ContentType.JSON).body(jsonobject.toString()).header("header1","Headervalue");

				// rertving query details of request Specification

				QueryableRequestSpecification requestquery =SpecificationQuerier.query(reqspec);
		String RetriveBaseuri =requestquery.getBaseUri();
		System.out.println("BaseURI :"+RetriveBaseuri);

		String RetriveBasepath =requestquery.getBasePath();
		System.out.println("BasePath :"+RetriveBasepath);

		String RetriverequestBody =requestquery.getBody();
		System.out.println("RequestBody :"+RetriverequestBody);

		//retriving Headers

		Headers allheaders = requestquery.getHeaders();

		for(Header h :allheaders) {

			System.out.println("Header key" + h.getName()+"Header Value"+h.getValue());
		}
		
		Response response = reqspec.when().post();
				
		response.then().statusCode(200);
		response.prettyPrint();





	}
}
