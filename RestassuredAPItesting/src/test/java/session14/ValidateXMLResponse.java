package session14;

import org.testng.Assert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
public class ValidateXMLResponse {
	
	
	@Test(enabled =false)
	public void addpetjson() {
//		https://petstore.swagger.io/v2/pet
		String Jsonobject ="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://petstore.swagger.io");
		reqspec.basePath("/v2/pet");
		reqspec.header("accept", "application/json").header("Content-Type","application/json");
		reqspec.body(Jsonobject);
		
		Response response = reqspec.post();
		
		Assert.assertEquals(response.statusCode(),200,"Xheck your status code");
		
		response.prettyPrint();
		
	}
	
	@Test
	
	public void addpetxml() {
//		https://petstore.swagger.io/v2/pet
		String xmlobject ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://petstore.swagger.io");
		reqspec.basePath("/v2/pet");
		reqspec.header("accept", "application/xml").header("Content-Type","application/xml");
		reqspec.body(xmlobject);
		
		Response response = reqspec.post();
		
		Assert.assertEquals(response.statusCode(),200,"Xheck your status code");
		response.prettyPrint();
		//adding assertion using matchers classs
		
		response.then().body("//Pet.name", Matchers.equalTo("doggie"));

}
	
}
