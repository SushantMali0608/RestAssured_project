package Session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

	
@Test

public void gerSingleHeader() {
	RequestSpecification requestspecification = RestAssured.given();
	requestspecification.baseUri("https://restful-api.dev");
	requestspecification.basePath("/objects/7");
	
	//create get request
	Response response =requestspecification.get();
	
	// response header 
	
	String content_Type = response.header("content-type");
	
	System.out.println("Content_type " + content_Type);
	//getting all the values from header
	Headers headerList = response.getHeaders();
	
	for(Header header:headerList) {
		
		System.out.println(header.getName() + ":"+header.getValue());
	}
	
	// Validating contenttype
	Assert.assertEquals(content_Type, "text/html");
	
}
}
